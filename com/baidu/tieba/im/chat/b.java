package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a cMA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cMA = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.cMA.cMz;
        absMsgImageActivity.cMq = true;
        absMsgImageActivity2 = this.cMA.cMz;
        z = absMsgImageActivity2.cMr;
        if (z) {
            absMsgImageActivity3 = this.cMA.cMz;
            absMsgImageActivity3.cMr = false;
            absMsgImageActivity4 = this.cMA.cMz;
            navigationBar = absMsgImageActivity4.cMm;
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
