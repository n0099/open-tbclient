package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a aRj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aRj = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.aRj.aRi;
        absMsgImageActivity.aRa = true;
        absMsgImageActivity2 = this.aRj.aRi;
        z = absMsgImageActivity2.aRb;
        if (z) {
            absMsgImageActivity3 = this.aRj.aRi;
            absMsgImageActivity3.aRb = false;
            absMsgImageActivity4 = this.aRj.aRi;
            navigationBar = absMsgImageActivity4.aQX;
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
