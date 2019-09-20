package com.baidu.tieba.enterForum.model;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes4.dex */
public class a {
    private static a fah;
    private boolean aIU;
    private int mStatusBarHeight;
    private WindowManager mWindowManager;

    public static a bgQ() {
        if (fah == null) {
            synchronized (a.class) {
                if (fah == null) {
                    fah = new a();
                }
            }
        }
        return fah;
    }

    private a() {
    }

    public void m(Context context, int i) {
        this.aIU = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.mStatusBarHeight = i;
    }

    public void destroy() {
        this.aIU = false;
        fah = null;
    }
}
