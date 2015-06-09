package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aRq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aRq = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aRq.aQE != null && this.aRq.aQE.isShowing() && !this.aRq.aRf) {
            com.baidu.adp.lib.g.k.a(this.aRq.aQE, this.aRq.LH.getPageActivity());
        }
    }
}
