package com.baidu.tieba.frs;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements Animation.AnimationListener {
    final /* synthetic */ ch bVG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(ch chVar) {
        this.bVG = chVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        viewGroup = this.bVG.bVz;
        if (viewGroup != null) {
            viewGroup2 = this.bVG.bVz;
            viewGroup2.setVisibility(8);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        viewGroup = this.bVG.bVz;
        if (viewGroup != null) {
            viewGroup2 = this.bVG.bVz;
            viewGroup2.clearAnimation();
            this.bVG.dw(true);
        }
    }
}
