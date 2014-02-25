package com.baidu.tieba.account;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements SapiWebView.OnFinishCallback {
    final /* synthetic */ SapiFastRegActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(SapiFastRegActivity sapiFastRegActivity) {
        this.a = sapiFastRegActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.a.finish();
    }
}
