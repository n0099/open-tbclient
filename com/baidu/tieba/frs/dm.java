package com.baidu.tieba.frs;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dm implements Animation.AnimationListener {
    final /* synthetic */ dj bTE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dm(dj djVar) {
        this.bTE = djVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        View view2;
        View view3;
        view = this.bTE.bTA;
        if (view != null) {
            view2 = this.bTE.bTA;
            view2.clearAnimation();
            view3 = this.bTE.bTA;
            view3.setVisibility(0);
            this.bTE.dq(false);
        }
    }
}
