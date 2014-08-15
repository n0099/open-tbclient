package com.baidu.tbadk;

import com.baidu.bdcvf.CertVerifier;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements CertVerifier.ResultListener {
    final /* synthetic */ TbadkApplication a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(TbadkApplication tbadkApplication) {
        this.a = tbadkApplication;
    }

    @Override // com.baidu.bdcvf.CertVerifier.ResultListener
    public void onVerifyOK() {
        this.a.mIsOfficial = true;
    }

    @Override // com.baidu.bdcvf.CertVerifier.ResultListener
    public void onVerifyFail(int i) {
        this.a.mIsOfficial = false;
    }
}
