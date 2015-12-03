package com.baidu.tieba.account;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ ActivationActivity aGV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ActivationActivity activationActivity) {
        this.aGV = activationActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m411getInst().setUsed();
    }
}
