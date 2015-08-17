package com.baidu.tbadk.coreExtra.act;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements SapiWebView.OnBackCallback {
    final /* synthetic */ FillUProfileActivity agu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(FillUProfileActivity fillUProfileActivity) {
        this.agu = fillUProfileActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.agu.ags;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.agu.ags;
            sapiWebView2.goBack();
            return;
        }
        this.agu.finish();
    }
}
