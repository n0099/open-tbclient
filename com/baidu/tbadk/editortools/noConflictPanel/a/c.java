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
    private int ctQ = -1;
    private final View fpf;
    private final boolean fpg;
    private com.baidu.tbadk.editortools.noConflictPanel.a fph;
    private final int mStatusBarHeight;

    public c(View view) {
        this.fpf = view;
        this.mStatusBarHeight = com.baidu.tbadk.editortools.noConflictPanel.b.c.getStatusBarHeight(view.getContext());
        this.fpg = d.C((Activity) view.getContext());
    }

    @TargetApi(16)
    public void ac(int i, int i2) {
        if (this.fpg && Build.VERSION.SDK_INT >= 16 && this.fpf.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.fpf.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        Log.d("KPSRootLayoutHandler", "onMeasure, width: " + i + " height: " + i2);
        if (i2 >= 0) {
            if (this.ctQ < 0) {
                this.ctQ = i2;
                return;
            }
            int i3 = this.ctQ - i2;
            if (i3 == 0) {
                Log.d("KPSRootLayoutHandler", "" + i3 + " == 0 break;");
            } else if (Math.abs(i3) == this.mStatusBarHeight) {
                Log.w("KPSRootLayoutHandler", String.format("offset just equal statusBar height %d", Integer.valueOf(i3)));
            } else {
                this.ctQ = i2;
                com.baidu.tbadk.editortools.noConflictPanel.a bC = bC(this.fpf);
                if (bC == null) {
                    Log.w("KPSRootLayoutHandler", "can't find the valid panel conflict layout, give up!");
                } else if (Math.abs(i3) < com.baidu.tbadk.editortools.noConflictPanel.b.b.em(this.fpf.getContext())) {
                    Log.w("KPSRootLayoutHandler", "system bottom-menu-bar(such as HuaWei Mate7) causes layout changed");
                } else if (i3 > 0) {
                    bC.afr();
                } else if (bC.bzW() && bC.isVisible()) {
                    bC.afq();
                }
            }
        }
    }

    private com.baidu.tbadk.editortools.noConflictPanel.a bC(View view) {
        if (this.fph != null) {
            return this.fph;
        }
        if (view instanceof com.baidu.tbadk.editortools.noConflictPanel.a) {
            this.fph = (com.baidu.tbadk.editortools.noConflictPanel.a) view;
            return this.fph;
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ((ViewGroup) view).getChildCount()) {
                    break;
                }
                com.baidu.tbadk.editortools.noConflictPanel.a bC = bC(((ViewGroup) view).getChildAt(i2));
                if (bC == null) {
                    i = i2 + 1;
                } else {
                    this.fph = bC;
                    return this.fph;
                }
            }
        }
        return null;
    }
}
