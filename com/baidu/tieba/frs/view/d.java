package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c bXS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bXS = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bXS.bXd != null && this.bXS.bXd.isShowing() && !this.bXS.bXC) {
            com.baidu.adp.lib.g.j.a(this.bXS.bXd, this.bXS.Fp.getPageActivity());
        }
    }
}
