package com.baidu.tieba.account;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class z implements Runnable {
    final /* synthetic */ ActivationActivity awV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(ActivationActivity activationActivity) {
        this.awV = activationActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m411getInst().setUsed();
    }
}
