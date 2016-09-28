package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a cTM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cTM = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.cTM.cTL;
        absMsgImageActivity.cTC = true;
        absMsgImageActivity2 = this.cTM.cTL;
        z = absMsgImageActivity2.cTD;
        if (z) {
            absMsgImageActivity3 = this.cTM.cTL;
            absMsgImageActivity3.cTD = false;
            absMsgImageActivity4 = this.cTM.cTL;
            navigationBar = absMsgImageActivity4.cTy;
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
