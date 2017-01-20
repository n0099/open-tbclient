package com.baidu.tieba.card.a;

import android.view.View;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ a bnT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.bnT = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        FrameLayout frameLayout;
        Runnable runnable;
        view = this.bnT.aNh;
        view.setVisibility(0);
        frameLayout = this.bnT.aNe;
        frameLayout.setVisibility(8);
        com.baidu.adp.lib.g.h eE = com.baidu.adp.lib.g.h.eE();
        runnable = this.bnT.aNs;
        eE.postDelayed(runnable, 2000L);
    }
}
