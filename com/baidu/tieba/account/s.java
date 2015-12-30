package com.baidu.tieba.account;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ ActivationActivity aIw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ActivationActivity activationActivity) {
        this.aIw = activationActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m411getInst().setUsed();
    }
}
