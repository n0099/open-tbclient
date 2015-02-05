package com.baidu.tbadk.coreExtra.act;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements SapiWebView.OnBackCallback {
    final /* synthetic */ FillUProfileActivity PQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FillUProfileActivity fillUProfileActivity) {
        this.PQ = fillUProfileActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
    public void onBack() {
        SapiWebView sapiWebView;
        SapiWebView sapiWebView2;
        sapiWebView = this.PQ.PO;
        if (sapiWebView.canGoBack()) {
            sapiWebView2 = this.PQ.PO;
            sapiWebView2.goBack();
            return;
        }
        this.PQ.finish();
    }
}
