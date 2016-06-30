package com.baidu.tieba.frs.i;

import android.view.animation.Animation;
import com.baidu.tieba.frs.entelechy.view.ao;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Animation.AnimationListener {
    final /* synthetic */ d bRI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.bRI = dVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ao aoVar;
        ao aoVar2;
        aoVar = this.bRI.bRC;
        aoVar.setVisibility(0);
        aoVar2 = this.bRI.bRC;
        aoVar2.clearAnimation();
    }
}
