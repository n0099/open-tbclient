package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bdS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bdS = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bdS.bdm != null && this.bdS.bdm.isShowing() && !this.bdS.bdI) {
            com.baidu.adp.lib.g.j.a(this.bdS.bdm, this.bdS.mContext.getPageActivity());
        }
    }
}
