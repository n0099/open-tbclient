package com.baidu.tieba.account;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class ProtocolActivity extends com.baidu.tieba.f {
    private TextView a = null;
    private RelativeLayout b = null;
    private NavigationBar c;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        BufferedReader bufferedReader;
        super.onCreate(bundle);
        setContentView(R.layout.account_protocol_activity);
        this.b = (RelativeLayout) findViewById(R.id.container);
        this.c = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.c.a(getString(R.string.account_protocol));
        this.a = (TextView) findViewById(R.id.text);
        StringBuilder sb = new StringBuilder(1024);
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.baidu_protocol), "unicode"));
            while (true) {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            try {
                                break;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            sb.append(readLine);
                            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        this.a.setText(sb.toString());
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            bufferedReader.close();
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
        this.a.setText(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.c.b(i);
        com.baidu.tieba.util.bq.c(this.b, i);
        com.baidu.tieba.util.bq.b(this.a, i);
    }
}
