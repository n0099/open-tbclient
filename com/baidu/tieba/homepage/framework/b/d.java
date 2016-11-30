package com.baidu.tieba.homepage.framework.b;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Animation.AnimationListener {
    final /* synthetic */ a cJy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.cJy = aVar;
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
        view = this.cJy.cJx;
        if (view != null) {
            view2 = this.cJy.cJx;
            view2.clearAnimation();
            view3 = this.cJy.cJx;
            view3.setVisibility(0);
            this.cJy.dw(false);
        }
    }
}
