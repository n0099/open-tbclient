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
    private int cDT = -1;
    private com.baidu.tbadk.editortools.noConflictPanel.a fFA;
    private final View fFy;
    private final boolean fFz;
    private final int mStatusBarHeight;

    public c(View view) {
        this.fFy = view;
        this.mStatusBarHeight = com.baidu.tbadk.editortools.noConflictPanel.b.c.getStatusBarHeight(view.getContext());
        this.fFz = d.A((Activity) view.getContext());
    }

    @TargetApi(16)
    public void Z(int i, int i2) {
        if (this.fFz && Build.VERSION.SDK_INT >= 16 && this.fFy.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.fFy.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        Log.d("KPSRootLayoutHandler", "onMeasure, width: " + i + " height: " + i2);
        if (i2 >= 0) {
            if (this.cDT < 0) {
                this.cDT = i2;
                return;
            }
            int i3 = this.cDT - i2;
            if (i3 == 0) {
                Log.d("KPSRootLayoutHandler", "" + i3 + " == 0 break;");
            } else if (Math.abs(i3) == this.mStatusBarHeight) {
                Log.w("KPSRootLayoutHandler", String.format("offset just equal statusBar height %d", Integer.valueOf(i3)));
            } else {
                this.cDT = i2;
                com.baidu.tbadk.editortools.noConflictPanel.a bR = bR(this.fFy);
                if (bR == null) {
                    Log.w("KPSRootLayoutHandler", "can't find the valid panel conflict layout, give up!");
                } else if (Math.abs(i3) < com.baidu.tbadk.editortools.noConflictPanel.b.b.fn(this.fFy.getContext())) {
                    Log.w("KPSRootLayoutHandler", "system bottom-menu-bar(such as HuaWei Mate7) causes layout changed");
                } else if (i3 > 0) {
                    bR.aja();
                } else if (bR.bFh() && bR.isVisible()) {
                    bR.aiZ();
                }
            }
        }
    }

    private com.baidu.tbadk.editortools.noConflictPanel.a bR(View view) {
        if (this.fFA != null) {
            return this.fFA;
        }
        if (view instanceof com.baidu.tbadk.editortools.noConflictPanel.a) {
            this.fFA = (com.baidu.tbadk.editortools.noConflictPanel.a) view;
            return this.fFA;
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ((ViewGroup) view).getChildCount()) {
                    break;
                }
                com.baidu.tbadk.editortools.noConflictPanel.a bR = bR(((ViewGroup) view).getChildAt(i2));
                if (bR == null) {
                    i = i2 + 1;
                } else {
                    this.fFA = bR;
                    return this.fFA;
                }
            }
        }
        return null;
    }
}
