package com.baidu.tbadk.coreExtra.act;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements SapiWebView.OnBackCallback {
    final /* synthetic */ ForgetPwdActivity aap;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ForgetPwdActivity forgetPwdActivity) {
        this.aap = forgetPwdActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.aap.aam;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.aap.aam;
            sapiWebView2.goBack();
            return;
        }
        this.aap.finish();
    }
}
