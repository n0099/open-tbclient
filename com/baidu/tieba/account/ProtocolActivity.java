package com.baidu.tieba.account;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.zeus.NotificationProxy;
import com.slidingmenu.lib.R;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class ProtocolActivity extends com.baidu.tieba.e {
    private ImageView c = null;
    private TextView d = null;
    private RelativeLayout e = null;
    private View f = null;
    private TextView g = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_protocol_activity);
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b() {
        BufferedReader bufferedReader;
        this.e = (RelativeLayout) findViewById(R.id.container);
        this.f = findViewById(R.id.title);
        this.g = (TextView) findViewById(R.id.title_text);
        this.c = (ImageView) findViewById(R.id.back);
        this.c.setOnClickListener(new ad(this));
        this.d = (TextView) findViewById(R.id.text);
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
                        this.d.setText(sb.toString());
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
        this.d.setText(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.d.ac.f(this.g, i);
        com.baidu.tieba.d.ac.c(this.e, i);
        com.baidu.tieba.d.ac.d(this.f, i);
        com.baidu.tieba.d.ac.a(this.c, i);
        com.baidu.tieba.d.ac.b(this.d, i);
    }
}
