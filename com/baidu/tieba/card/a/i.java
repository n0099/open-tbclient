package com.baidu.tieba.card.a;

import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ a bDM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.bDM = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        FrameLayout frameLayout;
        Runnable runnable;
        view = this.bDM.bDE;
        view.setVisibility(0);
        frameLayout = this.bDM.bDB;
        frameLayout.setVisibility(8);
        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
        runnable = this.bDM.bBM;
        fR.postDelayed(runnable, 2000L);
    }
}
