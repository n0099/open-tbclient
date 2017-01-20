package com.baidu.tieba.frs.headvideo;

import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Animation.AnimationListener {
    final /* synthetic */ ForumHeadVideoView bRD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ForumHeadVideoView forumHeadVideoView) {
        this.bRD = forumHeadVideoView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.bRD.bRp = false;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        b bVar;
        b bVar2;
        b bVar3;
        c currentVideoItemView = this.bRD.getCurrentVideoItemView();
        if (currentVideoItemView != null) {
            currentVideoItemView.clearAnimation();
            this.bRD.e(currentVideoItemView);
            bVar = this.bRD.bGa;
            if (bVar != null) {
                bVar2 = this.bRD.bGa;
                if (!bVar2.abp()) {
                    bVar3 = this.bRD.bGa;
                    bVar3.ef(true);
                    a.abn();
                }
            }
        }
        this.bRD.bRp = true;
    }
}
