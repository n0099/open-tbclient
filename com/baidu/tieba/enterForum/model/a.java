package com.baidu.tieba.enterForum.model;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes4.dex */
public class a {
    private static a eTm;
    private boolean aHO;
    private int mStatusBarHeight;
    private WindowManager mWindowManager;

    public static a bee() {
        if (eTm == null) {
            synchronized (a.class) {
                if (eTm == null) {
                    eTm = new a();
                }
            }
        }
        return eTm;
    }

    private a() {
    }

    public void m(Context context, int i) {
        this.aHO = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.mStatusBarHeight = i;
    }

    public void destroy() {
        this.aHO = false;
        eTm = null;
    }
}
