package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.baidu.tbadk.TbPageContextSupport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Animation.AnimationListener {
    final /* synthetic */ a aHL;
    private final /* synthetic */ TbPageContextSupport aHM;
    private final /* synthetic */ float aHN;
    private final /* synthetic */ View nv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, TbPageContextSupport tbPageContextSupport, View view, float f) {
        this.aHL = aVar;
        this.aHM = tbPageContextSupport;
        this.nv = view;
        this.aHN = f;
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
        com.baidu.tieba.tbadkCore.a.a(this.aHM, this.nv, scaleAnimation, new c(this, this.aHN, this.nv));
    }
}
