package com.baidu.tieba.frs.headvideo;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Animation.AnimationListener {
    final /* synthetic */ ForumHeadVideoView bQU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ForumHeadVideoView forumHeadVideoView) {
        this.bQU = forumHeadVideoView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.bQU.bQH = false;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        c cVar;
        c cVar2;
        c cVar3;
        e currentVideoItemView = this.bQU.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            currentVideoItemView.clearAnimation();
            this.bQU.d(currentVideoItemView);
            cVar = this.bQU.bEd;
            if (cVar != null) {
                cVar2 = this.bQU.bEd;
                if (!cVar2.Zt()) {
                    cVar3 = this.bQU.bEd;
                    cVar3.dH(true);
                    a.Zr();
                }
            }
        }
        this.bQU.bQH = true;
    }
}
