package com.baidu.tieba.enterForum.model;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes4.dex */
public class a {
    private static a eTl;
    private boolean aHO;
    private int mStatusBarHeight;
    private WindowManager mWindowManager;

    public static a beb() {
        if (eTl == null) {
            synchronized (a.class) {
                if (eTl == null) {
                    eTl = new a();
                }
            }
        }
        return eTl;
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
        eTl = null;
    }
}
