package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a bKh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bKh = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.bKh.bKg;
        absMsgImageActivity.bJX = true;
        absMsgImageActivity2 = this.bKh.bKg;
        z = absMsgImageActivity2.bJY;
        if (z) {
            absMsgImageActivity3 = this.bKh.bKg;
            absMsgImageActivity3.bJY = false;
            absMsgImageActivity4 = this.bKh.bKg;
            navigationBar = absMsgImageActivity4.bJT;
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
