package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.baidu.tbadk.TbPageContextSupport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ b brj;
    private final /* synthetic */ TbPageContextSupport brk;
    private final /* synthetic */ float brl;
    private final /* synthetic */ View yW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar, TbPageContextSupport tbPageContextSupport, View view, float f) {
        this.brj = bVar;
        this.brk = tbPageContextSupport;
        this.yW = view;
        this.brl = f;
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
        com.baidu.tieba.tbadkCore.a.a(this.brk, this.yW, scaleAnimation, new g(this, this.brl, this.yW));
    }
}
