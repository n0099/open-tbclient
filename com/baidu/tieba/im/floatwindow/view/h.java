package com.baidu.tieba.im.floatwindow.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.lib.g.e {
    final /* synthetic */ f aZM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.aZM = fVar;
    }

    @Override // com.baidu.adp.lib.g.e, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.aZM.aZG = true;
    }

    @Override // com.baidu.adp.lib.g.e, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Animation animation2;
        this.aZM.aZG = false;
        animation2 = this.aZM.aZJ;
        if (animation == animation2 && this.aZM.ND()) {
            this.aZM.NF();
        }
    }
}
