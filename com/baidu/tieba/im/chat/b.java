package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a cOd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cOd = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.cOd.cOc;
        absMsgImageActivity.cNT = true;
        absMsgImageActivity2 = this.cOd.cOc;
        z = absMsgImageActivity2.cNU;
        if (z) {
            absMsgImageActivity3 = this.cOd.cOc;
            absMsgImageActivity3.cNU = false;
            absMsgImageActivity4 = this.cOd.cOc;
            navigationBar = absMsgImageActivity4.cNP;
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
