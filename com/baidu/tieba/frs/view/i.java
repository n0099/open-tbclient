package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.baidu.tbadk.TbPageContextSupport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Animation.AnimationListener {
    final /* synthetic */ c bXS;
    private final /* synthetic */ TbPageContextSupport bXT;
    private final /* synthetic */ float bXU;
    private final /* synthetic */ View sg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar, TbPageContextSupport tbPageContextSupport, View view, float f) {
        this.bXS = cVar;
        this.bXT = tbPageContextSupport;
        this.sg = view;
        this.bXU = f;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(300L);
        com.baidu.tieba.tbadkCore.a.a(this.bXT, this.sg, scaleAnimation, new j(this, this.bXU, this.sg));
    }
}
