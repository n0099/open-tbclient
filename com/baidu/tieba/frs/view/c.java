package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b cjp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cjp = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cjp.ciD != null && this.cjp.ciD.isShowing() && !this.cjp.ciY) {
            com.baidu.adp.lib.g.j.a(this.cjp.ciD, this.cjp.aas.getPageActivity());
        }
    }
}
