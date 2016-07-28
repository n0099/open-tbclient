package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a cGM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cGM = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.cGM.cGL;
        absMsgImageActivity.cGC = true;
        absMsgImageActivity2 = this.cGM.cGL;
        z = absMsgImageActivity2.cGD;
        if (z) {
            absMsgImageActivity3 = this.cGM.cGL;
            absMsgImageActivity3.cGD = false;
            absMsgImageActivity4 = this.cGM.cGL;
            navigationBar = absMsgImageActivity4.cGy;
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
