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
    private int cza = -1;
    private final View fvS;
    private final boolean fvT;
    private com.baidu.tbadk.editortools.noConflictPanel.a fvU;
    private final int mStatusBarHeight;

    public c(View view) {
        this.fvS = view;
        this.mStatusBarHeight = com.baidu.tbadk.editortools.noConflictPanel.b.c.getStatusBarHeight(view.getContext());
        this.fvT = d.B((Activity) view.getContext());
    }

    @TargetApi(16)
    public void ae(int i, int i2) {
        if (this.fvT && Build.VERSION.SDK_INT >= 16 && this.fvS.getFitsSystemWindows()) {
            Rect rect = new Rect();
            this.fvS.getWindowVisibleDisplayFrame(rect);
            i2 = rect.bottom - rect.top;
        }
        Log.d("KPSRootLayoutHandler", "onMeasure, width: " + i + " height: " + i2);
        if (i2 >= 0) {
            if (this.cza < 0) {
                this.cza = i2;
                return;
            }
            int i3 = this.cza - i2;
            if (i3 == 0) {
                Log.d("KPSRootLayoutHandler", "" + i3 + " == 0 break;");
            } else if (Math.abs(i3) == this.mStatusBarHeight) {
                Log.w("KPSRootLayoutHandler", String.format("offset just equal statusBar height %d", Integer.valueOf(i3)));
            } else {
                this.cza = i2;
                com.baidu.tbadk.editortools.noConflictPanel.a bI = bI(this.fvS);
                if (bI == null) {
                    Log.w("KPSRootLayoutHandler", "can't find the valid panel conflict layout, give up!");
                } else if (Math.abs(i3) < com.baidu.tbadk.editortools.noConflictPanel.b.b.eR(this.fvS.getContext())) {
                    Log.w("KPSRootLayoutHandler", "system bottom-menu-bar(such as HuaWei Mate7) causes layout changed");
                } else if (i3 > 0) {
                    bI.ahR();
                } else if (bI.bCM() && bI.isVisible()) {
                    bI.ahQ();
                }
            }
        }
    }

    private com.baidu.tbadk.editortools.noConflictPanel.a bI(View view) {
        if (this.fvU != null) {
            return this.fvU;
        }
        if (view instanceof com.baidu.tbadk.editortools.noConflictPanel.a) {
            this.fvU = (com.baidu.tbadk.editortools.noConflictPanel.a) view;
            return this.fvU;
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ((ViewGroup) view).getChildCount()) {
                    break;
                }
                com.baidu.tbadk.editortools.noConflictPanel.a bI = bI(((ViewGroup) view).getChildAt(i2));
                if (bI == null) {
                    i = i2 + 1;
                } else {
                    this.fvU = bI;
                    return this.fvU;
                }
            }
        }
        return null;
    }
}
