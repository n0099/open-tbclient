package com.baidu.tieba.frs.i;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ h cfl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.cfl = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cfl.ceR != null) {
            this.cfl.ceR.Ne();
        }
    }
}
