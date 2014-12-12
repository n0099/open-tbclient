package com.baidu.tieba.im.chat;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co implements Animation.AnimationListener {
    private final /* synthetic */ String aQN;
    final /* synthetic */ PersonalChatView aRR;
    private final /* synthetic */ Animation aRS;
    private final /* synthetic */ String aRT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(PersonalChatView personalChatView, String str, String str2, Animation animation) {
        this.aRR = personalChatView;
        this.aQN = str;
        this.aRT = str2;
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
        LinearLayout linearLayout;
        TextView textView;
        PersonalChatActivity personalChatActivity;
        TextView textView2;
        LinearLayout linearLayout2;
        linearLayout = this.aRR.aRL;
        linearLayout.clearAnimation();
        textView = this.aRR.aRM;
        personalChatActivity = this.aRR.aRJ;
        textView.setText(personalChatActivity.getResources().getString(com.baidu.tieba.z.add_friend_agree_title, this.aQN));
        textView2 = this.aRR.aRN;
        textView2.setText(this.aRT);
        linearLayout2 = this.aRR.aRL;
        linearLayout2.setAnimation(this.aRS);
    }
}
