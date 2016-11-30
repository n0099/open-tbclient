package com.baidu.tieba.frs;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements Animation.AnimationListener {
    final /* synthetic */ ch bVG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ch chVar) {
        this.bVG = chVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        viewGroup = this.bVG.bVz;
        if (viewGroup != null) {
            viewGroup2 = this.bVG.bVz;
            viewGroup2.clearAnimation();
            viewGroup3 = this.bVG.bVz;
            viewGroup3.setVisibility(0);
            this.bVG.dw(false);
        }
    }
}
