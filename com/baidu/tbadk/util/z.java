package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes2.dex */
public class z {
    private View aQM;
    private int eVA;
    private boolean eVB;
    private final Handler mHandler;

    public void bvE() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bvF() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void hideFloatingView(boolean z) {
        if (this.aQM != null) {
            if (z || this.aQM.getVisibility() != 8) {
                bvF();
            }
        }
    }

    public void showFloatingView(boolean z) {
        if (this.aQM != null) {
            if (z || this.aQM.getVisibility() != 0) {
                bvE();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.aQM != null) {
            if (i != 0 && i2 > i && this.aQM.getVisibility() != 8) {
                hideFloatingView(false);
            } else if ((i == 0 || i2 < i) && this.aQM.getVisibility() != 0) {
                showFloatingView(false);
            }
            this.eVA = i;
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
            if (firstVisiblePosition > this.eVA) {
                hideFloatingView(true);
            } else if (firstVisiblePosition < this.eVA) {
                showFloatingView(true);
            } else if (firstVisiblePosition == this.eVA) {
                if (firstVisiblePosition == 0 || !this.eVB) {
                    showFloatingView(true);
                } else {
                    hideFloatingView(true);
                }
            }
        }
    }
}
