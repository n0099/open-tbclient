package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b crq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.crq = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.crq.cqD != null && this.crq.cqD.isShowing() && !this.crq.cqY) {
            com.baidu.adp.lib.g.j.a(this.crq.cqD, this.crq.aat.getPageActivity());
        }
    }
}
