package com.baidu.tieba.frs.i;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ h bSd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bSd = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bSd.bRJ != null) {
            this.bSd.bRJ.KD();
        }
    }
}
