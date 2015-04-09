package com.baidu.tieba.im.chat.officialBar;

import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements Animation.AnimationListener {
    final /* synthetic */ OfficialBarMsglistView aZJ;
    private final /* synthetic */ boolean aZK;
    private final /* synthetic */ Animation aZL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(OfficialBarMsglistView officialBarMsglistView, boolean z, Animation animation) {
        this.aZJ = officialBarMsglistView;
        this.aZK = z;
        this.aZL = animation;
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
        ai[] aiVarArr;
        com.baidu.tieba.im.view.a aVar;
        LinearLayout linearLayout2;
        FrameLayout frameLayout2;
        ImageView imageView2;
        if (this.aZK) {
            linearLayout2 = this.aZJ.aZE;
            linearLayout2.setVisibility(0);
            frameLayout2 = this.aZJ.mInputControl;
            frameLayout2.setVisibility(8);
            imageView2 = this.aZJ.aZD;
            imageView2.setImageResource(com.baidu.tieba.u.btn_bottombar_keyboard_above);
        } else {
            linearLayout = this.aZJ.aZE;
            linearLayout.setVisibility(8);
            frameLayout = this.aZJ.mInputControl;
            frameLayout.setVisibility(0);
            imageView = this.aZJ.aZD;
            imageView.setImageResource(com.baidu.tieba.u.btn_bottombar_keyboard_below);
            for (int i = 0; i < 3; i++) {
                aiVarArr = this.aZJ.aZI;
                ai aiVar = aiVarArr[i];
                if (aiVar.aZM) {
                    aiVar.aZM = false;
                    this.aZJ.m(i, aiVar.aZM);
                    aVar = this.aZJ.aZH;
                    aVar.TS();
                }
            }
        }
        this.aZJ.getLayoutBottom().startAnimation(this.aZL);
    }
}
