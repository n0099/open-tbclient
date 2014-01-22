package com.baidu.tieba.account;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class bs implements SapiWebView.OnFinishCallback {
    final /* synthetic */ SapiFastRegActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(SapiFastRegActivity sapiFastRegActivity) {
        this.a = sapiFastRegActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.a.finish();
    }
}
