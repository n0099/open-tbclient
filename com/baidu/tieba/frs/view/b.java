package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bdc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bdc = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bdc.bcw != null && this.bdc.bcw.isShowing() && !this.bdc.bcS) {
            com.baidu.adp.lib.g.j.a(this.bdc.bcw, this.bdc.mContext.getPageActivity());
        }
    }
}
