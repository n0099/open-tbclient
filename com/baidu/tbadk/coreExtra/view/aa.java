package com.baidu.tbadk.coreExtra.view;

import android.view.animation.AlphaAnimation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements Runnable {
    final /* synthetic */ z apF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar) {
        this.apF = zVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setAnimationListener(new ab(this));
        this.apF.apq.startAnimation(alphaAnimation);
    }
}
