package com.baidu.tbadk.coreExtra.act;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class k implements SapiWebView.OnFinishCallback {
    final /* synthetic */ ForgetPwdActivity agF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ForgetPwdActivity forgetPwdActivity) {
        this.agF = forgetPwdActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.agF.finish();
    }
}
