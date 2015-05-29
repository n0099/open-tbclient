package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.baidu.tbadk.TbPageContextSupport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Animation.AnimationListener {
    final /* synthetic */ a aRp;
    private final /* synthetic */ TbPageContextSupport aRq;
    private final /* synthetic */ float aRr;
    private final /* synthetic */ View yH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, TbPageContextSupport tbPageContextSupport, View view, float f) {
        this.aRp = aVar;
        this.aRq = tbPageContextSupport;
        this.yH = view;
        this.aRr = f;
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
        com.baidu.tieba.tbadkCore.a.a(this.aRq, this.yH, scaleAnimation, new f(this, this.aRr, this.yH));
    }
}
