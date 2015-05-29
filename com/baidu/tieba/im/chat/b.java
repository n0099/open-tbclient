package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a aZm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aZm = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.aZm.aZl;
        absMsgImageActivity.aZc = true;
        absMsgImageActivity2 = this.aZm.aZl;
        z = absMsgImageActivity2.aZd;
        if (z) {
            absMsgImageActivity3 = this.aZm.aZl;
            absMsgImageActivity3.aZd = false;
            absMsgImageActivity4 = this.aZm.aZl;
            navigationBar = absMsgImageActivity4.aYY;
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
