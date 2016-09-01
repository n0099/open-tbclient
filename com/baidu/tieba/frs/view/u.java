package com.baidu.tieba.frs.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Animation.AnimationListener {
    final /* synthetic */ t chN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.chN = tVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (animation == this.chN.chJ) {
            this.chN.mState = 0;
            return;
        }
        this.chN.mState = 1;
        this.chN.bo(8000L);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
