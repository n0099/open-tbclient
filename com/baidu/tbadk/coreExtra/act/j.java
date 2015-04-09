package com.baidu.tbadk.coreExtra.act;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements SapiWebView.OnBackCallback {
    final /* synthetic */ ForgetPwdActivity aar;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ForgetPwdActivity forgetPwdActivity) {
        this.aar = forgetPwdActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.aar.aao;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.aar.aao;
            sapiWebView2.goBack();
            return;
        }
        this.aar.finish();
    }
}
