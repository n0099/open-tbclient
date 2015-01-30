package com.baidu.tbadk.coreExtra.act;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class s implements SapiWebView.OnFinishCallback {
    final /* synthetic */ FillUProfileActivity PU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FillUProfileActivity fillUProfileActivity) {
        this.PU = fillUProfileActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.PU.finish();
    }
}
