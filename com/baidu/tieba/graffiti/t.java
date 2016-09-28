package com.baidu.tieba.graffiti;

import android.view.animation.Animation;
import android.widget.ImageView;
/* loaded from: classes.dex */
class t extends com.baidu.adp.lib.h.d {
    private final /* synthetic */ ImageView cwU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(ImageView imageView) {
        this.cwU = imageView;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.cwU.setImageResource(0);
        this.cwU.setBackgroundResource(0);
        this.cwU.setVisibility(8);
    }
}
