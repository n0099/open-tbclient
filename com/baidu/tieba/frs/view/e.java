package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.baidu.tbadk.TbPageContextSupport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Animation.AnimationListener {
    final /* synthetic */ a bdi;
    private final /* synthetic */ TbPageContextSupport bdj;
    private final /* synthetic */ float bdk;
    private final /* synthetic */ View yF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, TbPageContextSupport tbPageContextSupport, View view, float f) {
        this.bdi = aVar;
        this.bdj = tbPageContextSupport;
        this.yF = view;
        this.bdk = f;
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
        com.baidu.tieba.tbadkCore.a.a(this.bdj, this.yF, scaleAnimation, new f(this, this.bdk, this.yF));
    }
}
