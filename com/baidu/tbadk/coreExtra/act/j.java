package com.baidu.tbadk.coreExtra.act;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements SapiWebView.OnBackCallback {
    final /* synthetic */ ForgetPwdActivity agF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ForgetPwdActivity forgetPwdActivity) {
        this.agF = forgetPwdActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.agF.agC;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.agF.agC;
            sapiWebView2.goBack();
            return;
        }
        this.agF.finish();
    }
}
