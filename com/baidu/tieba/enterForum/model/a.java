package com.baidu.tieba.enterForum.model;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes4.dex */
public class a {
    private static a eDM;
    private boolean aFQ;
    private int mStatusBarHeight;
    private WindowManager mWindowManager;

    public static a aWR() {
        if (eDM == null) {
            synchronized (a.class) {
                if (eDM == null) {
                    eDM = new a();
                }
            }
        }
        return eDM;
    }

    private a() {
    }

    public void m(Context context, int i) {
        this.aFQ = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.mStatusBarHeight = i;
    }

    public void destroy() {
        this.aFQ = false;
        eDM = null;
    }
}
