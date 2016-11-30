package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c cme;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cme = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cme.clo != null && this.cme.clo.isShowing() && !this.cme.clN) {
            com.baidu.adp.lib.h.j.a(this.cme.clo, this.cme.Gf.getPageActivity());
        }
    }
}
