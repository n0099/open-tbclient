package com.baidu.tieba.im.chat.officialBar;

import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements Animation.AnimationListener {
    final /* synthetic */ OfficialBarMsglistView a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ Animation c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(OfficialBarMsglistView officialBarMsglistView, boolean z, Animation animation) {
        this.a = officialBarMsglistView;
        this.b = z;
        this.c = animation;
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
        com.baidu.tieba.im.view.n nVar;
        LinearLayout linearLayout2;
        FrameLayout frameLayout2;
        ImageView imageView2;
        if (this.b) {
            linearLayout2 = this.a.o;
            linearLayout2.setVisibility(0);
            frameLayout2 = this.a.g;
            frameLayout2.setVisibility(8);
            imageView2 = this.a.n;
            imageView2.setImageResource(com.baidu.tieba.t.btn_bottombar_keyboard_above);
        } else {
            linearLayout = this.a.o;
            linearLayout.setVisibility(8);
            frameLayout = this.a.g;
            frameLayout.setVisibility(0);
            imageView = this.a.n;
            imageView.setImageResource(com.baidu.tieba.t.btn_bottombar_keyboard_below);
            for (int i = 0; i < 3; i++) {
                aoVarArr = this.a.s;
                ao aoVar = aoVarArr[i];
                if (aoVar.a) {
                    aoVar.a = false;
                    this.a.a(i, aoVar.a);
                    nVar = this.a.r;
                    nVar.a();
                }
            }
        }
        this.a.e().startAnimation(this.c);
    }
}
