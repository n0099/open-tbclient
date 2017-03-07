package com.baidu.tieba.frs.entelechy.view;

import android.view.animation.Animation;
import com.baidu.tbadk.widget.TbImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Animation.AnimationListener {
    final /* synthetic */ a bTB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.bTB = aVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        int i;
        TbImageView tbImageView;
        TbImageView tbImageView2;
        i = this.bTB.bsZ;
        if (i == 3) {
            tbImageView = this.bTB.bsH;
            if (tbImageView != null) {
                tbImageView2 = this.bTB.bsH;
                tbImageView2.setVisibility(8);
            }
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
