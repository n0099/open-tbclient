package com.baidu.tieba.account;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class ProtocolActivity extends com.baidu.tieba.g {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f844a = null;
    private TextView b = null;
    private RelativeLayout c = null;
    private View d = null;
    private TextView e = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_protocol_activity);
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b() {
        BufferedReader bufferedReader;
        this.c = (RelativeLayout) findViewById(R.id.container);
        this.d = findViewById(R.id.title);
        this.e = (TextView) findViewById(R.id.title_text);
        this.f844a = (ImageView) findViewById(R.id.back);
        this.f844a.setOnClickListener(new ae(this));
        this.b = (TextView) findViewById(R.id.text);
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
                        this.b.setText(sb.toString());
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
        this.b.setText(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        com.baidu.tieba.util.ah.f(this.e, i);
        com.baidu.tieba.util.ah.c(this.c, i);
        com.baidu.tieba.util.ah.d(this.d, i);
        com.baidu.tieba.util.ah.a(this.f844a, i);
        com.baidu.tieba.util.ah.b(this.b, i);
    }
}
