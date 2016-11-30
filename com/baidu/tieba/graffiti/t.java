package com.baidu.tieba.graffiti;

import android.view.animation.Animation;
import android.widget.ImageView;
/* loaded from: classes.dex */
class t extends com.baidu.adp.lib.h.d {
    private final /* synthetic */ ImageView cCe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ImageView imageView) {
        this.cCe = imageView;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.cCe.setImageResource(0);
        this.cCe.setBackgroundResource(0);
        this.cCe.setVisibility(8);
    }
}
