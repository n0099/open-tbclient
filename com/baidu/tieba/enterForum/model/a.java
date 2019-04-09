package com.baidu.tieba.enterForum.model;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes4.dex */
public class a {
    private static a eDu;
    private boolean aFV;
    private int mStatusBarHeight;
    private WindowManager mWindowManager;

    public static a aWO() {
        if (eDu == null) {
            synchronized (a.class) {
                if (eDu == null) {
                    eDu = new a();
                }
            }
        }
        return eDu;
    }

    private a() {
    }

    public void m(Context context, int i) {
        this.aFV = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.mStatusBarHeight = i;
    }

    public void destroy() {
        this.aFV = false;
        eDu = null;
    }
}
