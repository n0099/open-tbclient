package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class ai implements Runnable {
    final /* synthetic */ ah bVf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.bVf = ahVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        r rVar;
        r rVar2;
        r rVar3;
        rVar = this.bVf.bVb;
        if (rVar.bUa != null) {
            rVar2 = this.bVf.bVb;
            if (rVar2.bUa.Vs()) {
                rVar3 = this.bVf.bVb;
                rVar3.LS();
            }
        }
    }
}
