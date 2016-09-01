package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class ah implements Runnable {
    final /* synthetic */ ag bQu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.bQu = agVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrsActivity frsActivity;
        bm bmVar;
        FrsActivity frsActivity2;
        frsActivity = this.bQu.bQp;
        bmVar = frsActivity.bPo;
        if (bmVar.abR()) {
            frsActivity2 = this.bQu.bQp;
            frsActivity2.aba();
        }
    }
}
