package com.baidu.tbadk.coreExtra.view;

import android.view.animation.AlphaAnimation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements Runnable {
    final /* synthetic */ u arI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.arI = uVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setAnimationListener(new w(this));
        this.arI.ars.startAnimation(alphaAnimation);
    }
}
