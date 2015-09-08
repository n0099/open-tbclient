package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a bnG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bnG = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.bnG.bnF;
        absMsgImageActivity.bnw = true;
        absMsgImageActivity2 = this.bnG.bnF;
        z = absMsgImageActivity2.bnx;
        if (z) {
            absMsgImageActivity3 = this.bnG.bnF;
            absMsgImageActivity3.bnx = false;
            absMsgImageActivity4 = this.bnG.bnF;
            navigationBar = absMsgImageActivity4.bns;
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
