package com.baidu.tieba.hottopic.view;

import android.graphics.drawable.AnimationDrawable;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements AbsListView.OnScrollListener {
    final /* synthetic */ c bMS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.bMS = cVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        ImageView imageView;
        LinearLayout linearLayout;
        Animation animation;
        LinearLayout linearLayout2;
        Animation animation2;
        LinearLayout linearLayout3;
        Animation animation3;
        LinearLayout linearLayout4;
        Animation animation4;
        LinearLayout linearLayout5;
        Animation animation5;
        LinearLayout linearLayout6;
        Animation animation6;
        AnimationDrawable animationDrawable;
        LinearLayout linearLayout7;
        Animation animation7;
        LinearLayout linearLayout8;
        Animation animation8;
        AnimationDrawable animationDrawable2;
        this.bMS.index = i;
        imageView = this.bMS.bMH;
        if (imageView.getDrawable() instanceof AnimationDrawable) {
            if (i <= 1) {
                linearLayout7 = this.bMS.bMI;
                Animation animation9 = linearLayout7.getAnimation();
                animation7 = this.bMS.bMP;
                if (animation9 != animation7) {
                    linearLayout8 = this.bMS.bMI;
                    animation8 = this.bMS.bMP;
                    linearLayout8.startAnimation(animation8);
                    animationDrawable2 = this.bMS.bML;
                    animationDrawable2.start();
                    return;
                }
                return;
            }
            linearLayout5 = this.bMS.bMI;
            Animation animation10 = linearLayout5.getAnimation();
            animation5 = this.bMS.bMO;
            if (animation10 != animation5) {
                linearLayout6 = this.bMS.bMI;
                animation6 = this.bMS.bMO;
                linearLayout6.startAnimation(animation6);
                animationDrawable = this.bMS.bML;
                animationDrawable.stop();
            }
        } else if (i >= 2) {
            linearLayout3 = this.bMS.bMI;
            Animation animation11 = linearLayout3.getAnimation();
            animation3 = this.bMS.bMM;
            if (animation11 != animation3) {
                linearLayout4 = this.bMS.bMI;
                animation4 = this.bMS.bMM;
                linearLayout4.startAnimation(animation4);
            }
        } else {
            linearLayout = this.bMS.bMI;
            Animation animation12 = linearLayout.getAnimation();
            animation = this.bMS.bMM;
            if (animation12 == animation) {
                linearLayout2 = this.bMS.bMI;
                animation2 = this.bMS.bMN;
                linearLayout2.startAnimation(animation2);
            }
        }
    }
}
