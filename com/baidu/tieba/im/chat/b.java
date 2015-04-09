package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a aWG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aWG = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.aWG.aWF;
        absMsgImageActivity.aWw = true;
        absMsgImageActivity2 = this.aWG.aWF;
        z = absMsgImageActivity2.aWx;
        if (z) {
            absMsgImageActivity3 = this.aWG.aWF;
            absMsgImageActivity3.aWx = false;
            absMsgImageActivity4 = this.aWG.aWF;
            navigationBar = absMsgImageActivity4.aWt;
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
