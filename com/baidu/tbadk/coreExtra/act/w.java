package com.baidu.tbadk.coreExtra.act;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements SapiWebView.OnBackCallback {
    final /* synthetic */ ForgetPwdActivity PV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(ForgetPwdActivity forgetPwdActivity) {
        this.PV = forgetPwdActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.PV.PR;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.PV.PR;
            sapiWebView2.goBack();
            return;
        }
        this.PV.finish();
    }
}
