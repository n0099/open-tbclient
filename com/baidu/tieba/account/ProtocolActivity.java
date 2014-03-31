package com.baidu.tieba.account;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class ProtocolActivity extends com.baidu.tbadk.a {
    private TextView a = null;
    private RelativeLayout b = null;
    private NavigationBar c;

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0083 */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v3 */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onCreate(Bundle bundle) {
        BufferedReader bufferedReader;
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.a.i.account_protocol_activity);
        this.b = (RelativeLayout) findViewById(com.baidu.tieba.a.h.container);
        this.c = (NavigationBar) findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        NavigationBar navigationBar = this.c;
        String string = getString(com.baidu.tieba.a.k.account_protocol);
        navigationBar.a(string);
        this.a = (TextView) findViewById(com.baidu.tieba.a.h.text);
        StringBuilder sb = new StringBuilder(1024);
        ?? r2 = 0;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(com.baidu.tieba.a.j.baidu_protocol), "unicode"));
                while (true) {
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
                }
                bufferedReader.close();
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
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.c.b(i);
        ba.c(this.b, i);
        ba.b(this.a, i);
    }
}
