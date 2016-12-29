package com.baidu.tieba.frs.h;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ i bPb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.bPb = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bPb.bOL != null) {
            this.bPb.bOL.NU();
        }
    }
}
