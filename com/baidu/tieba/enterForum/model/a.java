package com.baidu.tieba.enterForum.model;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes9.dex */
public class a {
    private static a gSx;
    private boolean mHasInited;
    private int mStatusBarHeight;
    private WindowManager mWindowManager;

    public static a bPl() {
        if (gSx == null) {
            synchronized (a.class) {
                if (gSx == null) {
                    gSx = new a();
                }
            }
        }
        return gSx;
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
        gSx = null;
    }
}
