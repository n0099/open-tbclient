package com.baidu.tieba.frs.headvideo;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Animation.AnimationListener {
    final /* synthetic */ ForumHeadVideoView ccd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ForumHeadVideoView forumHeadVideoView) {
        this.ccd = forumHeadVideoView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.ccd.cbP = false;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        c cVar;
        c cVar2;
        c cVar3;
        e currentVideoItemView = this.ccd.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            currentVideoItemView.clearAnimation();
            this.ccd.d(currentVideoItemView);
            cVar = this.ccd.bPH;
            if (cVar != null) {
                cVar2 = this.ccd.bPH;
                if (!cVar2.aef()) {
                    cVar3 = this.ccd.bPH;
                    cVar3.ed(true);
                    a.aed();
                }
            }
        }
        this.ccd.cbP = true;
    }
}
