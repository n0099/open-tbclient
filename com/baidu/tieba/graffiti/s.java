package com.baidu.tieba.graffiti;

import android.view.animation.Animation;
import android.widget.ImageView;
/* loaded from: classes.dex */
class s extends com.baidu.adp.lib.g.d {
    private final /* synthetic */ ImageView cnI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ImageView imageView) {
        this.cnI = imageView;
    }

    @Override // com.baidu.adp.lib.g.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.cnI.setImageResource(0);
        this.cnI.setBackgroundResource(0);
        this.cnI.setVisibility(8);
    }
}
