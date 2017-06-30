package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a cWo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cWo = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.cWo.cWn;
        absMsgImageActivity.cWe = true;
        absMsgImageActivity2 = this.cWo.cWn;
        z = absMsgImageActivity2.cWf;
        if (z) {
            absMsgImageActivity3 = this.cWo.cWn;
            absMsgImageActivity3.cWf = false;
            absMsgImageActivity4 = this.cWo.cWn;
            navigationBar = absMsgImageActivity4.cWa;
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
