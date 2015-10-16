package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bdn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bdn = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bdn.bcH != null && this.bdn.bcH.isShowing() && !this.bdn.bdd) {
            com.baidu.adp.lib.g.j.a(this.bdn.bcH, this.bdn.mContext.getPageActivity());
        }
    }
}
