package com.baidu.tieba.editortool;

import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
/* loaded from: classes.dex */
public class ax {
    public static void a(ViewGroup viewGroup, Context context, az azVar) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(200L);
        translateAnimation.setAnimationListener(new ay(azVar, viewGroup));
        viewGroup.startAnimation(translateAnimation);
    }
}
