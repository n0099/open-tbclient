package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.baidu.tbadk.TbPageContextSupport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Animation.AnimationListener {
    final /* synthetic */ a aHI;
    private final /* synthetic */ TbPageContextSupport aHJ;
    private final /* synthetic */ float aHK;
    private final /* synthetic */ View nv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, TbPageContextSupport tbPageContextSupport, View view, float f) {
        this.aHI = aVar;
        this.aHJ = tbPageContextSupport;
        this.nv = view;
        this.aHK = f;
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
        com.baidu.tieba.tbadkCore.a.a(this.aHJ, this.nv, scaleAnimation, new c(this, this.aHK, this.nv));
    }
}
