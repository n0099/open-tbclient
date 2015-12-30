package com.baidu.tbadk.coreExtra.view;

import android.view.animation.Animation;
/* loaded from: classes.dex */
class ab implements Animation.AnimationListener {
    final /* synthetic */ aa apG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.apG = aaVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        z zVar;
        zVar = this.apG.apF;
        zVar.apq.setVisibility(8);
    }
}
