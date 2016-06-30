package com.baidu.tieba.frs;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dq implements Animation.AnimationListener {
    final /* synthetic */ Cdo bHg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dq(Cdo cdo) {
        this.bHg = cdo;
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
        view = this.bHg.bGY;
        if (view != null) {
            view2 = this.bHg.bGY;
            view2.clearAnimation();
            view3 = this.bHg.bGY;
            view3.setVisibility(8);
            this.bHg.dv(true);
        }
    }
}
