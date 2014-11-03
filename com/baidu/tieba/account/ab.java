package com.baidu.tieba.account;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class ab implements SapiWebView.OnFinishCallback {
    final /* synthetic */ SapiFastRegActivity afT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(SapiFastRegActivity sapiFastRegActivity) {
        this.afT = sapiFastRegActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.afT.finish();
    }
}
