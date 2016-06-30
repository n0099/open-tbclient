package com.baidu.tieba.frs.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Animation.AnimationListener {
    final /* synthetic */ t bUD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.bUD = tVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (animation == this.bUD.bUz) {
            this.bUD.mState = 0;
            return;
        }
        this.bUD.mState = 1;
        this.bUD.aX(8000L);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
