package com.baidu.tieba.ala.live.guess.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* loaded from: classes11.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();

    public static void n(View view, int i, int i2) {
        c(view, i, i2, 0, 0, 0, 0);
    }

    public static void c(View view, int i, int i2, int i3, int i4, int i5, int i6) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams != null) {
            if (i != -1 && i != -2 && i != -1) {
                layoutParams.width = a.bXK().uL(i);
            } else {
                layoutParams.width = i;
            }
            if (i2 != -1 && i2 != -2 && i2 != -1) {
                layoutParams.height = a.bXK().uM(i2);
            } else {
                layoutParams.height = i2;
            }
            layoutParams.topMargin = a.bXK().uM(i3);
            layoutParams.bottomMargin = a.bXK().uM(i4);
            layoutParams.leftMargin = a.bXK().uL(i5);
            layoutParams.rightMargin = a.bXK().uL(i6);
            view.setLayoutParams(layoutParams);
        }
    }

    public static void d(View view, int i, int i2, int i3, int i4, int i5, int i6) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams != null) {
            if (i != -1 && i != -2 && i != -1) {
                layoutParams.width = a.bXK().uL(i);
            } else {
                layoutParams.width = i;
            }
            if (i2 != -1 && i2 != -2 && i2 != -1) {
                layoutParams.height = a.bXK().uM(i2);
            } else {
                layoutParams.height = i2;
            }
            layoutParams.topMargin = a.bXK().uM(i3);
            layoutParams.bottomMargin = a.bXK().uM(i4);
            layoutParams.leftMargin = a.bXK().uL(i5);
            layoutParams.rightMargin = a.bXK().uL(i6);
            view.setLayoutParams(layoutParams);
        }
    }

    public static void c(TextView textView, int i) {
        textView.setTextSize(0, a.bXK().uM(i));
    }

    public static void o(View view, int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (i != -1 && i != -2 && i != -1) {
            layoutParams.width = a.bXK().uL(i);
        } else {
            layoutParams.width = i;
        }
        if (i2 != -1 && i2 != -2 && i2 != -1) {
            layoutParams.height = a.bXK().uM(i2);
        } else {
            layoutParams.height = i2;
        }
        view.setLayoutParams(layoutParams);
    }

    public static void p(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i != -1 && i != -2 && i != -1) {
            layoutParams.width = a.bXK().uL(i);
        } else {
            layoutParams.width = i;
        }
        if (i2 != -1 && i2 != -2 && i2 != -1) {
            layoutParams.height = a.bXK().uM(i2);
        } else {
            layoutParams.height = i2;
        }
        view.setLayoutParams(layoutParams);
    }
}
