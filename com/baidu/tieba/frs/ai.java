package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class ai implements Runnable {
    final /* synthetic */ ah cdo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.cdo = ahVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        r rVar;
        r rVar2;
        r rVar3;
        rVar = this.cdo.cdl;
        if (rVar.ccj != null) {
            rVar2 = this.cdo.cdl;
            if (rVar2.ccj.WJ()) {
                rVar3 = this.cdo.cdl;
                rVar3.MG();
            }
        }
    }
}
