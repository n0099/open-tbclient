package com.baidu.tbadk.coreExtra.view;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class w implements Animation.AnimationListener {
    final /* synthetic */ v amD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.amD = vVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        u uVar;
        uVar = this.amD.amC;
        uVar.amn.setVisibility(8);
    }
}
