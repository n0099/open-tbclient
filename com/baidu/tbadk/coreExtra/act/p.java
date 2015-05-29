package com.baidu.tbadk.coreExtra.act;

import com.baidu.sapi2.SapiWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements SapiWebView.OnFinishCallback {
    final /* synthetic */ LoginActivity abx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(LoginActivity loginActivity) {
        this.abx = loginActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.abx.finish();
    }
}
