package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a bYN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bYN = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.bYN.bYM;
        absMsgImageActivity.bYD = true;
        absMsgImageActivity2 = this.bYN.bYM;
        z = absMsgImageActivity2.bYE;
        if (z) {
            absMsgImageActivity3 = this.bYN.bYM;
            absMsgImageActivity3.bYE = false;
            absMsgImageActivity4 = this.bYN.bYM;
            navigationBar = absMsgImageActivity4.bYz;
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
