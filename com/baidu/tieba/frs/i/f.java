package com.baidu.tieba.frs.i;

import android.view.animation.Animation;
import com.baidu.tieba.frs.entelechy.view.at;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ d ceQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.ceQ = dVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        at atVar;
        at atVar2;
        atVar = this.ceQ.ceK;
        atVar.setVisibility(8);
        atVar2 = this.ceQ.ceK;
        atVar2.clearAnimation();
    }
}
