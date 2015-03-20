package com.baidu.tbadk.coreExtra.act;

import com.baidu.sapi2.SapiWebView;
/* loaded from: classes.dex */
class f implements SapiWebView.OnFinishCallback {
    final /* synthetic */ FillUProfileActivity aao;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(FillUProfileActivity fillUProfileActivity) {
        this.aao = fillUProfileActivity;
    }

    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
    public void onFinish() {
        this.aao.finish();
    }
}
