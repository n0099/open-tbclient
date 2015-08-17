package com.baidu.tieba.account;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class af implements SapiWebView.OnFinishCallback {
    final /* synthetic */ SapiFastRegActivity aFk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(SapiFastRegActivity sapiFastRegActivity) {
        this.aFk = sapiFastRegActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.aFk.finish();
    }
}
