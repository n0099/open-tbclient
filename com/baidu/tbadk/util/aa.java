package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class aa {
    private View aSR;
    private int eYv;
    private boolean eYw;
    private final Handler mHandler;

    public void bwO() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bwP() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void hideFloatingView(boolean z) {
        if (this.aSR != null) {
            if (z || this.aSR.getVisibility() != 8) {
                bwP();
            }
        }
    }

    public void showFloatingView(boolean z) {
        if (this.aSR != null) {
            if (z || this.aSR.getVisibility() != 0) {
                bwO();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.aSR != null) {
            if (i != 0 && i2 > i && this.aSR.getVisibility() != 8) {
                hideFloatingView(false);
            } else if ((i == 0 || i2 < i) && this.aSR.getVisibility() != 0) {
                showFloatingView(false);
            }
            this.eYv = i;
        }
    }

    public void k(ViewGroup viewGroup, int i) {
        int firstVisiblePosition;
        if (viewGroup != null && i == 0) {
            if (viewGroup instanceof BdRecyclerView) {
                firstVisiblePosition = ((BdRecyclerView) viewGroup).getFirstVisiblePosition();
            } else if (viewGroup instanceof AbsListView) {
                firstVisiblePosition = ((AbsListView) viewGroup).getFirstVisiblePosition();
            } else {
                return;
            }
            if (firstVisiblePosition > this.eYv) {
                hideFloatingView(true);
            } else if (firstVisiblePosition < this.eYv) {
                showFloatingView(true);
            } else if (firstVisiblePosition == this.eYv) {
                if (firstVisiblePosition == 0 || !this.eYw) {
                    showFloatingView(true);
                } else {
                    hideFloatingView(true);
                }
            }
        }
    }
}
