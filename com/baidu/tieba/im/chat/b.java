package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a cOs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cOs = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.cOs.cOr;
        absMsgImageActivity.cOi = true;
        absMsgImageActivity2 = this.cOs.cOr;
        z = absMsgImageActivity2.cOj;
        if (z) {
            absMsgImageActivity3 = this.cOs.cOr;
            absMsgImageActivity3.cOj = false;
            absMsgImageActivity4 = this.cOs.cOr;
            navigationBar = absMsgImageActivity4.cOe;
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
