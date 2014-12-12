package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cn implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView aRR;
    private final /* synthetic */ Animation aRS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(PersonalChatView personalChatView, Animation animation) {
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
        TextView textView2;
        textView = this.aRR.aRO;
        textView.setVisibility(0);
        textView2 = this.aRR.aRO;
        textView2.setAnimation(this.aRS);
    }
}
