package com.baidu.tieba.account;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ ActivationActivity aSr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ActivationActivity activationActivity) {
        this.aSr = activationActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m9getInst().setUsed();
    }
}
