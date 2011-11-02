package com.baidu.tieba.account;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class ProtocolActivity extends BaseActivity {
    private Button mButtonBack = null;
    private TextView mText = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_protocol_activity);
        initUI();
    }

    private void initUI() {
        this.mButtonBack = (Button) findViewById(R.id.back);
        this.mButtonBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.account.ProtocolActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ProtocolActivity.this.finish();
            }
        });
        this.mText = (TextView) findViewById(R.id.text);
        StringBuilder text = new StringBuilder(1024);
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.baidu_protocol);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "unicode"));
            while (true) {
                String lines = reader.readLine();
                if (lines == null) {
                    break;
                }
                text.append(lines);
                text.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mText.setText(text.toString());
    }
}
