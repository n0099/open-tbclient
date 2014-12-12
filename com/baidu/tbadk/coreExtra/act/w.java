package com.baidu.tbadk.coreExtra.act;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements SapiWebView.OnBackCallback {
    final /* synthetic */ ForgetPwdActivity Ps;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(ForgetPwdActivity forgetPwdActivity) {
        this.Ps = forgetPwdActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.Ps.Pp;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.Ps.Pp;
            sapiWebView2.goBack();
            return;
        }
        this.Ps.finish();
    }
}
