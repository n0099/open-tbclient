package com.baidu.tieba.im.groupInfo;

import android.view.animation.Animation;
import com.baidu.tieba.view.NavigationBar;
/* loaded from: classes.dex */
class e implements Animation.AnimationListener {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.a = dVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        GroupImageActivity groupImageActivity;
        GroupImageActivity groupImageActivity2;
        boolean z;
        GroupImageActivity groupImageActivity3;
        GroupImageActivity groupImageActivity4;
        NavigationBar navigationBar;
        groupImageActivity = this.a.a;
        groupImageActivity.o = true;
        groupImageActivity2 = this.a.a;
        z = groupImageActivity2.p;
        if (z) {
            groupImageActivity3 = this.a.a;
            groupImageActivity3.p = false;
            groupImageActivity4 = this.a.a;
            navigationBar = groupImageActivity4.e;
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
