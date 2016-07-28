package com.baidu.tieba.homepage.personalize;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Animation.AnimationListener {
    final /* synthetic */ b ctz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar) {
        this.ctz = bVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Runnable runnable;
        int i;
        com.baidu.adp.lib.h.h dL = com.baidu.adp.lib.h.h.dL();
        runnable = this.ctz.ctk;
        i = this.ctz.cta;
        dL.postDelayed(runnable, i);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
