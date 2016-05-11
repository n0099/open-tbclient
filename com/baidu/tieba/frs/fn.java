package com.baidu.tieba.frs;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fn implements Animation.AnimationListener {
    final /* synthetic */ fk bmR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fn(fk fkVar) {
        this.bmR = fkVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        View view2;
        View view3;
        view = this.bmR.bmI;
        if (view != null) {
            view2 = this.bmR.bmI;
            view2.clearAnimation();
            view3 = this.bmR.bmI;
            view3.setVisibility(0);
            this.bmR.cZ(false);
        }
    }
}
