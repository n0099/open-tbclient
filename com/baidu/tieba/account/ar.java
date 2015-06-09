package com.baidu.tieba.account;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class ar implements Runnable {
    final /* synthetic */ SapiFastRegActivity axT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(SapiFastRegActivity sapiFastRegActivity) {
        this.axT = sapiFastRegActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkCoreApplication.m411getInst().setUsed();
    }
}
