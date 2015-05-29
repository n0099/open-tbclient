package com.baidu.tieba.account;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class ao implements SapiWebView.OnFinishCallback {
    final /* synthetic */ SapiFastRegActivity axS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(SapiFastRegActivity sapiFastRegActivity) {
        this.axS = sapiFastRegActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.axS.finish();
    }
}
