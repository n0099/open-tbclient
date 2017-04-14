package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.baidu.tbadk.TbPageContextSupport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Animation.AnimationListener {
    final /* synthetic */ c cdO;
    private final /* synthetic */ TbPageContextSupport cdP;
    private final /* synthetic */ float cdQ;
    private final /* synthetic */ View zc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar, TbPageContextSupport tbPageContextSupport, View view, float f) {
        this.cdO = cVar;
        this.cdP = tbPageContextSupport;
        this.zc = view;
        this.cdQ = f;
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
        com.baidu.tieba.tbadkCore.a.a(this.cdP, this.zc, scaleAnimation, new j(this, this.cdQ, this.zc));
    }
}
