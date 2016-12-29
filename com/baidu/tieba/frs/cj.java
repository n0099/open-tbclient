package com.baidu.tieba.frs;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements Animation.AnimationListener {
    final /* synthetic */ cg bBO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(cg cgVar) {
        this.bBO = cgVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        viewGroup = this.bBO.bBH;
        if (viewGroup != null) {
            viewGroup2 = this.bBO.bBH;
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
        viewGroup = this.bBO.bBH;
        if (viewGroup != null) {
            viewGroup2 = this.bBO.bBH;
            viewGroup2.clearAnimation();
            this.bBO.de(true);
        }
    }
}
