package com.baidu.tieba.graffiti;

import android.view.animation.Animation;
import android.widget.ImageView;
/* loaded from: classes.dex */
class t extends com.baidu.adp.lib.h.d {
    private final /* synthetic */ ImageView cle;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ImageView imageView) {
        this.cle = imageView;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.cle.setImageResource(0);
        this.cle.setBackgroundResource(0);
        this.cle.setVisibility(8);
    }
}
