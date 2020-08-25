package com.baidu.tieba.enterForum.model;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes16.dex */
public class a {
    private static a hxS;
    private boolean mHasInited;
    private int mStatusBarHeight;
    private WindowManager mWindowManager;

    public static a cfV() {
        if (hxS == null) {
            synchronized (a.class) {
                if (hxS == null) {
                    hxS = new a();
                }
            }
        }
        return hxS;
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
        hxS = null;
    }
}
