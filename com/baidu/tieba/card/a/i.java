package com.baidu.tieba.card.a;

import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ a buP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.buP = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        FrameLayout frameLayout;
        Runnable runnable;
        view = this.buP.aSU;
        view.setVisibility(0);
        frameLayout = this.buP.aSR;
        frameLayout.setVisibility(8);
        com.baidu.adp.lib.g.h fM = com.baidu.adp.lib.g.h.fM();
        runnable = this.buP.aTf;
        fM.postDelayed(runnable, 2000L);
    }
}
