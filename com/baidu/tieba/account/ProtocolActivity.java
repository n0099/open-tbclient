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
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_protocol_activity);
        a();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0081 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a() {
        BufferedReader bufferedReader;
        this.b = (RelativeLayout) findViewById(R.id.container);
        this.c = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        NavigationBar navigationBar = this.c;
        String string = getString(R.string.account_protocol);
        navigationBar.a(string);
        this.a = (TextView) findViewById(R.id.text);
        StringBuilder sb = new StringBuilder(1024);
        ?? r2 = 0;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.baidu_protocol), "unicode"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
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
                        this.a.setText(sb.toString());
                    }
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                th = th;
                r2 = string;
                if (r2 != 0) {
                    try {
                        r2.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            if (r2 != 0) {
            }
            throw th;
        }
        this.a.setText(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.c.c(i);
        com.baidu.tieba.util.bq.c(this.b, i);
        com.baidu.tieba.util.bq.b(this.a, i);
    }
}
