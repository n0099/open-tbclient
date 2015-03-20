package com.baidu.tbadk.coreExtra.act;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class k implements SapiWebView.OnFinishCallback {
    final /* synthetic */ ForgetPwdActivity aap;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ForgetPwdActivity forgetPwdActivity) {
        this.aap = forgetPwdActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.aap.finish();
    }
}
