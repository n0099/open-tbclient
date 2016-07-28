package com.baidu.tieba.account;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ ActivationActivity aMX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ActivationActivity activationActivity) {
        this.aMX = activationActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m10getInst().setUsed();
    }
}
