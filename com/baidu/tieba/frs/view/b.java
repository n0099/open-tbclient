package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bcO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bcO = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bcO.bci != null && this.bcO.bci.isShowing() && !this.bcO.bcE) {
            com.baidu.adp.lib.g.j.a(this.bcO.bci, this.bcO.LS.getPageActivity());
        }
    }
}
