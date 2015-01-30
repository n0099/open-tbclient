package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView aTa;
    private final /* synthetic */ Animation aTb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(PersonalChatView personalChatView, Animation animation) {
        this.aTa = personalChatView;
        this.aTb = animation;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        TextView textView;
        TextView textView2;
        textView = this.aTa.aSX;
        textView.setVisibility(0);
        textView2 = this.aTa.aSX;
        textView2.setAnimation(this.aTb);
    }
}
