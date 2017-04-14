package com.baidu.tieba.card.a;

import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ a buH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.buH = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        FrameLayout frameLayout;
        Runnable runnable;
        view = this.buH.aTj;
        view.setVisibility(0);
        frameLayout = this.buH.aTg;
        frameLayout.setVisibility(8);
        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
        runnable = this.buH.aTu;
        fR.postDelayed(runnable, 2000L);
    }
}
