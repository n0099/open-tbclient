package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cr implements Animation.AnimationListener {
    private final /* synthetic */ String aRV;
    final /* synthetic */ PersonalChatView aSZ;
    private final /* synthetic */ Animation aTa;
    private final /* synthetic */ String aTb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.aSZ = personalChatView;
        this.aRV = str;
        this.aTb = str2;
        this.aTa = animation;
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
        linearLayout = this.aSZ.aST;
        linearLayout.clearAnimation();
        textView = this.aSZ.aSU;
        personalChatActivity = this.aSZ.aSR;
        textView.setText(personalChatActivity.getResources().getString(com.baidu.tieba.z.add_friend_agree_title, this.aRV));
        textView2 = this.aSZ.aSV;
        textView2.setText(this.aTb);
        linearLayout2 = this.aSZ.aST;
        linearLayout2.setAnimation(this.aTa);
    }
}
