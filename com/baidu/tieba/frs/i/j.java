package com.baidu.tieba.frs.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ h cfl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.cfl = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        if (this.cfl.ceR == null) {
            return;
        }
        this.cfl.afm();
        this.cfl.cfg = true;
        h hVar = this.cfl;
        z = this.cfl.cfh;
        hVar.dF(z);
    }
}
