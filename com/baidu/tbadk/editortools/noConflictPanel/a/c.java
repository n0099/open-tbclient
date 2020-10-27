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
    private int cnS = -1;
    private final View fjo;
    private final boolean fjp;
    private com.baidu.tbadk.editortools.noConflictPanel.a fjq;
    private final int mStatusBarHeight;

    public c(View view) {
        this.fjo = view;
        this.mStatusBarHeight = com.baidu.tbadk.editortools.noConflictPanel.b.c.getStatusBarHeight(view.getContext());
        this.fjp = d.C((Activity) view.getContext());
    }

    @TargetApi(16)
    public void ac(int i, int i2) {
        if (this.fjp && Build.VERSION.SDK_INT >= 16 && this.fjo.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.fjo.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        Log.d("KPSRootLayoutHandler", "onMeasure, width: " + i + " height: " + i2);
        if (i2 >= 0) {
            if (this.cnS < 0) {
                this.cnS = i2;
                return;
            }
            int i3 = this.cnS - i2;
            if (i3 == 0) {
                Log.d("KPSRootLayoutHandler", "" + i3 + " == 0 break;");
            } else if (Math.abs(i3) == this.mStatusBarHeight) {
                Log.w("KPSRootLayoutHandler", String.format("offset just equal statusBar height %d", Integer.valueOf(i3)));
            } else {
                this.cnS = i2;
                com.baidu.tbadk.editortools.noConflictPanel.a by = by(this.fjo);
                if (by == null) {
                    Log.w("KPSRootLayoutHandler", "can't find the valid panel conflict layout, give up!");
                } else if (Math.abs(i3) < com.baidu.tbadk.editortools.noConflictPanel.b.b.em(this.fjo.getContext())) {
                    Log.w("KPSRootLayoutHandler", "system bottom-menu-bar(such as HuaWei Mate7) causes layout changed");
                } else if (i3 > 0) {
                    by.acR();
                } else if (by.bxx() && by.isVisible()) {
                    by.acQ();
                }
            }
        }
    }

    private com.baidu.tbadk.editortools.noConflictPanel.a by(View view) {
        if (this.fjq != null) {
            return this.fjq;
        }
        if (view instanceof com.baidu.tbadk.editortools.noConflictPanel.a) {
            this.fjq = (com.baidu.tbadk.editortools.noConflictPanel.a) view;
            return this.fjq;
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ((ViewGroup) view).getChildCount()) {
                    break;
                }
                com.baidu.tbadk.editortools.noConflictPanel.a by = by(((ViewGroup) view).getChildAt(i2));
                if (by == null) {
                    i = i2 + 1;
                } else {
                    this.fjq = by;
                    return this.fjq;
                }
            }
        }
        return null;
    }
}
