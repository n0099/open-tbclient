package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c bTP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bTP = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bTP.bTc != null && this.bTP.bTc.isShowing() && !this.bTP.bTB) {
            com.baidu.adp.lib.h.j.a(this.bTP.bTc, this.bTP.Dp.getPageActivity());
        }
    }
}
