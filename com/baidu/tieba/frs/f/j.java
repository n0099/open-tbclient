package com.baidu.tieba.frs.f;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ i bVC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.bVC = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bVC.bVi != null) {
            this.bVC.bVi.QN();
        }
    }
}
