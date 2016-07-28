package com.baidu.tieba.frs.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ h bUd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.bUd = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        if (this.bUd.bTJ == null) {
            return;
        }
        this.bUd.aaB();
        this.bUd.bTY = true;
        h hVar = this.bUd;
        z = this.bUd.bTZ;
        hVar.dh(z);
    }
}
