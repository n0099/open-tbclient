package com.baidu.tieba.card.a;

import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ a bwY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.bwY = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        FrameLayout frameLayout;
        Runnable runnable;
        view = this.bwY.aTl;
        view.setVisibility(0);
        frameLayout = this.bwY.aTi;
        frameLayout.setVisibility(8);
        com.baidu.adp.lib.g.h fS = com.baidu.adp.lib.g.h.fS();
        runnable = this.bwY.aTw;
        fS.postDelayed(runnable, 2000L);
    }
}
