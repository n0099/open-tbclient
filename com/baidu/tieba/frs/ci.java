package com.baidu.tieba.frs;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci implements Animation.AnimationListener {
    final /* synthetic */ ce bQq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(ce ceVar) {
        this.bQq = ceVar;
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
        viewGroup = this.bQq.bQk;
        if (viewGroup != null) {
            viewGroup2 = this.bQq.bQk;
            viewGroup2.clearAnimation();
            viewGroup3 = this.bQq.bQk;
            viewGroup3.setVisibility(0);
            this.bQq.dl(false);
        }
    }
}
