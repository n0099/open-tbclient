package com.baidu.tieba.enterForum.model;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes9.dex */
public class a {
    private static a fWh;
    private boolean mHasInited;
    private int mStatusBarHeight;
    private WindowManager mWindowManager;

    public static a byI() {
        if (fWh == null) {
            synchronized (a.class) {
                if (fWh == null) {
                    fWh = new a();
                }
            }
        }
        return fWh;
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
        fWh = null;
    }
}
