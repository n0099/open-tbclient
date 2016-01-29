package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a bNQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bNQ = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.bNQ.bNP;
        absMsgImageActivity.bNG = true;
        absMsgImageActivity2 = this.bNQ.bNP;
        z = absMsgImageActivity2.bNH;
        if (z) {
            absMsgImageActivity3 = this.bNQ.bNP;
            absMsgImageActivity3.bNH = false;
            absMsgImageActivity4 = this.bNQ.bNP;
            navigationBar = absMsgImageActivity4.bNC;
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
