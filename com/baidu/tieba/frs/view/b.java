package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bdi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bdi = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bdi.bcC != null && this.bdi.bcC.isShowing() && !this.bdi.bcY) {
            com.baidu.adp.lib.g.j.a(this.bdi.bcC, this.bdi.mContext.getPageActivity());
        }
    }
}
