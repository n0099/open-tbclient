package com.baidu.tieba.enterForum.model;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes2.dex */
public class a {
    private static a iKp;
    private boolean mHasInited;
    private int mStatusBarHeight;
    private WindowManager mWindowManager;

    public static a czd() {
        if (iKp == null) {
            synchronized (a.class) {
                if (iKp == null) {
                    iKp = new a();
                }
            }
        }
        return iKp;
    }

    private a() {
    }

    public void w(Context context, int i) {
        this.mHasInited = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.mStatusBarHeight = i;
    }

    public void destroy() {
        this.mHasInited = false;
        iKp = null;
    }
}
