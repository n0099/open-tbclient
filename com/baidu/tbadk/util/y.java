package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class y {
    private View dCw;
    private int dCx;
    private boolean dCy;
    private final Handler mHandler;

    public void aPA() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aPB() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void gQ(boolean z) {
        if (this.dCw != null) {
            if (z || this.dCw.getVisibility() != 8) {
                aPB();
            }
        }
    }

    public void gR(boolean z) {
        if (this.dCw != null) {
            if (z || this.dCw.getVisibility() != 0) {
                aPA();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.dCw != null) {
            if (i != 0 && i2 > i && this.dCw.getVisibility() != 8) {
                gQ(false);
            } else if ((i == 0 || i2 < i) && this.dCw.getVisibility() != 0) {
                gR(false);
            }
            this.dCx = i;
        }
    }

    public void l(ViewGroup viewGroup, int i) {
        int firstVisiblePosition;
        if (viewGroup != null && i == 0) {
            if (viewGroup instanceof BdRecyclerView) {
                firstVisiblePosition = ((BdRecyclerView) viewGroup).getFirstVisiblePosition();
            } else if (viewGroup instanceof AbsListView) {
                firstVisiblePosition = ((AbsListView) viewGroup).getFirstVisiblePosition();
            } else {
                return;
            }
            if (firstVisiblePosition > this.dCx) {
                gQ(true);
            } else if (firstVisiblePosition < this.dCx) {
                gR(true);
            } else if (firstVisiblePosition == this.dCx) {
                if (firstVisiblePosition == 0 || !this.dCy) {
                    gR(true);
                } else {
                    gQ(true);
                }
            }
        }
    }
}
