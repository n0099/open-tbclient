package com.baidu.tieba.account;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class ai implements Runnable {
    final /* synthetic */ SapiFastRegActivity aFk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SapiFastRegActivity sapiFastRegActivity) {
        this.aFk = sapiFastRegActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m411getInst().setUsed();
    }
}
