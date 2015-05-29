package com.baidu.tbadk.coreExtra.act;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements SapiWebView.OnBackCallback {
    final /* synthetic */ ForgetPwdActivity abt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ForgetPwdActivity forgetPwdActivity) {
        this.abt = forgetPwdActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.abt.abp;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.abt.abp;
            sapiWebView2.goBack();
            return;
        }
        this.abt.finish();
    }
}
