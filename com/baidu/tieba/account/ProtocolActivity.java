package com.baidu.tieba.account;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.zeus.NotificationProxy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class ProtocolActivity extends com.baidu.tieba.e {
    private Button f = null;
    private TextView g = null;
    RelativeLayout c = null;
    LinearLayout d = null;
    TextView e = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_protocol_activity);
        i();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void i() {
        BufferedReader bufferedReader;
        this.c = (RelativeLayout) findViewById(R.id.container);
        this.d = (LinearLayout) findViewById(R.id.title);
        this.e = (TextView) findViewById(R.id.title_text);
        this.f = (Button) findViewById(R.id.back);
        this.f.setOnClickListener(new ai(this));
        this.g = (TextView) findViewById(R.id.text);
        StringBuilder sb = new StringBuilder((int) NotificationProxy.MAX_URL_LENGTH);
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
                        this.g.setText(sb.toString());
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
        this.g.setText(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.c.ae.c(this.e, i);
        com.baidu.tieba.c.ae.c((TextView) this.f, i);
        com.baidu.tieba.c.ae.b(this.c, i);
        com.baidu.tieba.c.ae.c(this.d, i);
        com.baidu.tieba.c.ae.e((TextView) this.f, i);
        com.baidu.tieba.c.ae.b(this.g, i);
    }
}
