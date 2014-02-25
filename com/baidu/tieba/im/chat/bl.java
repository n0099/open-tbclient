package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import com.baidu.tieba.view.NavigationBar;
/* loaded from: classes.dex */
class bl implements Animation.AnimationListener {
    final /* synthetic */ bk a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bk bkVar) {
        this.a = bkVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        MsgImageActivity msgImageActivity;
        MsgImageActivity msgImageActivity2;
        boolean z;
        MsgImageActivity msgImageActivity3;
        MsgImageActivity msgImageActivity4;
        NavigationBar navigationBar;
        msgImageActivity = this.a.a;
        msgImageActivity.o = true;
        msgImageActivity2 = this.a.a;
        z = msgImageActivity2.p;
        if (z) {
            msgImageActivity3 = this.a.a;
            msgImageActivity3.p = false;
            msgImageActivity4 = this.a.a;
            navigationBar = msgImageActivity4.i;
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
