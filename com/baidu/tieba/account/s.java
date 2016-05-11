package com.baidu.tieba.account;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ ActivationActivity aIG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ActivationActivity activationActivity) {
        this.aIG = activationActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m11getInst().setUsed();
    }
}
