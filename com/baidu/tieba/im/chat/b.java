package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a cIU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cIU = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.cIU.cIT;
        absMsgImageActivity.cIK = true;
        absMsgImageActivity2 = this.cIU.cIT;
        z = absMsgImageActivity2.cIL;
        if (z) {
            absMsgImageActivity3 = this.cIU.cIT;
            absMsgImageActivity3.cIL = false;
            absMsgImageActivity4 = this.cIU.cIT;
            navigationBar = absMsgImageActivity4.cIG;
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
