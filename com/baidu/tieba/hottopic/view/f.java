package com.baidu.tieba.hottopic.view;

import android.graphics.drawable.AnimationDrawable;
import android.view.animation.Animation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements AbsListView.OnScrollListener {
    final /* synthetic */ a bJl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        this.bJl = aVar;
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
        this.bJl.index = i;
        imageView = this.bJl.bJa;
        if (imageView.getDrawable() instanceof AnimationDrawable) {
            if (i <= 1) {
                linearLayout7 = this.bJl.bJb;
                Animation animation9 = linearLayout7.getAnimation();
                animation7 = this.bJl.bJi;
                if (animation9 != animation7) {
                    linearLayout8 = this.bJl.bJb;
                    animation8 = this.bJl.bJi;
                    linearLayout8.startAnimation(animation8);
                    animationDrawable2 = this.bJl.bJe;
                    animationDrawable2.start();
                    return;
                }
                return;
            }
            linearLayout5 = this.bJl.bJb;
            Animation animation10 = linearLayout5.getAnimation();
            animation5 = this.bJl.bJh;
            if (animation10 != animation5) {
                linearLayout6 = this.bJl.bJb;
                animation6 = this.bJl.bJh;
                linearLayout6.startAnimation(animation6);
                animationDrawable = this.bJl.bJe;
                animationDrawable.stop();
            }
        } else if (i >= 2) {
            linearLayout3 = this.bJl.bJb;
            Animation animation11 = linearLayout3.getAnimation();
            animation3 = this.bJl.bJf;
            if (animation11 != animation3) {
                linearLayout4 = this.bJl.bJb;
                animation4 = this.bJl.bJf;
                linearLayout4.startAnimation(animation4);
            }
        } else {
            linearLayout = this.bJl.bJb;
            Animation animation12 = linearLayout.getAnimation();
            animation = this.bJl.bJf;
            if (animation12 == animation) {
                linearLayout2 = this.bJl.bJb;
                animation2 = this.bJl.bJg;
                linearLayout2.startAnimation(animation2);
            }
        }
    }
}
