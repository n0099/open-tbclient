package com.baidu.tieba.frs.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ h cfi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.cfi = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        if (this.cfi.ceQ == null) {
            return;
        }
        this.cfi.afA();
        this.cfi.cfd = true;
        h hVar = this.cfi;
        z = this.cfi.cfe;
        hVar.dG(z);
    }
}
