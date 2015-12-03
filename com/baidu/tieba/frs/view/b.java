package com.baidu.tieba.frs.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ a bky;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bky = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.bky.bjR != null && this.bky.bjR.isShowing() && !this.bky.bko) {
            com.baidu.adp.lib.h.j.a(this.bky.bjR, this.bky.mContext.getPageActivity());
        }
    }
}
