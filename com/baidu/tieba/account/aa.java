package com.baidu.tieba.account;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class aa implements SapiWebView.OnFinishCallback {
    final /* synthetic */ SapiFastRegActivity aGg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(SapiFastRegActivity sapiFastRegActivity) {
        this.aGg = sapiFastRegActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.aGg.finish();
    }
}
