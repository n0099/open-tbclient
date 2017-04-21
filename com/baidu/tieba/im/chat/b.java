package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a cOR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cOR = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.cOR.cOQ;
        absMsgImageActivity.cOH = true;
        absMsgImageActivity2 = this.cOR.cOQ;
        z = absMsgImageActivity2.cOI;
        if (z) {
            absMsgImageActivity3 = this.cOR.cOQ;
            absMsgImageActivity3.cOI = false;
            absMsgImageActivity4 = this.cOR.cOQ;
            navigationBar = absMsgImageActivity4.cOD;
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
