package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ w bNL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.bNL = wVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        frsActivity = this.bNL.bNJ;
        if (frsActivity.bMD != null) {
            frsActivity2 = this.bNL.bNJ;
            if (frsActivity2.bMD.TV()) {
                frsActivity3 = this.bNL.bNJ;
                frsActivity3.Zv();
            }
        }
    }
}
