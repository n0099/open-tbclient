package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class x implements Runnable {
    final /* synthetic */ w bGN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.bGN = wVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        FrsActivity frsActivity3;
        frsActivity = this.bGN.bGL;
        if (frsActivity.bFF != null) {
            frsActivity2 = this.bGN.bGL;
            if (frsActivity2.bFF.Sx()) {
                frsActivity3 = this.bGN.bGL;
                frsActivity3.Ya();
            }
        }
    }
}
