package com.baidu.tbadk;

import com.baidu.bdcvf.CertVerifier;
/* loaded from: classes.dex */
final class q implements CertVerifier.ResultListener {
    final /* synthetic */ TbadkApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(TbadkApplication tbadkApplication) {
        this.a = tbadkApplication;
    }

    @Override // com.baidu.bdcvf.CertVerifier.ResultListener
    public final void onVerifyOK() {
        this.a.q = true;
    }

    @Override // com.baidu.bdcvf.CertVerifier.ResultListener
    public final void onVerifyFail(int i) {
        this.a.q = false;
    }
}
