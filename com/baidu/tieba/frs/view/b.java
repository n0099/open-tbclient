package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.baidu.tbadk.TbPageContextSupport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Animation.AnimationListener {
    final /* synthetic */ a aGB;
    private final /* synthetic */ TbPageContextSupport aGC;
    private final /* synthetic */ float aGD;
    private final /* synthetic */ View ns;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, TbPageContextSupport tbPageContextSupport, View view, float f) {
        this.aGB = aVar;
        this.aGC = tbPageContextSupport;
        this.ns = view;
        this.aGD = f;
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
        com.baidu.tieba.tbadkCore.a.a(this.aGC, this.ns, scaleAnimation, new c(this, this.aGD, this.ns));
    }
}
