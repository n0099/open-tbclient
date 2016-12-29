package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c bRo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bRo = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bRo.bQz != null && this.bRo.bQz.isShowing() && !this.bRo.bQY) {
            com.baidu.adp.lib.h.j.a(this.bRo.bQz, this.bRo.Gf.getPageActivity());
        }
    }
}
