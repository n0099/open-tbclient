package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ i cbx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.cbx = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cbx.cbf != null) {
            this.cbx.cbf.SA();
        }
    }
}
