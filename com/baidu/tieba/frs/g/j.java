package com.baidu.tieba.frs.g;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ i cdM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.cdM = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cdM.cds != null) {
            this.cdM.cds.Tf();
        }
    }
}
