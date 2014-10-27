package com.baidu.tbadk.coreExtra.act;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class x implements SapiWebView.OnFinishCallback {
    final /* synthetic */ ForgetPwdActivity Kj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(ForgetPwdActivity forgetPwdActivity) {
        this.Kj = forgetPwdActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.Kj.finish();
    }
}
