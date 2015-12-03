package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a bGA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bGA = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.bGA.bGz;
        absMsgImageActivity.bGq = true;
        absMsgImageActivity2 = this.bGA.bGz;
        z = absMsgImageActivity2.bGr;
        if (z) {
            absMsgImageActivity3 = this.bGA.bGz;
            absMsgImageActivity3.bGr = false;
            absMsgImageActivity4 = this.bGA.bGz;
            navigationBar = absMsgImageActivity4.bGm;
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
