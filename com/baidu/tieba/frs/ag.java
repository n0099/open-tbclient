package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class ag implements Runnable {
    final /* synthetic */ af bEP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.bEP = afVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrsActivity frsActivity;
        bq bqVar;
        FrsActivity frsActivity2;
        frsActivity = this.bEP.bEL;
        bqVar = frsActivity.bDK;
        if (bqVar.WV()) {
            frsActivity2 = this.bEP.bEL;
            frsActivity2.Wd();
        }
    }
}
