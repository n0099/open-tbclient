package com.baidu.tbadk.f;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class d {
    public static c x(View view) {
        if (view == null) {
            return null;
        }
        if (view instanceof LinearLayout) {
            return new e();
        }
        if (view instanceof RelativeLayout) {
            return new i();
        }
        if (view instanceof FrameLayout) {
            return new b();
        }
        return null;
    }
}
