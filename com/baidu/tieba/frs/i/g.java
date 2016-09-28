package com.baidu.tieba.frs.i;

import android.view.animation.Animation;
import com.baidu.tieba.frs.entelechy.view.at;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Animation.AnimationListener {
    final /* synthetic */ d ceP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.ceP = dVar;
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
        atVar = this.ceP.ceJ;
        atVar.setVisibility(0);
        atVar2 = this.ceP.ceJ;
        atVar2.clearAnimation();
    }
}
