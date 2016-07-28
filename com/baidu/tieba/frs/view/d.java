package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c bVP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bVP = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bVP.bVc != null && this.bVP.bVc.isShowing() && !this.bVP.bVB) {
            com.baidu.adp.lib.h.j.a(this.bVP.bVc, this.bVP.DQ.getPageActivity());
        }
    }
}
