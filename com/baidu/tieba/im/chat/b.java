package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a bru;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bru = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.bru.brt;
        absMsgImageActivity.brk = true;
        absMsgImageActivity2 = this.bru.brt;
        z = absMsgImageActivity2.brl;
        if (z) {
            absMsgImageActivity3 = this.bru.brt;
            absMsgImageActivity3.brl = false;
            absMsgImageActivity4 = this.bru.brt;
            navigationBar = absMsgImageActivity4.brg;
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
