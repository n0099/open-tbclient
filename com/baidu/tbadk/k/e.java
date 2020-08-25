package com.baidu.tbadk.k;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
/* loaded from: classes2.dex */
public class e {
    public static d bs(View view) {
        if (view == null) {
            return null;
        }
        if (view instanceof LinearLayout) {
            return new f();
        }
        if (view instanceof RelativeLayout) {
            return new i();
        }
        if (view instanceof FrameLayout) {
            return new b();
        }
        return null;
    }

    public static d f(View view, boolean z) {
        if (view == null) {
            return null;
        }
        if (view instanceof LinearLayout) {
            return new f();
        }
        if (view instanceof RelativeLayout) {
            return new i();
        }
        if (view instanceof FrameLayout) {
            return z ? new j() : new b();
        }
        return null;
    }
}
