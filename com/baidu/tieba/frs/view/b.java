package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aRp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aRp = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aRp.aQD != null && this.aRp.aQD.isShowing() && !this.aRp.aRe) {
            com.baidu.adp.lib.g.k.a(this.aRp.aQD, this.aRp.LH.getPageActivity());
        }
    }
}
