package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cp implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView aTa;
    private final /* synthetic */ Animation aTb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(PersonalChatView personalChatView, Animation animation) {
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
        textView = this.aTa.aSX;
        textView.startAnimation(this.aTb);
    }
}
