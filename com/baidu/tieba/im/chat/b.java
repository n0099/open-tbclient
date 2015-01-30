package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a aRk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aRk = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.aRk.aRj;
        absMsgImageActivity.aRb = true;
        absMsgImageActivity2 = this.aRk.aRj;
        z = absMsgImageActivity2.aRc;
        if (z) {
            absMsgImageActivity3 = this.aRk.aRj;
            absMsgImageActivity3.aRc = false;
            absMsgImageActivity4 = this.aRk.aRj;
            navigationBar = absMsgImageActivity4.aQY;
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
