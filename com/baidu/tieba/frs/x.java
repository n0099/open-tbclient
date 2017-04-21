package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ w bQc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.bQc = wVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        frsActivity = this.bQc.bQa;
        if (frsActivity.bOU != null) {
            frsActivity2 = this.bQc.bQa;
            if (frsActivity2.bOU.UW()) {
                frsActivity3 = this.bQc.bQa;
                frsActivity3.aaw();
            }
        }
    }
}
