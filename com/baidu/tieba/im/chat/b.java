package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a bqQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bqQ = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.bqQ.bqP;
        absMsgImageActivity.bqG = true;
        absMsgImageActivity2 = this.bqQ.bqP;
        z = absMsgImageActivity2.bqH;
        if (z) {
            absMsgImageActivity3 = this.bqQ.bqP;
            absMsgImageActivity3.bqH = false;
            absMsgImageActivity4 = this.bqQ.bqP;
            navigationBar = absMsgImageActivity4.bqC;
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
