package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cw implements Animation.AnimationListener {
    final /* synthetic */ cs bCv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(cs csVar) {
        this.bCv = csVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Runnable runnable;
        int i;
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        runnable = this.bCv.bCu;
        i = this.bCv.bCr;
        eG.postDelayed(runnable, i);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
