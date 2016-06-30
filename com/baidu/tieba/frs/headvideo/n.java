package com.baidu.tieba.frs.headvideo;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Animation.AnimationListener {
    final /* synthetic */ ForumHeadVideoView bPh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ForumHeadVideoView forumHeadVideoView) {
        this.bPh = forumHeadVideoView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.bPh.bOV = false;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        c cVar;
        c cVar2;
        c cVar3;
        e currentVideoItemView = this.bPh.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            currentVideoItemView.clearAnimation();
            this.bPh.d(currentVideoItemView);
            cVar = this.bPh.bCW;
            if (cVar != null) {
                cVar2 = this.bPh.bCW;
                if (!cVar2.YY()) {
                    cVar3 = this.bPh.bCW;
                    cVar3.dJ(true);
                    a.YW();
                }
            }
        }
        this.bPh.bOV = true;
    }
}
