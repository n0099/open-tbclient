package com.baidu.tbadk.j;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class d {
    public static c Q(View view) {
        if (view == null) {
            return null;
        }
        if (view instanceof LinearLayout) {
            return new e();
        }
        if (view instanceof RelativeLayout) {
            return new h();
        }
        if (view instanceof FrameLayout) {
            return new b();
        }
        return null;
    }
}
