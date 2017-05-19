package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ b cdb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cdb = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cdb.ccp != null && this.cdb.ccp.isShowing() && !this.cdb.ccK) {
            com.baidu.adp.lib.g.j.a(this.cdb.ccp, this.cdb.aat.getPageActivity());
        }
    }
}
