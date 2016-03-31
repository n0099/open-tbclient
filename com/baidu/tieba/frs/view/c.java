package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b bwr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bwr = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bwr.bvD != null && this.bwr.bvD.isShowing() && !this.bwr.bwd) {
            com.baidu.adp.lib.h.j.a(this.bwr.bvD, this.bwr.MX.getPageActivity());
        }
    }
}
