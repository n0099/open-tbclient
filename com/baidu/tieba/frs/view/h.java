package com.baidu.tieba.frs.view;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.baidu.tbadk.TbPageContextSupport;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Animation.AnimationListener {
    final /* synthetic */ c bTP;
    private final /* synthetic */ TbPageContextSupport bTQ;
    private final /* synthetic */ float bTR;
    private final /* synthetic */ View py;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar, TbPageContextSupport tbPageContextSupport, View view, float f) {
        this.bTP = cVar;
        this.bTQ = tbPageContextSupport;
        this.py = view;
        this.bTR = f;
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
        com.baidu.tieba.tbadkCore.a.a(this.bTQ, this.py, scaleAnimation, new i(this, this.bTR, this.py));
    }
}
