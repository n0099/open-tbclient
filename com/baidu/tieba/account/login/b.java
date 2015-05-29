package com.baidu.tieba.account.login;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ Login2Activity ayM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Login2Activity login2Activity) {
        this.ayM = login2Activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m411getInst().setUsed();
    }
}
