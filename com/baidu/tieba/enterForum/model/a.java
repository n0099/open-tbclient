package com.baidu.tieba.enterForum.model;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes4.dex */
public class a {
    private static a eDI;
    private boolean aFR;
    private int mStatusBarHeight;
    private WindowManager mWindowManager;

    public static a aWQ() {
        if (eDI == null) {
            synchronized (a.class) {
                if (eDI == null) {
                    eDI = new a();
                }
            }
        }
        return eDI;
    }

    private a() {
    }

    public void m(Context context, int i) {
        this.aFR = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.mStatusBarHeight = i;
    }

    public void destroy() {
        this.aFR = false;
        eDI = null;
    }
}
