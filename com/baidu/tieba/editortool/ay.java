package com.baidu.tieba.editortool;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class ay implements Animation.AnimationListener {
    private final /* synthetic */ az arW;
    private final /* synthetic */ ViewGroup arX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(az azVar, ViewGroup viewGroup) {
        this.arW = azVar;
        this.arX = viewGroup;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.arW != null) {
            this.arW.Ci();
        }
        this.arX.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.arX.setVisibility(8);
        if (this.arW != null) {
            this.arW.Cj();
        }
    }
}
