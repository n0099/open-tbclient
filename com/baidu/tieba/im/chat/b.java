package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a cLP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cLP = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.cLP.cLO;
        absMsgImageActivity.cLF = true;
        absMsgImageActivity2 = this.cLP.cLO;
        z = absMsgImageActivity2.cLG;
        if (z) {
            absMsgImageActivity3 = this.cLP.cLO;
            absMsgImageActivity3.cLG = false;
            absMsgImageActivity4 = this.cLP.cLO;
            navigationBar = absMsgImageActivity4.cLB;
            navigationBar.setVisibility(8);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
