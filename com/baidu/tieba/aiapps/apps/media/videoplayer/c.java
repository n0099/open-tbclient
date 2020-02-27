package com.baidu.tieba.aiapps.apps.media.videoplayer;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes12.dex */
public class c {
    public static boolean bs(View view) {
        if (view != null && view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup.indexOfChild(view) != -1) {
                try {
                    viewGroup.removeView(view);
                } catch (Exception e) {
                }
                return true;
            }
        }
        return false;
    }

    public static boolean e(Activity activity, View view) {
        ViewGroup viewGroup;
        if (activity == null || view == null || (viewGroup = (ViewGroup) activity.getWindow().getDecorView()) == null) {
            return false;
        }
        bs(view);
        viewGroup.removeView(view);
        viewGroup.addView(view);
        return true;
    }
}
