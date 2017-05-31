package com.baidu.tieba.frs.f;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ i chJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.chJ = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.chJ.chq != null) {
            this.chJ.chq.SM();
        }
    }
}
