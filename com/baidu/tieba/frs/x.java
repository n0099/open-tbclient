package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ w bNW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.bNW = wVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        frsActivity = this.bNW.bNU;
        if (frsActivity.bMN != null) {
            frsActivity2 = this.bNW.bNU;
            if (frsActivity2.bMN.Tx()) {
                frsActivity3 = this.bNW.bNU;
                frsActivity3.YZ();
            }
        }
    }
}
