package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a bYi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bYi = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.bYi.bYh;
        absMsgImageActivity.bXY = true;
        absMsgImageActivity2 = this.bYi.bYh;
        z = absMsgImageActivity2.bXZ;
        if (z) {
            absMsgImageActivity3 = this.bYi.bYh;
            absMsgImageActivity3.bXZ = false;
            absMsgImageActivity4 = this.bYi.bYh;
            navigationBar = absMsgImageActivity4.bXU;
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
