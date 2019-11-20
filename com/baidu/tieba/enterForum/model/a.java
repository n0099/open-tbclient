package com.baidu.tieba.enterForum.model;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes4.dex */
public class a {
    private static a fcb;
    private boolean bbQ;
    private int mStatusBarHeight;
    private WindowManager mWindowManager;

    public static a beH() {
        if (fcb == null) {
            synchronized (a.class) {
                if (fcb == null) {
                    fcb = new a();
                }
            }
        }
        return fcb;
    }

    private a() {
    }

    public void k(Context context, int i) {
        this.bbQ = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.mStatusBarHeight = i;
    }

    public void destroy() {
        this.bbQ = false;
        fcb = null;
    }
}
