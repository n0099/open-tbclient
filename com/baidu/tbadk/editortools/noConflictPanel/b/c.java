package com.baidu.tbadk.editortools.noConflictPanel.b;

import android.content.Context;
import android.util.Log;
import com.baidu.ar.constants.HttpConstants;
/* loaded from: classes.dex */
public class c {
    private static boolean init = false;
    private static int cDn = 50;

    public static synchronized int getStatusBarHeight(Context context) {
        int i;
        int identifier;
        synchronized (c.class) {
            if (!init && (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", HttpConstants.OS_TYPE_VALUE)) > 0) {
                cDn = context.getResources().getDimensionPixelSize(identifier);
                init = true;
                Log.d("StatusBarHeightUtil", String.format("Get status bar height %d", Integer.valueOf(cDn)));
            }
            i = cDn;
        }
        return i;
    }
}
