package com.baidu.tieba.graffiti;

import android.view.animation.Animation;
import android.widget.ImageView;
/* loaded from: classes.dex */
class s extends com.baidu.adp.lib.g.d {
    private final /* synthetic */ ImageView cBj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(ImageView imageView) {
        this.cBj = imageView;
    }

    @Override // com.baidu.adp.lib.g.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.cBj.setImageResource(0);
        this.cBj.setBackgroundResource(0);
        this.cBj.setVisibility(8);
    }
}
