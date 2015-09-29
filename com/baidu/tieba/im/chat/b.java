package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a bqF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bqF = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.bqF.bqE;
        absMsgImageActivity.bqv = true;
        absMsgImageActivity2 = this.bqF.bqE;
        z = absMsgImageActivity2.bqw;
        if (z) {
            absMsgImageActivity3 = this.bqF.bqE;
            absMsgImageActivity3.bqw = false;
            absMsgImageActivity4 = this.bqF.bqE;
            navigationBar = absMsgImageActivity4.bqr;
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
