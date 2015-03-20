package com.baidu.tieba.im.chat.officialBar;

import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements Animation.AnimationListener {
    final /* synthetic */ OfficialBarMsglistView aZt;
    private final /* synthetic */ boolean aZu;
    private final /* synthetic */ Animation aZv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(OfficialBarMsglistView officialBarMsglistView, boolean z, Animation animation) {
        this.aZt = officialBarMsglistView;
        this.aZu = z;
        this.aZv = animation;
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
        if (this.aZu) {
            linearLayout2 = this.aZt.aZo;
            linearLayout2.setVisibility(0);
            frameLayout2 = this.aZt.mInputControl;
            frameLayout2.setVisibility(8);
            imageView2 = this.aZt.aZn;
            imageView2.setImageResource(com.baidu.tieba.u.btn_bottombar_keyboard_above);
        } else {
            linearLayout = this.aZt.aZo;
            linearLayout.setVisibility(8);
            frameLayout = this.aZt.mInputControl;
            frameLayout.setVisibility(0);
            imageView = this.aZt.aZn;
            imageView.setImageResource(com.baidu.tieba.u.btn_bottombar_keyboard_below);
            for (int i = 0; i < 3; i++) {
                aiVarArr = this.aZt.aZs;
                ai aiVar = aiVarArr[i];
                if (aiVar.aZw) {
                    aiVar.aZw = false;
                    this.aZt.m(i, aiVar.aZw);
                    aVar = this.aZt.aZr;
                    aVar.TF();
                }
            }
        }
        this.aZt.getLayoutBottom().startAnimation(this.aZv);
    }
}
