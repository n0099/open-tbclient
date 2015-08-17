package com.baidu.tieba.account;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements Runnable {
    final /* synthetic */ ActivationActivity aEn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ActivationActivity activationActivity) {
        this.aEn = activationActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m411getInst().setUsed();
    }
}
