package com.baidu.tieba.enterForum.model;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes9.dex */
public class a {
    private static a gSI;
    private boolean mHasInited;
    private int mStatusBarHeight;
    private WindowManager mWindowManager;

    public static a bPn() {
        if (gSI == null) {
            synchronized (a.class) {
                if (gSI == null) {
                    gSI = new a();
                }
            }
        }
        return gSI;
    }

    private a() {
    }

    public void m(Context context, int i) {
        this.mHasInited = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.mStatusBarHeight = i;
    }

    public void destroy() {
        this.mHasInited = false;
        gSI = null;
    }
}
