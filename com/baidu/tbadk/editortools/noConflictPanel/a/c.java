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
    private int bTf = -1;
    private final View eOI;
    private final boolean eOJ;
    private com.baidu.tbadk.editortools.noConflictPanel.a eOK;
    private final int mStatusBarHeight;

    public c(View view) {
        this.eOI = view;
        this.mStatusBarHeight = com.baidu.tbadk.editortools.noConflictPanel.b.c.getStatusBarHeight(view.getContext());
        this.eOJ = d.B((Activity) view.getContext());
    }

    @TargetApi(16)
    public void ac(int i, int i2) {
        if (this.eOJ && Build.VERSION.SDK_INT >= 16 && this.eOI.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.eOI.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        Log.d("KPSRootLayoutHandler", "onMeasure, width: " + i + " height: " + i2);
        if (i2 >= 0) {
            if (this.bTf < 0) {
                this.bTf = i2;
                return;
            }
            int i3 = this.bTf - i2;
            if (i3 == 0) {
                Log.d("KPSRootLayoutHandler", "" + i3 + " == 0 break;");
            } else if (Math.abs(i3) == this.mStatusBarHeight) {
                Log.w("KPSRootLayoutHandler", String.format("offset just equal statusBar height %d", Integer.valueOf(i3)));
            } else {
                this.bTf = i2;
                com.baidu.tbadk.editortools.noConflictPanel.a bt = bt(this.eOI);
                if (bt == null) {
                    Log.w("KPSRootLayoutHandler", "can't find the valid panel conflict layout, give up!");
                } else if (Math.abs(i3) < com.baidu.tbadk.editortools.noConflictPanel.b.b.ef(this.eOI.getContext())) {
                    Log.w("KPSRootLayoutHandler", "system bottom-menu-bar(such as HuaWei Mate7) causes layout changed");
                } else if (i3 > 0) {
                    bt.Yl();
                } else if (bt.bsU() && bt.isVisible()) {
                    bt.Yk();
                }
            }
        }
    }

    private com.baidu.tbadk.editortools.noConflictPanel.a bt(View view) {
        if (this.eOK != null) {
            return this.eOK;
        }
        if (view instanceof com.baidu.tbadk.editortools.noConflictPanel.a) {
            this.eOK = (com.baidu.tbadk.editortools.noConflictPanel.a) view;
            return this.eOK;
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ((ViewGroup) view).getChildCount()) {
                    break;
                }
                com.baidu.tbadk.editortools.noConflictPanel.a bt = bt(((ViewGroup) view).getChildAt(i2));
                if (bt == null) {
                    i = i2 + 1;
                } else {
                    this.eOK = bt;
                    return this.eOK;
                }
            }
        }
        return null;
    }
}
