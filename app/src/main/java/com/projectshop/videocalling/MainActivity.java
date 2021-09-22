package com.projectshop.videocalling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText secretcode;
    Button joinbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        secretcode= findViewById(R.id.text);
        joinbtn = findViewById(R.id.call);


        URL server;
        try {
            server = new URL("https://meet.jit.si");
            JitsiMeetConferenceOptions defaultOptions = new  JitsiMeetConferenceOptions.Builder()
                    .setServerURL(server)
                    .setWelcomePageEnabled(false)
                    .build();

            JitsiMeet.setDefaultConferenceOptions(defaultOptions);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
        joinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JitsiMeetConferenceOptions options = new  JitsiMeetConferenceOptions.Builder()
                        .setRoom(secretcode.getText().toString())
                        .setWelcomePageEnabled(false).build();
                JitsiMeetActivity.launch(MainActivity.this,options);
            }
        });


    }
}