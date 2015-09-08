package com.baidu.tbadk.coreExtra.act;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements Runnable {
    final /* synthetic */ LoginActivity agO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(LoginActivity loginActivity) {
        this.agO = loginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        try {
            sapiWebView = this.agO.agG;
            if (sapiWebView != null) {
                sapiWebView2 = this.agO.agG;
                sapiWebView2.destroy();
                this.agO.agG = null;
            }
        } catch (Throwable th) {
            BdLog.e(th);
        }
    }
}
