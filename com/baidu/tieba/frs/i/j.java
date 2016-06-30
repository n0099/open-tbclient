package com.baidu.tieba.frs.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ h bSd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.bSd = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        if (this.bSd.bRJ == null) {
            return;
        }
        this.bSd.ZZ();
        this.bSd.bRY = true;
        h hVar = this.bSd;
        z = this.bSd.bRZ;
        hVar.dk(z);
    }
}
