package com.baidu.tieba.im.chat.officialBar;

import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements Animation.AnimationListener {
    final /* synthetic */ OfficialBarMsglistView aTs;
    private final /* synthetic */ boolean aTt;
    private final /* synthetic */ Animation aTu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(OfficialBarMsglistView officialBarMsglistView, boolean z, Animation animation) {
        this.aTs = officialBarMsglistView;
        this.aTt = z;
        this.aTu = animation;
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
        if (this.aTt) {
            linearLayout2 = this.aTs.aTn;
            linearLayout2.setVisibility(0);
            frameLayout2 = this.aTs.mInputControl;
            frameLayout2.setVisibility(8);
            imageView2 = this.aTs.aTm;
            imageView2.setImageResource(com.baidu.tieba.v.btn_bottombar_keyboard_above);
        } else {
            linearLayout = this.aTs.aTn;
            linearLayout.setVisibility(8);
            frameLayout = this.aTs.mInputControl;
            frameLayout.setVisibility(0);
            imageView = this.aTs.aTm;
            imageView.setImageResource(com.baidu.tieba.v.btn_bottombar_keyboard_below);
            for (int i = 0; i < 3; i++) {
                ahVarArr = this.aTs.aTr;
                ah ahVar = ahVarArr[i];
                if (ahVar.aTv) {
                    ahVar.aTv = false;
                    this.aTs.p(i, ahVar.aTv);
                    kVar = this.aTs.aTq;
                    kVar.To();
                }
            }
        }
        this.aTs.getLayoutBottom().startAnimation(this.aTu);
    }
}
