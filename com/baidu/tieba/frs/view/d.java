package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c cgX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cgX = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cgX.cgj != null && this.cgX.cgj.isShowing() && !this.cgX.cgI) {
            com.baidu.adp.lib.h.j.a(this.cgX.cgj, this.cgX.Gd.getPageActivity());
        }
    }
}
