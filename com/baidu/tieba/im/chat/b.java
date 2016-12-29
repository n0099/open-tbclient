package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a cEG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cEG = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.cEG.cEF;
        absMsgImageActivity.cEw = true;
        absMsgImageActivity2 = this.cEG.cEF;
        z = absMsgImageActivity2.cEx;
        if (z) {
            absMsgImageActivity3 = this.cEG.cEF;
            absMsgImageActivity3.cEx = false;
            absMsgImageActivity4 = this.cEG.cEF;
            navigationBar = absMsgImageActivity4.cEs;
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
