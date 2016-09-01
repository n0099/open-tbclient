package com.baidu.tbadk.coreExtra.view;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class w implements Animation.AnimationListener {
    final /* synthetic */ v arf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.arf = vVar;
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
        uVar = this.arf.are;
        uVar.aqP.setVisibility(8);
    }
}
