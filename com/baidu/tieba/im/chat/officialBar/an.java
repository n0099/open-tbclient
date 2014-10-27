package com.baidu.tieba.im.chat.officialBar;

import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements Animation.AnimationListener {
    final /* synthetic */ OfficialBarMsglistView aRL;
    private final /* synthetic */ boolean aRM;
    private final /* synthetic */ Animation aRN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(OfficialBarMsglistView officialBarMsglistView, boolean z, Animation animation) {
        this.aRL = officialBarMsglistView;
        this.aRM = z;
        this.aRN = animation;
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
        FrameLayout frameLayout;
        ImageView imageView;
        ao[] aoVarArr;
        com.baidu.tieba.im.view.k kVar;
        LinearLayout linearLayout2;
        FrameLayout frameLayout2;
        ImageView imageView2;
        if (this.aRM) {
            linearLayout2 = this.aRL.aRG;
            linearLayout2.setVisibility(0);
            frameLayout2 = this.aRL.mInputControl;
            frameLayout2.setVisibility(8);
            imageView2 = this.aRL.aRF;
            imageView2.setImageResource(com.baidu.tieba.u.btn_bottombar_keyboard_above);
        } else {
            linearLayout = this.aRL.aRG;
            linearLayout.setVisibility(8);
            frameLayout = this.aRL.mInputControl;
            frameLayout.setVisibility(0);
            imageView = this.aRL.aRF;
            imageView.setImageResource(com.baidu.tieba.u.btn_bottombar_keyboard_below);
            for (int i = 0; i < 3; i++) {
                aoVarArr = this.aRL.aRK;
                ao aoVar = aoVarArr[i];
                if (aoVar.aRO) {
                    aoVar.aRO = false;
                    this.aRL.q(i, aoVar.aRO);
                    kVar = this.aRL.aRJ;
                    kVar.RT();
                }
            }
        }
        this.aRL.getLayoutBottom().startAnimation(this.aRN);
    }
}
