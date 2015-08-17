package com.baidu.tbadk.coreExtra.act;

import com.baidu.sapi2.SapiWebView;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends TimerTask {
    final /* synthetic */ LoginActivity agE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(LoginActivity loginActivity) {
        this.agE = loginActivity;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.agE.agw;
        if (sapiWebView != null) {
            sapiWebView2 = this.agE.agw;
            sapiWebView2.destroy();
            this.agE.agw = null;
        }
    }
}
