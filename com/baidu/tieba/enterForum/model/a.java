package com.baidu.tieba.enterForum.model;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes4.dex */
public class a {
    private static a eDt;
    private boolean aFU;
    private int mStatusBarHeight;
    private WindowManager mWindowManager;

    public static a aWO() {
        if (eDt == null) {
            synchronized (a.class) {
                if (eDt == null) {
                    eDt = new a();
                }
            }
        }
        return eDt;
    }

    private a() {
    }

    public void m(Context context, int i) {
        this.aFU = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.mStatusBarHeight = i;
    }

    public void destroy() {
        this.aFU = false;
        eDt = null;
    }
}
