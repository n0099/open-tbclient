package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.baidu.tbadk.TbPageContextSupport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Animation.AnimationListener {
    final /* synthetic */ b bwr;
    private final /* synthetic */ TbPageContextSupport bws;
    private final /* synthetic */ float bwt;
    private final /* synthetic */ View zn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, TbPageContextSupport tbPageContextSupport, View view, float f) {
        this.bwr = bVar;
        this.bws = tbPageContextSupport;
        this.zn = view;
        this.bwt = f;
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
        com.baidu.tieba.tbadkCore.a.a(this.bws, this.zn, scaleAnimation, new h(this, this.bwt, this.zn));
    }
}
