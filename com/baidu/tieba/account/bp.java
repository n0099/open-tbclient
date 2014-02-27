package com.baidu.tieba.account;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
final class bp implements SapiWebView.OnFinishCallback {
    final /* synthetic */ SapiFastRegActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(SapiFastRegActivity sapiFastRegActivity) {
        this.a = sapiFastRegActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public final void onFinish() {
        this.a.finish();
    }
}
