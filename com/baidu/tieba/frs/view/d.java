package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c cdO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cdO = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cdO.cdb != null && this.cdO.cdb.isShowing() && !this.cdO.cdz) {
            com.baidu.adp.lib.g.j.a(this.cdO.cdb, this.cdO.aaX.getPageActivity());
        }
    }
}
