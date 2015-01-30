package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements Animation.AnimationListener {
    final /* synthetic */ PersonalChatView aTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(PersonalChatView personalChatView) {
        this.aTa = personalChatView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        LinearLayout linearLayout;
        linearLayout = this.aTa.aST;
        linearLayout.setVisibility(8);
    }
}
