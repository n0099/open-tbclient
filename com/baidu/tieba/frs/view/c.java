package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b brj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.brj = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.brj.bqA != null && this.brj.bqA.isShowing() && !this.brj.bra) {
            com.baidu.adp.lib.h.j.a(this.brj.bqA, this.brj.MR.getPageActivity());
        }
    }
}
