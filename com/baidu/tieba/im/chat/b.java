package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a aWq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aWq = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.aWq.aWp;
        absMsgImageActivity.aWg = true;
        absMsgImageActivity2 = this.aWq.aWp;
        z = absMsgImageActivity2.aWh;
        if (z) {
            absMsgImageActivity3 = this.aWq.aWp;
            absMsgImageActivity3.aWh = false;
            absMsgImageActivity4 = this.aWq.aWp;
            navigationBar = absMsgImageActivity4.aWd;
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
