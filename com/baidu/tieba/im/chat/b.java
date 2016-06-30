package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a cDX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cDX = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.cDX.cDW;
        absMsgImageActivity.cDN = true;
        absMsgImageActivity2 = this.cDX.cDW;
        z = absMsgImageActivity2.cDO;
        if (z) {
            absMsgImageActivity3 = this.cDX.cDW;
            absMsgImageActivity3.cDO = false;
            absMsgImageActivity4 = this.cDX.cDW;
            navigationBar = absMsgImageActivity4.cDJ;
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
