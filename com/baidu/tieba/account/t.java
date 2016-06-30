package com.baidu.tieba.account;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ ActivationActivity aMd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ActivationActivity activationActivity) {
        this.aMd = activationActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m9getInst().setUsed();
    }
}
