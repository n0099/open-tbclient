package com.baidu.tieba.frs;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements Animation.AnimationListener {
    final /* synthetic */ ce bQq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(ce ceVar) {
        this.bQq = ceVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        viewGroup = this.bQq.bQk;
        if (viewGroup != null) {
            viewGroup2 = this.bQq.bQk;
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
        viewGroup = this.bQq.bQk;
        if (viewGroup != null) {
            viewGroup2 = this.bQq.bQk;
            viewGroup2.clearAnimation();
            this.bQq.dl(true);
        }
    }
}
