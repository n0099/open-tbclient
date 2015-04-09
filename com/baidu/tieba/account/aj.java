package com.baidu.tieba.account;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class aj implements SapiWebView.OnFinishCallback {
    final /* synthetic */ SapiFastRegActivity awm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(SapiFastRegActivity sapiFastRegActivity) {
        this.awm = sapiFastRegActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.awm.finish();
    }
}
