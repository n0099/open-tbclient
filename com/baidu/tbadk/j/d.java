package com.baidu.tbadk.j;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class d {
    public static c Q(View view2) {
        if (view2 == null) {
            return null;
        }
        if (view2 instanceof LinearLayout) {
            return new e();
        }
        if (view2 instanceof RelativeLayout) {
            return new h();
        }
        if (view2 instanceof FrameLayout) {
            return new b();
        }
        return null;
    }
}
