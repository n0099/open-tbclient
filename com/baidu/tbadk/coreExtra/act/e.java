package com.baidu.tbadk.coreExtra.act;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements SapiWebView.OnBackCallback {
    final /* synthetic */ FillUProfileActivity aaq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FillUProfileActivity fillUProfileActivity) {
        this.aaq = fillUProfileActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.aaq.aao;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.aaq.aao;
            sapiWebView2.goBack();
            return;
        }
        this.aaq.finish();
    }
}
