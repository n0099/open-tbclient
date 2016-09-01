package com.baidu.tieba.frs;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements Runnable {
    final /* synthetic */ FrsActivity bQp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FrsActivity frsActivity) {
        this.bQp = frsActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        bm bmVar;
        bmVar = this.bQp.bPo;
        bmVar.aby();
    }
}
