package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a aQf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aQf = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.aQf.aQe;
        absMsgImageActivity.aPW = true;
        absMsgImageActivity2 = this.aQf.aQe;
        z = absMsgImageActivity2.aPX;
        if (z) {
            absMsgImageActivity3 = this.aQf.aQe;
            absMsgImageActivity3.aPX = false;
            absMsgImageActivity4 = this.aQf.aQe;
            navigationBar = absMsgImageActivity4.aPT;
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
