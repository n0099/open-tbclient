package com.baidu.tieba.gift.buyGift;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Animation.AnimationListener {
    final /* synthetic */ BuyGiftActivity bng;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BuyGiftActivity buyGiftActivity) {
        this.bng = buyGiftActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        View view;
        view = this.bng.bmC;
        view.setVisibility(0);
        this.bng.QG();
    }
}
