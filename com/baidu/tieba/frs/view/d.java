package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c cgf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cgf = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cgf.cfs != null && this.cgf.cfs.isShowing() && !this.cgf.cfQ) {
            com.baidu.adp.lib.g.j.a(this.cgf.cfs, this.cgf.aaY.getPageActivity());
        }
    }
}
