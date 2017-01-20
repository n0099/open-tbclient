package com.baidu.tieba.frs;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci implements Animation.AnimationListener {
    final /* synthetic */ ce bJh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(ce ceVar) {
        this.bJh = ceVar;
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
        viewGroup = this.bJh.bJb;
        if (viewGroup != null) {
            viewGroup2 = this.bJh.bJb;
            viewGroup2.clearAnimation();
            viewGroup3 = this.bJh.bJb;
            viewGroup3.setVisibility(0);
            this.bJh.dl(false);
        }
    }
}
