package com.baidu.tieba.homepage.framework.b;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Animation.AnimationListener {
    final /* synthetic */ a csy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.csy = aVar;
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
        view = this.csy.csx;
        if (view != null) {
            view2 = this.csy.csx;
            view2.clearAnimation();
            view3 = this.csy.csx;
            view3.setVisibility(8);
            this.csy.ds(true);
        }
    }
}
