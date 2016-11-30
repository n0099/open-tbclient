package com.baidu.tieba.frs.headvideo;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Animation.AnimationListener {
    final /* synthetic */ ForumHeadVideoView cfB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ForumHeadVideoView forumHeadVideoView) {
        this.cfB = forumHeadVideoView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.cfB.cfn = false;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        b bVar;
        b bVar2;
        b bVar3;
        c currentVideoItemView = this.cfB.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            currentVideoItemView.clearAnimation();
            this.cfB.e(currentVideoItemView);
            bVar = this.cfB.bSr;
            if (bVar != null) {
                bVar2 = this.cfB.bSr;
                if (!bVar2.afO()) {
                    bVar3 = this.cfB.bSr;
                    bVar3.eq(true);
                    a.afM();
                }
            }
        }
        this.cfB.cfn = true;
    }
}
