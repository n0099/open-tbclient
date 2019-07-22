package com.baidu.tieba.enterForum.model;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes4.dex */
public class a {
    private static a eYn;
    private boolean aIw;
    private int mStatusBarHeight;
    private WindowManager mWindowManager;

    public static a bgh() {
        if (eYn == null) {
            synchronized (a.class) {
                if (eYn == null) {
                    eYn = new a();
                }
            }
        }
        return eYn;
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
        eYn = null;
    }
}
