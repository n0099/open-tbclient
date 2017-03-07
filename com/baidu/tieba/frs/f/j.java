package com.baidu.tieba.frs.f;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ i ccU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.ccU = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.ccU.ccA != null) {
            this.ccU.ccA.RF();
        }
    }
}
