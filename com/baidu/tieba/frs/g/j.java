package com.baidu.tieba.frs.g;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ i cbv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.cbv = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cbv.cbb != null) {
            this.cbv.cbb.Sd();
        }
    }
}
