package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a cSs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cSs = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.cSs.cSr;
        absMsgImageActivity.cSi = true;
        absMsgImageActivity2 = this.cSs.cSr;
        z = absMsgImageActivity2.cSj;
        if (z) {
            absMsgImageActivity3 = this.cSs.cSr;
            absMsgImageActivity3.cSj = false;
            absMsgImageActivity4 = this.cSs.cSr;
            navigationBar = absMsgImageActivity4.cSe;
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
