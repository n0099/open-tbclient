package com.baidu.tbadk.editortools.noConflictPanel.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class d {
    public static boolean o(View view, int i) {
        if (view.isInEditMode() || view.getHeight() == i || Math.abs(view.getHeight() - i) == c.getStatusBarHeight(view.getContext())) {
            return false;
        }
        int eQ = b.eQ(view.getContext());
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, eQ));
        } else {
            layoutParams.height = eQ;
            view.requestLayout();
        }
        return true;
    }

    public static boolean af(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) != 0;
    }

    @TargetApi(19)
    public static boolean B(Activity activity) {
        return Build.VERSION.SDK_INT >= 19 && (activity.getWindow().getAttributes().flags & 67108864) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(16)
    public static boolean ag(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            return ((ViewGroup) activity.findViewById(16908290)).getChildAt(0).getFitsSystemWindows();
        }
        return false;
    }
}
