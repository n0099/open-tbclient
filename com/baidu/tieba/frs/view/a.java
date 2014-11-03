package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
/* loaded from: classes.dex */
public class a {
    protected boolean aEU;

    public boolean GT() {
        return this.aEU;
    }

    public void a(Context context, View view, float f, float f2) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(1000L);
        com.baidu.tbadk.core.a.a(context, view, scaleAnimation, (Animation.AnimationListener) null);
    }

    public void b(Context context, View view, float f, float f2) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, 1.0f, 1.0f, 1.0f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(400L);
        com.baidu.tbadk.core.a.a(context, view, scaleAnimation, new b(this, context, view, f2));
    }

    public void a(boolean z, float f) {
    }
}
