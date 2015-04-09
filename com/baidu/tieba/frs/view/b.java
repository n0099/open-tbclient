package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aPe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aPe = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aPe.aOs != null && this.aPe.aOs.isShowing() && !this.aPe.aOT) {
            com.baidu.adp.lib.g.k.a(this.aPe.aOs, this.aPe.LP.getPageActivity());
        }
    }
}
