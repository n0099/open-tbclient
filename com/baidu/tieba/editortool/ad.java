package com.baidu.tieba.editortool;

import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
/* loaded from: classes.dex */
public final class ad {
    public static void a(ViewGroup viewGroup, af afVar) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(200L);
        translateAnimation.setAnimationListener(new ae(afVar, viewGroup));
        viewGroup.startAnimation(translateAnimation);
    }
}
