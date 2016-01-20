package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements Runnable {
    final /* synthetic */ FrsActivity bed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(FrsActivity frsActivity) {
        this.bed = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.tbadkCore.util.m.my(this.bed.bde);
    }
}
