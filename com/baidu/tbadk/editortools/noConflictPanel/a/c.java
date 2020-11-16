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
    private int cse = -1;
    private final View fon;
    private final boolean foo;
    private com.baidu.tbadk.editortools.noConflictPanel.a fop;
    private final int mStatusBarHeight;

    public c(View view) {
        this.fon = view;
        this.mStatusBarHeight = com.baidu.tbadk.editortools.noConflictPanel.b.c.getStatusBarHeight(view.getContext());
        this.foo = d.B((Activity) view.getContext());
    }

    @TargetApi(16)
    public void ac(int i, int i2) {
        if (this.foo && Build.VERSION.SDK_INT >= 16 && this.fon.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.fon.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        Log.d("KPSRootLayoutHandler", "onMeasure, width: " + i + " height: " + i2);
        if (i2 >= 0) {
            if (this.cse < 0) {
                this.cse = i2;
                return;
            }
            int i3 = this.cse - i2;
            if (i3 == 0) {
                Log.d("KPSRootLayoutHandler", "" + i3 + " == 0 break;");
            } else if (Math.abs(i3) == this.mStatusBarHeight) {
                Log.w("KPSRootLayoutHandler", String.format("offset just equal statusBar height %d", Integer.valueOf(i3)));
            } else {
                this.cse = i2;
                com.baidu.tbadk.editortools.noConflictPanel.a bF = bF(this.fon);
                if (bF == null) {
                    Log.w("KPSRootLayoutHandler", "can't find the valid panel conflict layout, give up!");
                } else if (Math.abs(i3) < com.baidu.tbadk.editortools.noConflictPanel.b.b.em(this.fon.getContext())) {
                    Log.w("KPSRootLayoutHandler", "system bottom-menu-bar(such as HuaWei Mate7) causes layout changed");
                } else if (i3 > 0) {
                    bF.aeJ();
                } else if (bF.bzm() && bF.isVisible()) {
                    bF.aeI();
                }
            }
        }
    }

    private com.baidu.tbadk.editortools.noConflictPanel.a bF(View view) {
        if (this.fop != null) {
            return this.fop;
        }
        if (view instanceof com.baidu.tbadk.editortools.noConflictPanel.a) {
            this.fop = (com.baidu.tbadk.editortools.noConflictPanel.a) view;
            return this.fop;
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ((ViewGroup) view).getChildCount()) {
                    break;
                }
                com.baidu.tbadk.editortools.noConflictPanel.a bF = bF(((ViewGroup) view).getChildAt(i2));
                if (bF == null) {
                    i = i2 + 1;
                } else {
                    this.fop = bF;
                    return this.fop;
                }
            }
        }
        return null;
    }
}
