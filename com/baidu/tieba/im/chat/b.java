package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a cZu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cZu = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.cZu.cZt;
        absMsgImageActivity.cZk = true;
        absMsgImageActivity2 = this.cZu.cZt;
        z = absMsgImageActivity2.cZl;
        if (z) {
            absMsgImageActivity3 = this.cZu.cZt;
            absMsgImageActivity3.cZl = false;
            absMsgImageActivity4 = this.cZu.cZt;
            navigationBar = absMsgImageActivity4.cZg;
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
