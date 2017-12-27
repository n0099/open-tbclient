package com.baidu.tbadk.widget.pulltorefresh.library.a;

import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes.dex */
public class e {
    public static void postOnAnimation(View view, Runnable runnable) {
        view.postDelayed(runnable, 16L);
    }

    public static void setBackground(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }
}
