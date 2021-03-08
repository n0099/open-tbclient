package com.baidu.tieba.enterForum.model;

import android.content.Context;
import android.view.WindowManager;
/* loaded from: classes2.dex */
public class a {
    private static a iNo;
    private boolean mHasInited;
    private int mStatusBarHeight;
    private WindowManager mWindowManager;

    public static a cwL() {
        if (iNo == null) {
            synchronized (a.class) {
                if (iNo == null) {
                    iNo = new a();
                }
            }
        }
        return iNo;
    }

    private a() {
    }

    public void w(Context context, int i) {
        this.mHasInited = true;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        this.mWindowManager = (WindowManager) context.getSystemService("window");
        this.mStatusBarHeight = i;
    }

    public void destroy() {
        this.mHasInited = false;
        iNo = null;
    }
}
