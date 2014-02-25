package com.baidu.tieba;

import com.baidu.bdcvf.CertVerifier;
/* loaded from: classes.dex */
class au implements CertVerifier.ResultListener {
    final /* synthetic */ TiebaApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(TiebaApplication tiebaApplication) {
        this.a = tiebaApplication;
    }

    @Override // com.baidu.bdcvf.CertVerifier.ResultListener
    public void onVerifyOK() {
        this.a.O = true;
    }

    @Override // com.baidu.bdcvf.CertVerifier.ResultListener
    public void onVerifyFail(int i) {
        this.a.O = false;
    }
}
