package com.baidu.tieba.enterForum.model;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes4.dex */
public class a {
    private static a fcS;
    private boolean bci;
    private int mStatusBarHeight;
    private WindowManager mWindowManager;

    public static a beJ() {
        if (fcS == null) {
            synchronized (a.class) {
                if (fcS == null) {
                    fcS = new a();
                }
            }
        }
        return fcS;
    }

    private a() {
    }

    public void k(Context context, int i) {
        this.bci = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.mStatusBarHeight = i;
    }

    public void destroy() {
        this.bci = false;
        fcS = null;
    }
}
