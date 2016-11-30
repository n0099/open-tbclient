package com.baidu.tieba.card;

import android.view.animation.Animation;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements Animation.AnimationListener {
    final /* synthetic */ r bde;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(r rVar) {
        this.bde = rVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        tbImageView = this.bde.bcO;
        if (tbImageView != null) {
            tbImageView2 = this.bde.bcO;
            tbImageView2.setVisibility(8);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
