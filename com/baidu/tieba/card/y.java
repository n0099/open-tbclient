package com.baidu.tieba.card;

import android.view.animation.Animation;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements Animation.AnimationListener {
    final /* synthetic */ t aZF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(t tVar) {
        this.aZF = tVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        tbImageView = this.aZF.aZj;
        if (tbImageView != null) {
            tbImageView2 = this.aZF.aZj;
            tbImageView2.setVisibility(8);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
