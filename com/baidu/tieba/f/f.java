package com.baidu.tieba.f;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.f.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ c bOs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.bOs = cVar;
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
        c.a aVar;
        c.a aVar2;
        view = this.bOs.bOn;
        if (view != null) {
            view2 = this.bOs.bOn;
            view2.clearAnimation();
            view3 = this.bOs.bOn;
            view3.setVisibility(0);
            this.bOs.dP(false);
            aVar = this.bOs.bOk;
            if (aVar != null) {
                aVar2 = this.bOs.bOk;
                aVar2.dQ(true);
            }
        }
    }
}
