package com.baidu.tieba.frs.headvideo;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Animation.AnimationListener {
    final /* synthetic */ ForumHeadVideoView bYL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ForumHeadVideoView forumHeadVideoView) {
        this.bYL = forumHeadVideoView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.bYL.bYx = false;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        b bVar;
        b bVar2;
        b bVar3;
        c currentVideoItemView = this.bYL.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            currentVideoItemView.clearAnimation();
            this.bYL.e(currentVideoItemView);
            bVar = this.bYL.bNi;
            if (bVar != null) {
                bVar2 = this.bYL.bNi;
                if (!bVar2.acm()) {
                    bVar3 = this.bYL.bNi;
                    bVar3.ef(true);
                    a.ack();
                }
            }
        }
        this.bYL.bYx = true;
    }
}
