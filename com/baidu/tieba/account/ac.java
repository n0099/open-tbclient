package com.baidu.tieba.account;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class ac implements SapiWebView.OnFinishCallback {
    final /* synthetic */ SapiFastRegActivity ank;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(SapiFastRegActivity sapiFastRegActivity) {
        this.ank = sapiFastRegActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.ank.finish();
    }
}
