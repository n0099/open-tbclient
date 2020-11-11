package com.baidu.tbadk.editortools.noConflictPanel.b;

import android.content.Context;
import android.util.Log;
/* loaded from: classes.dex */
public class c {
    private static boolean init = false;
    private static int cua = 50;

    public static synchronized int getStatusBarHeight(Context context) {
        int i;
        int identifier;
        synchronized (c.class) {
            if (!init && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) > 0) {
                cua = context.getResources().getDimensionPixelSize(identifier);
                init = true;
                Log.d("StatusBarHeightUtil", String.format("Get status bar height %d", Integer.valueOf(cua)));
            }
            i = cua;
        }
        return i;
    }
}
