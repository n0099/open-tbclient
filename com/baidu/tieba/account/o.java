package com.baidu.tieba.account;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class o implements Runnable {
    final /* synthetic */ ActivationActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ActivationActivity activationActivity) {
        this.aDW = activationActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m411getInst().setUsed();
    }
}
