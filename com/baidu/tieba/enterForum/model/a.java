package com.baidu.tieba.enterForum.model;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes9.dex */
public class a {
    private static a fWw;
    private boolean mHasInited;
    private int mStatusBarHeight;
    private WindowManager mWindowManager;

    public static a byL() {
        if (fWw == null) {
            synchronized (a.class) {
                if (fWw == null) {
                    fWw = new a();
                }
            }
        }
        return fWw;
    }

    private a() {
    }

    public void init(Context context, int i) {
        this.mHasInited = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.mStatusBarHeight = i;
    }

    public void destroy() {
        this.mHasInited = false;
        fWw = null;
    }
}
