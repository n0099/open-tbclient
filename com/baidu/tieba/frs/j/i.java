package com.baidu.tieba.frs.j;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ h bUd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.bUd = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bUd.bTJ != null) {
            this.bUd.bTJ.KC();
        }
    }
}
