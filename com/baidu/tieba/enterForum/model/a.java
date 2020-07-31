package com.baidu.tieba.enterForum.model;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes16.dex */
public class a {
    private static a hlb;
    private boolean mHasInited;
    private int mStatusBarHeight;
    private WindowManager mWindowManager;

    public static a bVI() {
        if (hlb == null) {
            synchronized (a.class) {
                if (hlb == null) {
                    hlb = new a();
                }
            }
        }
        return hlb;
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
        hlb = null;
    }
}
