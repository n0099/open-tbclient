package com.baidu.tbadk.coreExtra.act;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements SapiWebView.OnBackCallback {
    final /* synthetic */ FillUProfileActivity Kj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FillUProfileActivity fillUProfileActivity) {
        this.Kj = fillUProfileActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.Kj.Kh;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.Kj.Kh;
            sapiWebView2.goBack();
            return;
        }
        this.Kj.finish();
    }
}
