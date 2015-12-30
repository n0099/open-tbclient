package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bop;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bop = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bop.bnI != null && this.bop.bnI.isShowing() && !this.bop.bog) {
            com.baidu.adp.lib.h.j.a(this.bop.bnI, this.bop.mContext.getPageActivity());
        }
    }
}
