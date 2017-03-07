package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c cfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cfo = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cfo.ceB != null && this.cfo.ceB.isShowing() && !this.cfo.ceZ) {
            com.baidu.adp.lib.g.j.a(this.cfo.ceB, this.cfo.aaI.getPageActivity());
        }
    }
}
