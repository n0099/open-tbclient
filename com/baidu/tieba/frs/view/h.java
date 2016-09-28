package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.baidu.tbadk.TbPageContextSupport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Animation.AnimationListener {
    final /* synthetic */ c cgX;
    private final /* synthetic */ TbPageContextSupport cgY;
    private final /* synthetic */ float cgZ;
    private final /* synthetic */ View so;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar, TbPageContextSupport tbPageContextSupport, View view, float f) {
        this.cgX = cVar;
        this.cgY = tbPageContextSupport;
        this.so = view;
        this.cgZ = f;
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
        com.baidu.tieba.tbadkCore.a.a(this.cgY, this.so, scaleAnimation, new i(this, this.cgZ, this.so));
    }
}
