package com.baidu.tieba.frs;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements Animation.AnimationListener {
    final /* synthetic */ cg bSw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cg cgVar) {
        this.bSw = cgVar;
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
        viewGroup = this.bSw.bSq;
        if (viewGroup != null) {
            viewGroup2 = this.bSw.bSq;
            viewGroup2.clearAnimation();
            viewGroup3 = this.bSw.bSq;
            viewGroup3.setVisibility(0);
            this.bSw.dx(false);
        }
    }
}
