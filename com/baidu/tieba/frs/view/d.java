package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c bwe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bwe = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bwe.bvr != null && this.bwe.bvr.isShowing() && !this.bwe.bvQ) {
            com.baidu.adp.lib.h.j.a(this.bwe.bvr, this.bwe.Do.getPageActivity());
        }
    }
}
