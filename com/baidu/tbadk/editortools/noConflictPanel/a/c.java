package com.baidu.tbadk.editortools.noConflictPanel.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.editortools.noConflictPanel.b.d;
/* loaded from: classes.dex */
public class c {
    private int cft = -1;
    private final View faP;
    private final boolean faQ;
    private com.baidu.tbadk.editortools.noConflictPanel.a faR;
    private final int mStatusBarHeight;

    public c(View view) {
        this.faP = view;
        this.mStatusBarHeight = com.baidu.tbadk.editortools.noConflictPanel.b.c.getStatusBarHeight(view.getContext());
        this.faQ = d.C((Activity) view.getContext());
    }

    @TargetApi(16)
    public void ab(int i, int i2) {
        if (this.faQ && Build.VERSION.SDK_INT >= 16 && this.faP.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.faP.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        Log.d("KPSRootLayoutHandler", "onMeasure, width: " + i + " height: " + i2);
        if (i2 >= 0) {
            if (this.cft < 0) {
                this.cft = i2;
                return;
            }
            int i3 = this.cft - i2;
            if (i3 == 0) {
                Log.d("KPSRootLayoutHandler", "" + i3 + " == 0 break;");
            } else if (Math.abs(i3) == this.mStatusBarHeight) {
                Log.w("KPSRootLayoutHandler", String.format("offset just equal statusBar height %d", Integer.valueOf(i3)));
            } else {
                this.cft = i2;
                com.baidu.tbadk.editortools.noConflictPanel.a bx = bx(this.faP);
                if (bx == null) {
                    Log.w("KPSRootLayoutHandler", "can't find the valid panel conflict layout, give up!");
                } else if (Math.abs(i3) < com.baidu.tbadk.editortools.noConflictPanel.b.b.em(this.faP.getContext())) {
                    Log.w("KPSRootLayoutHandler", "system bottom-menu-bar(such as HuaWei Mate7) causes layout changed");
                } else if (i3 > 0) {
                    bx.aaX();
                } else if (bx.bvE() && bx.isVisible()) {
                    bx.aaW();
                }
            }
        }
    }

    private com.baidu.tbadk.editortools.noConflictPanel.a bx(View view) {
        if (this.faR != null) {
            return this.faR;
        }
        if (view instanceof com.baidu.tbadk.editortools.noConflictPanel.a) {
            this.faR = (com.baidu.tbadk.editortools.noConflictPanel.a) view;
            return this.faR;
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ((ViewGroup) view).getChildCount()) {
                    break;
                }
                com.baidu.tbadk.editortools.noConflictPanel.a bx = bx(((ViewGroup) view).getChildAt(i2));
                if (bx == null) {
                    i = i2 + 1;
                } else {
                    this.faR = bx;
                    return this.faR;
                }
            }
        }
        return null;
    }
}
