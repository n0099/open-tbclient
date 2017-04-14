package com.baidu.tieba.frs;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ck implements Animation.AnimationListener {
    final /* synthetic */ cg bQf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cg cgVar) {
        this.bQf = cgVar;
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
        viewGroup = this.bQf.bPZ;
        if (viewGroup != null) {
            viewGroup2 = this.bQf.bPZ;
            viewGroup2.clearAnimation();
            viewGroup3 = this.bQf.bPZ;
            viewGroup3.setVisibility(0);
            this.bQf.dn(false);
        }
    }
}
