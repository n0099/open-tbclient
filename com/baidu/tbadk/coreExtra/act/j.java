package com.baidu.tbadk.coreExtra.act;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements SapiWebView.OnBackCallback {
    final /* synthetic */ ForgetPwdActivity agv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ForgetPwdActivity forgetPwdActivity) {
        this.agv = forgetPwdActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.agv.ags;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.agv.ags;
            sapiWebView2.goBack();
            return;
        }
        this.agv.finish();
    }
}
