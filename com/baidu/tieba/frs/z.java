package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements Runnable {
    final /* synthetic */ FrsActivity bNJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsActivity frsActivity) {
        this.bNJ = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.tbadkCore.util.l.qh(this.bNJ.bMu);
    }
}
