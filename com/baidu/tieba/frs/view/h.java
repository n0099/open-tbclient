package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.baidu.tbadk.TbPageContextSupport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Animation.AnimationListener {
    final /* synthetic */ c bVP;
    private final /* synthetic */ TbPageContextSupport bVQ;
    private final /* synthetic */ float bVR;
    private final /* synthetic */ View qa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar, TbPageContextSupport tbPageContextSupport, View view, float f) {
        this.bVP = cVar;
        this.bVQ = tbPageContextSupport;
        this.qa = view;
        this.bVR = f;
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
        com.baidu.tieba.tbadkCore.a.a(this.bVQ, this.qa, scaleAnimation, new i(this, this.bVR, this.qa));
    }
}
