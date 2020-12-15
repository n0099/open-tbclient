package com.baidu.tieba.homepage.personalize;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
/* loaded from: classes22.dex */
public class c {
    private static int jRi = 0;
    private static int jRj = 0;

    public static boolean au(Activity activity) {
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

    public static void i(BdTypeRecyclerView bdTypeRecyclerView) {
        if (bdTypeRecyclerView != null) {
            int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
            View childAt = bdTypeRecyclerView.getChildAt(0);
            int top = childAt != null ? childAt.getTop() : 0;
            jRi = firstVisiblePosition;
            jRj = top;
        }
    }

    public static void j(BdTypeRecyclerView bdTypeRecyclerView) {
        if (bdTypeRecyclerView != null && (bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager) && jRi <= bdTypeRecyclerView.getCount() - 1) {
            bdTypeRecyclerView.requestFocusFromTouch();
            ((LinearLayoutManager) bdTypeRecyclerView.getLayoutManager()).scrollToPositionWithOffset(jRi, jRj);
            jRi = 0;
            jRj = 0;
        }
    }
}
