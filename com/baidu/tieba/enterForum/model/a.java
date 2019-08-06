package com.baidu.tieba.enterForum.model;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes4.dex */
public class a {
    private static a eYB;
    private boolean aIw;
    private int mStatusBarHeight;
    private WindowManager mWindowManager;

    public static a bgk() {
        if (eYB == null) {
            synchronized (a.class) {
                if (eYB == null) {
                    eYB = new a();
                }
            }
        }
        return eYB;
    }

    private a() {
    }

    public void m(Context context, int i) {
        this.aIw = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.mStatusBarHeight = i;
    }

    public void destroy() {
        this.aIw = false;
        eYB = null;
    }
}
