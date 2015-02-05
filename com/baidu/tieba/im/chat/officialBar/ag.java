package com.baidu.tieba.im.chat.officialBar;

import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements Animation.AnimationListener {
    final /* synthetic */ OfficialBarMsglistView aUH;
    private final /* synthetic */ boolean aUI;
    private final /* synthetic */ Animation aUJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(OfficialBarMsglistView officialBarMsglistView, boolean z, Animation animation) {
        this.aUH = officialBarMsglistView;
        this.aUI = z;
        this.aUJ = animation;
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
        if (this.aUI) {
            linearLayout2 = this.aUH.aUC;
            linearLayout2.setVisibility(0);
            frameLayout2 = this.aUH.mInputControl;
            frameLayout2.setVisibility(8);
            imageView2 = this.aUH.aUB;
            imageView2.setImageResource(com.baidu.tieba.v.btn_bottombar_keyboard_above);
        } else {
            linearLayout = this.aUH.aUC;
            linearLayout.setVisibility(8);
            frameLayout = this.aUH.mInputControl;
            frameLayout.setVisibility(0);
            imageView = this.aUH.aUB;
            imageView.setImageResource(com.baidu.tieba.v.btn_bottombar_keyboard_below);
            for (int i = 0; i < 3; i++) {
                ahVarArr = this.aUH.aUG;
                ah ahVar = ahVarArr[i];
                if (ahVar.aUK) {
                    ahVar.aUK = false;
                    this.aUH.p(i, ahVar.aUK);
                    kVar = this.aUH.aUF;
                    kVar.TF();
                }
            }
        }
        this.aUH.getLayoutBottom().startAnimation(this.aUJ);
    }
}
