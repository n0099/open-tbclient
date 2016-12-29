package com.baidu.tieba.frs.h;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ i bPb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.bPb = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        if (this.bPb.bOL == null) {
            return;
        }
        this.bPb.abJ();
        this.bPb.bOW = true;
        i iVar = this.bPb;
        z = this.bPb.bOX;
        iVar.du(z);
    }
}
