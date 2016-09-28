package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements Runnable {
    final /* synthetic */ FrsActivity bQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(FrsActivity frsActivity) {
        this.bQi = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bm bmVar;
        bmVar = this.bQi.bPi;
        bmVar.abK();
    }
}
