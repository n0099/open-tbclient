package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c cgZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cgZ = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.cgZ.cgl != null && this.cgZ.cgl.isShowing() && !this.cgZ.cgK) {
            com.baidu.adp.lib.h.j.a(this.cgZ.cgl, this.cgZ.Gd.getPageActivity());
        }
    }
}
