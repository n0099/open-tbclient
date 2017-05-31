package com.baidu.tieba.graffiti;

import android.view.animation.Animation;
import android.widget.ImageView;
/* loaded from: classes.dex */
class s extends com.baidu.adp.lib.g.d {
    private final /* synthetic */ ImageView ctw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ImageView imageView) {
        this.ctw = imageView;
    }

    @Override // com.baidu.adp.lib.g.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.ctw.setImageResource(0);
        this.ctw.setBackgroundResource(0);
        this.ctw.setVisibility(8);
    }
}
