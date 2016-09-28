package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class ah implements Runnable {
    final /* synthetic */ ag bQn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.bQn = agVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrsActivity frsActivity;
        bm bmVar;
        FrsActivity frsActivity2;
        frsActivity = this.bQn.bQi;
        bmVar = frsActivity.bPi;
        if (bmVar.ace()) {
            frsActivity2 = this.bQn.bQi;
            frsActivity2.abm();
        }
    }
}
