package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cr implements Animation.AnimationListener {
    private final /* synthetic */ String aRW;
    final /* synthetic */ PersonalChatView aTa;
    private final /* synthetic */ Animation aTb;
    private final /* synthetic */ String aTc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.aTa = personalChatView;
        this.aRW = str;
        this.aTc = str2;
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
        LinearLayout linearLayout;
        TextView textView;
        PersonalChatActivity personalChatActivity;
        TextView textView2;
        LinearLayout linearLayout2;
        linearLayout = this.aTa.aSU;
        linearLayout.clearAnimation();
        textView = this.aTa.aSV;
        personalChatActivity = this.aTa.aSS;
        textView.setText(personalChatActivity.getResources().getString(com.baidu.tieba.z.add_friend_agree_title, this.aRW));
        textView2 = this.aTa.aSW;
        textView2.setText(this.aTc);
        linearLayout2 = this.aTa.aSU;
        linearLayout2.setAnimation(this.aTb);
    }
}
