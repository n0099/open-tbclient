package com.baidu.tieba.frs.headvideo;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Animation.AnimationListener {
    final /* synthetic */ ForumHeadVideoView ccf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ForumHeadVideoView forumHeadVideoView) {
        this.ccf = forumHeadVideoView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.ccf.cbR = false;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        c cVar;
        c cVar2;
        c cVar3;
        e currentVideoItemView = this.ccf.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            currentVideoItemView.clearAnimation();
            this.ccf.e(currentVideoItemView);
            cVar = this.ccf.bPz;
            if (cVar != null) {
                cVar2 = this.ccf.bPz;
                if (!cVar2.aeu()) {
                    cVar3 = this.ccf.bPz;
                    cVar3.ee(true);
                    a.aes();
                }
            }
        }
        this.ccf.cbR = true;
    }
}
