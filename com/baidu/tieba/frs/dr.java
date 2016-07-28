package com.baidu.tieba.frs;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dr implements Animation.AnimationListener {
    final /* synthetic */ Cdo bIC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(Cdo cdo) {
        this.bIC = cdo;
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
        view = this.bIC.bIu;
        if (view != null) {
            view2 = this.bIC.bIu;
            view2.clearAnimation();
            view3 = this.bIC.bIu;
            view3.setVisibility(0);
            this.bIC.ds(false);
        }
    }
}
