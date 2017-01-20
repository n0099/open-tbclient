package com.baidu.tieba.card;

import android.view.animation.Animation;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements Animation.AnimationListener {
    final /* synthetic */ x bml;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(x xVar) {
        this.bml = xVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        TbImageView tbImageView;
        TbImageView tbImageView2;
        tbImageView = this.bml.blO;
        if (tbImageView != null) {
            tbImageView2 = this.bml.blO;
            tbImageView2.setVisibility(8);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
