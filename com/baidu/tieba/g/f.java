package com.baidu.tieba.g;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.g.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ c bAk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.bAk = cVar;
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
        view = this.bAk.bAd;
        if (view != null) {
            view2 = this.bAk.bAd;
            view2.clearAnimation();
            view3 = this.bAk.bAd;
            view3.setVisibility(0);
            this.bAk.dl(false);
            aVar = this.bAk.bAa;
            if (aVar != null) {
                aVar2 = this.bAk.bAa;
                aVar2.dm(true);
            }
        }
    }
}
