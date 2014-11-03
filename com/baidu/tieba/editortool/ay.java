package com.baidu.tieba.editortool;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* loaded from: classes.dex */
class ay implements Animation.AnimationListener {
    private final /* synthetic */ az asf;
    private final /* synthetic */ ViewGroup asg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(az azVar, ViewGroup viewGroup) {
        this.asf = azVar;
        this.asg = viewGroup;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (this.asf != null) {
            this.asf.Ck();
        }
        this.asg.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.asg.setVisibility(8);
        if (this.asf != null) {
            this.asf.Cl();
        }
    }
}
