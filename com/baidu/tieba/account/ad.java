package com.baidu.tieba.account;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class ad implements SapiWebView.OnFinishCallback {
    final /* synthetic */ SapiFastRegActivity aof;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(SapiFastRegActivity sapiFastRegActivity) {
        this.aof = sapiFastRegActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.aof.finish();
    }
}
