package com.baidu.tieba.frs.entelechy.view;

import android.view.animation.Animation;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ a cax;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.cax = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        int i;
        TbImageView tbImageView;
        TbImageView tbImageView2;
        i = this.cax.bcY;
        if (i == 3) {
            tbImageView = this.cax.bcO;
            if (tbImageView != null) {
                tbImageView2 = this.cax.bcO;
                tbImageView2.setVisibility(8);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
