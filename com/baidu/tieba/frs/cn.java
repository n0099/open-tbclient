package com.baidu.tieba.frs;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cn implements Animation.AnimationListener {
    final /* synthetic */ cj cfp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(cj cjVar) {
        this.cfp = cjVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Runnable runnable;
        int i;
        com.baidu.adp.lib.g.h fR = com.baidu.adp.lib.g.h.fR();
        runnable = this.cfp.cfo;
        i = this.cfp.cfl;
        fR.postDelayed(runnable, i);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
