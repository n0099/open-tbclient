package com.baidu.tieba.frs.i;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ h cfi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.cfi = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cfi.ceQ != null) {
            this.cfi.ceQ.NF();
        }
    }
}
