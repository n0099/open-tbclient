package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.baidu.tbadk.TbPageContextSupport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Animation.AnimationListener {
    final /* synthetic */ c cme;
    private final /* synthetic */ TbPageContextSupport cmf;
    private final /* synthetic */ float cmg;
    private final /* synthetic */ View sq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar, TbPageContextSupport tbPageContextSupport, View view, float f) {
        this.cme = cVar;
        this.cmf = tbPageContextSupport;
        this.sq = view;
        this.cmg = f;
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
        com.baidu.tieba.tbadkCore.a.a(this.cmf, this.sq, scaleAnimation, new j(this, this.cmg, this.sq));
    }
}
