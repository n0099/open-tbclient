package com.baidu.tieba.frs;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dm implements Animation.AnimationListener {
    final /* synthetic */ dj bTx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dm(dj djVar) {
        this.bTx = djVar;
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
        view = this.bTx.bTt;
        if (view != null) {
            view2 = this.bTx.bTt;
            view2.clearAnimation();
            view3 = this.bTx.bTt;
            view3.setVisibility(0);
            this.bTx.dr(false);
        }
    }
}
