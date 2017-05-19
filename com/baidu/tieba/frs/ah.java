package com.baidu.tieba.frs;
/* loaded from: classes.dex */
class ah implements Runnable {
    final /* synthetic */ ag bPp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.bPp = agVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        r rVar;
        r rVar2;
        r rVar3;
        rVar = this.bPp.bPn;
        if (rVar.bOn != null) {
            rVar2 = this.bPp.bPn;
            if (rVar2.bOn.Up()) {
                rVar3 = this.bPp.bPn;
                rVar3.Zs();
            }
        }
    }
}
