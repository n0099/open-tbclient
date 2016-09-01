package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.baidu.tbadk.TbPageContextSupport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Animation.AnimationListener {
    final /* synthetic */ c cgZ;
    private final /* synthetic */ TbPageContextSupport cha;
    private final /* synthetic */ float chb;
    private final /* synthetic */ View so;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar, TbPageContextSupport tbPageContextSupport, View view, float f) {
        this.cgZ = cVar;
        this.cha = tbPageContextSupport;
        this.so = view;
        this.chb = f;
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
        com.baidu.tieba.tbadkCore.a.a(this.cha, this.so, scaleAnimation, new i(this, this.chb, this.so));
    }
}
