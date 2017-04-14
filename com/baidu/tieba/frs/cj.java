package com.baidu.tieba.frs;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements Animation.AnimationListener {
    final /* synthetic */ cg bQf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(cg cgVar) {
        this.bQf = cgVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        viewGroup = this.bQf.bPZ;
        if (viewGroup != null) {
            viewGroup2 = this.bQf.bPZ;
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
        viewGroup = this.bQf.bPZ;
        if (viewGroup != null) {
            viewGroup2 = this.bQf.bPZ;
            viewGroup2.clearAnimation();
            this.bQf.dn(true);
        }
    }
}
