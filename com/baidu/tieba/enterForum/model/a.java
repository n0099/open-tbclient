package com.baidu.tieba.enterForum.model;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes9.dex */
public class a {
    private static a gDI;
    private boolean mHasInited;
    private int mStatusBarHeight;
    private WindowManager mWindowManager;

    public static a bIT() {
        if (gDI == null) {
            synchronized (a.class) {
                if (gDI == null) {
                    gDI = new a();
                }
            }
        }
        return gDI;
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
        gDI = null;
    }
}
