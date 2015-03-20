package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a aON;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aON = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.aON.aOb != null && this.aON.aOb.isShowing() && !this.aON.aOC) {
            com.baidu.adp.lib.g.k.a(this.aON.aOb, this.aON.LN.getPageActivity());
        }
    }
}
