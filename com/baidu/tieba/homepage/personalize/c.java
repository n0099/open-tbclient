package com.baidu.tieba.homepage.personalize;

import android.app.Activity;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
/* loaded from: classes2.dex */
public class c {
    private static int kij = 0;
    private static int kik = 0;

    public static boolean aq(Activity activity) {
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
            kij = firstVisiblePosition;
            kik = top;
        }
    }

    public static void j(BdTypeRecyclerView bdTypeRecyclerView) {
        if (bdTypeRecyclerView != null && (bdTypeRecyclerView.getLayoutManager() instanceof LinearLayoutManager) && kij <= bdTypeRecyclerView.getCount() - 1) {
            bdTypeRecyclerView.requestFocusFromTouch();
            ((LinearLayoutManager) bdTypeRecyclerView.getLayoutManager()).scrollToPositionWithOffset(kij, kik);
            kij = 0;
            kik = 0;
        }
    }
}
