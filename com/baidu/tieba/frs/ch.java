package com.baidu.tieba.frs;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements Animation.AnimationListener {
    final /* synthetic */ ce bJh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(ce ceVar) {
        this.bJh = ceVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        viewGroup = this.bJh.bJb;
        if (viewGroup != null) {
            viewGroup2 = this.bJh.bJb;
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
        viewGroup = this.bJh.bJb;
        if (viewGroup != null) {
            viewGroup2 = this.bJh.bJb;
            viewGroup2.clearAnimation();
            this.bJh.dl(true);
        }
    }
}
