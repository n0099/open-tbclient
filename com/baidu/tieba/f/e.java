package com.baidu.tieba.f;

import android.view.View;
import android.view.animation.Animation;
import com.baidu.tieba.f.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Animation.AnimationListener {
    final /* synthetic */ c bVn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.bVn = cVar;
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
        view = this.bVn.bVi;
        if (view != null) {
            view2 = this.bVn.bVi;
            view2.clearAnimation();
            view3 = this.bVn.bVi;
            view3.setVisibility(8);
            this.bVn.ef(true);
            aVar = this.bVn.bVf;
            if (aVar != null) {
                aVar2 = this.bVn.bVf;
                aVar2.eg(false);
            }
        }
    }
}
