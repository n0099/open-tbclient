package com.baidu.tieba.editortool;

import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
/* loaded from: classes.dex */
public class l {
    public static void a(ViewGroup viewGroup, Context context, o oVar) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(200L);
        translateAnimation.setAnimationListener(new m(oVar, viewGroup));
        viewGroup.startAnimation(translateAnimation);
    }

    public static void b(ViewGroup viewGroup, Context context, o oVar) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(200L);
        translateAnimation.setAnimationListener(new n(oVar, viewGroup));
        viewGroup.startAnimation(translateAnimation);
    }

    public static void a(ViewGroup viewGroup, Context context) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(200L);
        viewGroup.startAnimation(translateAnimation);
    }
}
