package com.baidu.tieba.frs.j;

import android.view.animation.Animation;
import com.baidu.tieba.frs.entelechy.view.aq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Animation.AnimationListener {
    final /* synthetic */ d bTI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar) {
        this.bTI = dVar;
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
        aqVar = this.bTI.bTC;
        aqVar.setVisibility(0);
        aqVar2 = this.bTI.bTC;
        aqVar2.clearAnimation();
    }
}
