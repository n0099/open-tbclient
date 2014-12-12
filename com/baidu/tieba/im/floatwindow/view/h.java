package com.baidu.tieba.im.floatwindow.view;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.lib.g.e {
    final /* synthetic */ f aYr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.aYr = fVar;
    }

    @Override // com.baidu.adp.lib.g.e, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.aYr.aYl = true;
    }

    @Override // com.baidu.adp.lib.g.e, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        Animation animation2;
        this.aYr.aYl = false;
        animation2 = this.aYr.aYo;
        if (animation == animation2 && this.aYr.Nm()) {
            this.aYr.No();
        }
    }
}
