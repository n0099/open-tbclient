package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements Animation.AnimationListener {
    final /* synthetic */ co bJL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(co coVar) {
        this.bJL = coVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Runnable runnable;
        int i;
        com.baidu.adp.lib.g.h eE = com.baidu.adp.lib.g.h.eE();
        runnable = this.bJL.bJK;
        i = this.bJL.bJH;
        eE.postDelayed(runnable, i);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
