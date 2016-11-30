package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ t bTc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.bTc = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        frsActivity = this.bTc.bTa;
        if (frsActivity.bRW != null) {
            frsActivity2 = this.bTc.bTa;
            if (frsActivity2.bRW.adl()) {
                frsActivity3 = this.bTc.bTa;
                frsActivity3.acw();
            }
        }
    }
}
