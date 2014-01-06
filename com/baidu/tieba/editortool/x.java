package com.baidu.tieba.editortool;

import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
/* loaded from: classes.dex */
public class x {
    public static void a(ViewGroup viewGroup, Context context, z zVar) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(200L);
        translateAnimation.setAnimationListener(new y(zVar, viewGroup));
        viewGroup.startAnimation(translateAnimation);
    }
}
