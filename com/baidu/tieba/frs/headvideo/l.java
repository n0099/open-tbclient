package com.baidu.tieba.frs.headvideo;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Animation.AnimationListener {
    final /* synthetic */ ForumHeadVideoView bLk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ForumHeadVideoView forumHeadVideoView) {
        this.bLk = forumHeadVideoView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.bLk.bKW = false;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        b bVar;
        b bVar2;
        b bVar3;
        c currentVideoItemView = this.bLk.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            currentVideoItemView.clearAnimation();
            this.bLk.e(currentVideoItemView);
            bVar = this.bLk.byB;
            if (bVar != null) {
                bVar2 = this.bLk.byB;
                if (!bVar2.aak()) {
                    bVar3 = this.bLk.byB;
                    bVar3.ea(true);
                    a.aai();
                }
            }
        }
        this.bLk.bKW = true;
    }
}
