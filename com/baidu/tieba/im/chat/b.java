package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
class b implements Animation.AnimationListener {
    final /* synthetic */ a bni;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bni = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        AbsMsgImageActivity absMsgImageActivity;
        AbsMsgImageActivity absMsgImageActivity2;
        boolean z;
        AbsMsgImageActivity absMsgImageActivity3;
        AbsMsgImageActivity absMsgImageActivity4;
        NavigationBar navigationBar;
        absMsgImageActivity = this.bni.bnh;
        absMsgImageActivity.bmY = true;
        absMsgImageActivity2 = this.bni.bnh;
        z = absMsgImageActivity2.bmZ;
        if (z) {
            absMsgImageActivity3 = this.bni.bnh;
            absMsgImageActivity3.bmZ = false;
            absMsgImageActivity4 = this.bni.bnh;
            navigationBar = absMsgImageActivity4.bmU;
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
