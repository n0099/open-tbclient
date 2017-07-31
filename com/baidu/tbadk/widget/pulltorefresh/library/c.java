package com.baidu.tbadk.widget.pulltorefresh.library;

import android.annotation.TargetApi;
import android.view.View;
import com.baidu.tbadk.widget.pulltorefresh.library.PullToRefreshBase;
@TargetApi(9)
/* loaded from: classes.dex */
public final class c {
    public static void a(PullToRefreshBase<?> pullToRefreshBase, int i, int i2, int i3, int i4, int i5, boolean z) {
        a(pullToRefreshBase, i, i2, i3, i4, i5, 0, 1.0f, z);
    }

    public static void a(PullToRefreshBase<?> pullToRefreshBase, int i, int i2, int i3, int i4, int i5, int i6, float f, boolean z) {
        int scrollX;
        switch (pullToRefreshBase.getPullToRefreshScrollDirection()) {
            case HORIZONTAL:
                scrollX = pullToRefreshBase.getScrollX();
                break;
            default:
                scrollX = pullToRefreshBase.getScrollY();
                i2 = i4;
                i = i3;
                break;
        }
        if (pullToRefreshBase.isPullToRefreshOverScrollEnabled() && !pullToRefreshBase.isRefreshing()) {
            PullToRefreshBase.Mode mode = pullToRefreshBase.getMode();
            if (mode.permitsPullToRefresh() && !z && i != 0) {
                int i7 = i + i2;
                if (i7 < 0 - i6) {
                    if (mode.showHeaderLoadingLayout()) {
                        if (scrollX == 0) {
                            pullToRefreshBase.a(PullToRefreshBase.State.OVERSCROLLING, new boolean[0]);
                        }
                        pullToRefreshBase.setHeaderScroll((int) ((scrollX + i7) * f));
                    }
                } else if (i7 > i5 + i6) {
                    if (mode.showFooterLoadingLayout()) {
                        if (scrollX == 0) {
                            pullToRefreshBase.a(PullToRefreshBase.State.OVERSCROLLING, new boolean[0]);
                        }
                        pullToRefreshBase.setHeaderScroll((int) (((scrollX + i7) - i5) * f));
                    }
                } else if (Math.abs(i7) <= i6 || Math.abs(i7 - i5) <= i6) {
                    pullToRefreshBase.a(PullToRefreshBase.State.RESET, new boolean[0]);
                }
            } else if (z && PullToRefreshBase.State.OVERSCROLLING == pullToRefreshBase.getState()) {
                pullToRefreshBase.a(PullToRefreshBase.State.RESET, new boolean[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean L(View view) {
        return view.getOverScrollMode() != 2;
    }
}
