package com.baidu.tbadk.editortools.noConflictPanel.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public class d {
    public static boolean r(View view, int i) {
        if (view.isInEditMode() || view.getHeight() == i || Math.abs(view.getHeight() - i) == c.getStatusBarHeight(view.getContext())) {
            return false;
        }
        int fj = b.fj(view.getContext());
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, fj));
        } else {
            layoutParams.height = fj;
            view.requestLayout();
        }
        return true;
    }

    public static boolean ab(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) != 0;
    }

    @TargetApi(19)
    public static boolean u(Activity activity) {
        return Build.VERSION.SDK_INT >= 19 && (activity.getWindow().getAttributes().flags & 67108864) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(16)
    public static boolean ac(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            return ((ViewGroup) activity.findViewById(16908290)).getChildAt(0).getFitsSystemWindows();
        }
        return false;
    }
}
