package com.baidu.tieba.account;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tieba.R;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class ProtocolActivity extends com.baidu.tieba.e {
    private Button b = null;
    private TextView c = null;

    /* JADX WARN: Removed duplicated region for block: B:38:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g() {
        BufferedReader bufferedReader;
        this.b = (Button) findViewById(R.id.back);
        this.b.setOnClickListener(new ai(this));
        this.c = (TextView) findViewById(R.id.text);
        StringBuilder sb = new StringBuilder(1024);
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.baidu_protocol), "unicode"));
            while (true) {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append("\n");
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        this.c.setText(sb.toString());
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
        this.c.setText(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_protocol_activity);
        g();
    }
}
