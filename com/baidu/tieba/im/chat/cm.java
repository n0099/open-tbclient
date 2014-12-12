package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView aRR;
    private final /* synthetic */ Animation aRS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(PersonalChatView personalChatView, Animation animation) {
        this.aRR = personalChatView;
        this.aRS = animation;
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
        textView = this.aRR.aRO;
        textView.startAnimation(this.aRS);
    }
}
