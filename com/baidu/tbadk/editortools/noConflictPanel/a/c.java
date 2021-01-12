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
    private int czh = -1;
    private final View fAQ;
    private final boolean fAR;
    private com.baidu.tbadk.editortools.noConflictPanel.a fAS;
    private final int mStatusBarHeight;

    public c(View view) {
        this.fAQ = view;
        this.mStatusBarHeight = com.baidu.tbadk.editortools.noConflictPanel.b.c.getStatusBarHeight(view.getContext());
        this.fAR = d.A((Activity) view.getContext());
    }

    @TargetApi(16)
    public void Z(int i, int i2) {
        if (this.fAR && Build.VERSION.SDK_INT >= 16 && this.fAQ.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.fAQ.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        Log.d("KPSRootLayoutHandler", "onMeasure, width: " + i + " height: " + i2);
        if (i2 >= 0) {
            if (this.czh < 0) {
                this.czh = i2;
                return;
            }
            int i3 = this.czh - i2;
            if (i3 == 0) {
                Log.d("KPSRootLayoutHandler", "" + i3 + " == 0 break;");
            } else if (Math.abs(i3) == this.mStatusBarHeight) {
                Log.w("KPSRootLayoutHandler", String.format("offset just equal statusBar height %d", Integer.valueOf(i3)));
            } else {
                this.czh = i2;
                com.baidu.tbadk.editortools.noConflictPanel.a bR = bR(this.fAQ);
                if (bR == null) {
                    Log.w("KPSRootLayoutHandler", "can't find the valid panel conflict layout, give up!");
                } else if (Math.abs(i3) < com.baidu.tbadk.editortools.noConflictPanel.b.b.fl(this.fAQ.getContext())) {
                    Log.w("KPSRootLayoutHandler", "system bottom-menu-bar(such as HuaWei Mate7) causes layout changed");
                } else if (i3 > 0) {
                    bR.afh();
                } else if (bR.bBo() && bR.isVisible()) {
                    bR.afg();
                }
            }
        }
    }

    private com.baidu.tbadk.editortools.noConflictPanel.a bR(View view) {
        if (this.fAS != null) {
            return this.fAS;
        }
        if (view instanceof com.baidu.tbadk.editortools.noConflictPanel.a) {
            this.fAS = (com.baidu.tbadk.editortools.noConflictPanel.a) view;
            return this.fAS;
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
                    this.fAS = bR;
                    return this.fAS;
                }
            }
        }
        return null;
    }
}
