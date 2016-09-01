package com.baidu.tieba.homepage.personalize;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Animation.AnimationListener {
    final /* synthetic */ b this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar) {
        this.this$0 = bVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Runnable runnable;
        int i;
        com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
        runnable = this.this$0.cEQ;
        i = this.this$0.cEG;
        eG.postDelayed(runnable, i);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
