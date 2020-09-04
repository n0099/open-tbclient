package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class z {
    private View aQO;
    private int eVE;
    private boolean eVF;
    private final Handler mHandler;

    public void bvF() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bvG() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void hideFloatingView(boolean z) {
        if (this.aQO != null) {
            if (z || this.aQO.getVisibility() != 8) {
                bvG();
            }
        }
    }

    public void showFloatingView(boolean z) {
        if (this.aQO != null) {
            if (z || this.aQO.getVisibility() != 0) {
                bvF();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.aQO != null) {
            if (i != 0 && i2 > i && this.aQO.getVisibility() != 8) {
                hideFloatingView(false);
            } else if ((i == 0 || i2 < i) && this.aQO.getVisibility() != 0) {
                showFloatingView(false);
            }
            this.eVE = i;
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
            if (firstVisiblePosition > this.eVE) {
                hideFloatingView(true);
            } else if (firstVisiblePosition < this.eVE) {
                showFloatingView(true);
            } else if (firstVisiblePosition == this.eVE) {
                if (firstVisiblePosition == 0 || !this.eVF) {
                    showFloatingView(true);
                } else {
                    hideFloatingView(true);
                }
            }
        }
    }
}
