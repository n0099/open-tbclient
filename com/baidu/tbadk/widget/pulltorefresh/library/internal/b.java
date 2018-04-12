package com.baidu.tbadk.widget.pulltorefresh.library.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    public static void postOnAnimation(View view2, Runnable runnable) {
        view2.postDelayed(runnable, 16L);
    }

    public static void setBackground(View view2, Drawable drawable) {
        view2.setBackgroundDrawable(drawable);
    }
}
