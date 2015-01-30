package com.baidu.tieba.im.chat.officialBar;

import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements Animation.AnimationListener {
    final /* synthetic */ OfficialBarMsglistView aUI;
    private final /* synthetic */ boolean aUJ;
    private final /* synthetic */ Animation aUK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(OfficialBarMsglistView officialBarMsglistView, boolean z, Animation animation) {
        this.aUI = officialBarMsglistView;
        this.aUJ = z;
        this.aUK = animation;
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
        ah[] ahVarArr;
        com.baidu.tieba.im.view.k kVar;
        LinearLayout linearLayout2;
        FrameLayout frameLayout2;
        ImageView imageView2;
        if (this.aUJ) {
            linearLayout2 = this.aUI.aUD;
            linearLayout2.setVisibility(0);
            frameLayout2 = this.aUI.mInputControl;
            frameLayout2.setVisibility(8);
            imageView2 = this.aUI.aUC;
            imageView2.setImageResource(com.baidu.tieba.v.btn_bottombar_keyboard_above);
        } else {
            linearLayout = this.aUI.aUD;
            linearLayout.setVisibility(8);
            frameLayout = this.aUI.mInputControl;
            frameLayout.setVisibility(0);
            imageView = this.aUI.aUC;
            imageView.setImageResource(com.baidu.tieba.v.btn_bottombar_keyboard_below);
            for (int i = 0; i < 3; i++) {
                ahVarArr = this.aUI.aUH;
                ah ahVar = ahVarArr[i];
                if (ahVar.aUL) {
                    ahVar.aUL = false;
                    this.aUI.p(i, ahVar.aUL);
                    kVar = this.aUI.aUG;
                    kVar.TK();
                }
            }
        }
        this.aUI.getLayoutBottom().startAnimation(this.aUK);
    }
}
