package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.baidu.tbadk.TbPageContextSupport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Animation.AnimationListener {
    final /* synthetic */ b cjp;
    private final /* synthetic */ TbPageContextSupport cjq;
    private final /* synthetic */ float cjr;
    private final /* synthetic */ View zg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, TbPageContextSupport tbPageContextSupport, View view, float f) {
        this.cjp = bVar;
        this.cjq = tbPageContextSupport;
        this.zg = view;
        this.cjr = f;
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
        com.baidu.tieba.tbadkCore.a.a(this.cjq, this.zg, scaleAnimation, new f(this, this.cjr, this.zg));
    }
}
