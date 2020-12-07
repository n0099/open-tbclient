package com.baidu.tieba.enterForum.model;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes22.dex */
public class a {
    private static a iya;
    private boolean mHasInited;
    private int mStatusBarHeight;
    private WindowManager mWindowManager;

    public static a cwj() {
        if (iya == null) {
            synchronized (a.class) {
                if (iya == null) {
                    iya = new a();
                }
            }
        }
        return iya;
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
        iya = null;
    }
}
