package com.baidu.tieba.homepage.framework.b;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Animation.AnimationListener {
    final /* synthetic */ a cvU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.cvU = aVar;
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
        view = this.cvU.cvT;
        if (view != null) {
            view2 = this.cvU.cvT;
            view2.clearAnimation();
            view3 = this.cvU.cvT;
            view3.setVisibility(8);
            this.cvU.dn(true);
        }
    }
}
