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
    private int cDd = -1;
    private final View fEE;
    private final boolean fEF;
    private com.baidu.tbadk.editortools.noConflictPanel.a fEG;
    private final int mStatusBarHeight;

    public c(View view) {
        this.fEE = view;
        this.mStatusBarHeight = com.baidu.tbadk.editortools.noConflictPanel.b.c.getStatusBarHeight(view.getContext());
        this.fEF = d.u((Activity) view.getContext());
    }

    @TargetApi(16)
    public void W(int i, int i2) {
        if (this.fEF && Build.VERSION.SDK_INT >= 16 && this.fEE.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.fEE.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        Log.d("KPSRootLayoutHandler", "onMeasure, width: " + i + " height: " + i2);
        if (i2 >= 0) {
            if (this.cDd < 0) {
                this.cDd = i2;
                return;
            }
            int i3 = this.cDd - i2;
            if (i3 == 0) {
                Log.d("KPSRootLayoutHandler", "" + i3 + " == 0 break;");
            } else if (Math.abs(i3) == this.mStatusBarHeight) {
                Log.w("KPSRootLayoutHandler", String.format("offset just equal statusBar height %d", Integer.valueOf(i3)));
            } else {
                this.cDd = i2;
                com.baidu.tbadk.editortools.noConflictPanel.a bN = bN(this.fEE);
                if (bN == null) {
                    Log.w("KPSRootLayoutHandler", "can't find the valid panel conflict layout, give up!");
                } else if (Math.abs(i3) < com.baidu.tbadk.editortools.noConflictPanel.b.b.fj(this.fEE.getContext())) {
                    Log.w("KPSRootLayoutHandler", "system bottom-menu-bar(such as HuaWei Mate7) causes layout changed");
                } else if (i3 > 0) {
                    bN.afJ();
                } else if (bN.bBJ() && bN.isVisible()) {
                    bN.afI();
                }
            }
        }
    }

    private com.baidu.tbadk.editortools.noConflictPanel.a bN(View view) {
        if (this.fEG != null) {
            return this.fEG;
        }
        if (view instanceof com.baidu.tbadk.editortools.noConflictPanel.a) {
            this.fEG = (com.baidu.tbadk.editortools.noConflictPanel.a) view;
            return this.fEG;
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ((ViewGroup) view).getChildCount()) {
                    break;
                }
                com.baidu.tbadk.editortools.noConflictPanel.a bN = bN(((ViewGroup) view).getChildAt(i2));
                if (bN == null) {
                    i = i2 + 1;
                } else {
                    this.fEG = bN;
                    return this.fEG;
                }
            }
        }
        return null;
    }
}
