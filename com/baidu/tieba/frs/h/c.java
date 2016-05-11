package com.baidu.tieba.frs.h;

import android.view.animation.Animation;
import com.baidu.tieba.frs.entelechy.c.aq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Animation.AnimationListener {
    final /* synthetic */ a btY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.btY = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        aq aqVar;
        aq aqVar2;
        aqVar = this.btY.btS;
        aqVar.setVisibility(8);
        aqVar2 = this.btY.btS;
        aqVar2.clearAnimation();
    }
}
