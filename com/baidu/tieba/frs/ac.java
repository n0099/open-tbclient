package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements Runnable {
    final /* synthetic */ FrsActivity aUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(FrsActivity frsActivity) {
        this.aUS = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.tbadkCore.util.m.lM(this.aUS.aTU);
    }
}
