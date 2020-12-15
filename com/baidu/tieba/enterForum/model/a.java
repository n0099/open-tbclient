package com.baidu.tieba.enterForum.model;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes22.dex */
public class a {
    private static a iyc;
    private boolean mHasInited;
    private int mStatusBarHeight;
    private WindowManager mWindowManager;

    public static a cwk() {
        if (iyc == null) {
            synchronized (a.class) {
                if (iyc == null) {
                    iyc = new a();
                }
            }
        }
        return iyc;
    }

    private a() {
    }

    public void v(Context context, int i) {
        this.mHasInited = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.mStatusBarHeight = i;
    }

    public void destroy() {
        this.mHasInited = false;
        iyc = null;
    }
}
