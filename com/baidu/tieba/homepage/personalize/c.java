package com.baidu.tieba.homepage.personalize;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
/* loaded from: classes9.dex */
public class c {
    private static int hck = 0;
    private static int hcl = 0;

    public static boolean ar(Activity activity) {
        if (activity != null) {
            try {
                if (activity.isInMultiWindowMode()) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        return false;
    }

    public static void d(BdTypeRecyclerView bdTypeRecyclerView) {
        if (bdTypeRecyclerView != null) {
            int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
            View childAt = bdTypeRecyclerView.getChildAt(0);
            int top2 = childAt != null ? childAt.getTop() : 0;
            hck = firstVisiblePosition;
            hcl = top2;
        }
    }

    public static void e(BdTypeRecyclerView bdTypeRecyclerView) {
        if (bdTypeRecyclerView != null && (bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager) && hck <= bdTypeRecyclerView.getCount() - 1) {
            bdTypeRecyclerView.requestFocusFromTouch();
            ((LinearLayoutManager) bdTypeRecyclerView.getLayoutManager()).scrollToPositionWithOffset(hck, hcl);
            hck = 0;
            hcl = 0;
        }
    }
}
