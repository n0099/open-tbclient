package com.baidu.tieba.im.chat.officialBar;

import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements Animation.AnimationListener {
    final /* synthetic */ OfficialBarMsglistView aRZ;
    private final /* synthetic */ boolean aSa;
    private final /* synthetic */ Animation aSb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(OfficialBarMsglistView officialBarMsglistView, boolean z, Animation animation) {
        this.aRZ = officialBarMsglistView;
        this.aSa = z;
        this.aSb = animation;
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
        if (this.aSa) {
            linearLayout2 = this.aRZ.aRU;
            linearLayout2.setVisibility(0);
            frameLayout2 = this.aRZ.mInputControl;
            frameLayout2.setVisibility(8);
            imageView2 = this.aRZ.aRT;
            imageView2.setImageResource(com.baidu.tieba.u.btn_bottombar_keyboard_above);
        } else {
            linearLayout = this.aRZ.aRU;
            linearLayout.setVisibility(8);
            frameLayout = this.aRZ.mInputControl;
            frameLayout.setVisibility(0);
            imageView = this.aRZ.aRT;
            imageView.setImageResource(com.baidu.tieba.u.btn_bottombar_keyboard_below);
            for (int i = 0; i < 3; i++) {
                aoVarArr = this.aRZ.aRY;
                ao aoVar = aoVarArr[i];
                if (aoVar.aSc) {
                    aoVar.aSc = false;
                    this.aRZ.q(i, aoVar.aSc);
                    kVar = this.aRZ.aRX;
                    kVar.RW();
                }
            }
        }
        this.aRZ.getLayoutBottom().startAnimation(this.aSb);
    }
}
