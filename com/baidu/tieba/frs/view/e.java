package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.baidu.tbadk.TbPageContextSupport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Animation.AnimationListener {
    final /* synthetic */ b crq;
    private final /* synthetic */ TbPageContextSupport crr;
    private final /* synthetic */ float crs;
    private final /* synthetic */ View zg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, TbPageContextSupport tbPageContextSupport, View view, float f) {
        this.crq = bVar;
        this.crr = tbPageContextSupport;
        this.zg = view;
        this.crs = f;
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
        com.baidu.tieba.tbadkCore.a.a(this.crr, this.zg, scaleAnimation, new f(this, this.crs, this.zg));
    }
}
