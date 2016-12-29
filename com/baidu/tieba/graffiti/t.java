package com.baidu.tieba.graffiti;

import android.view.animation.Animation;
import android.widget.ImageView;
/* loaded from: classes.dex */
class t extends com.baidu.adp.lib.h.d {
    private final /* synthetic */ ImageView chr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ImageView imageView) {
        this.chr = imageView;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.chr.setImageResource(0);
        this.chr.setBackgroundResource(0);
        this.chr.setVisibility(8);
    }
}
