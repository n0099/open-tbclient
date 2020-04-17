package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class y {
    private View aBW;
    private int egW;
    private boolean egX;
    private final Handler mHandler;

    public void baA() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void baB() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void ib(boolean z) {
        if (this.aBW != null) {
            if (z || this.aBW.getVisibility() != 8) {
                baB();
            }
        }
    }

    public void ic(boolean z) {
        if (this.aBW != null) {
            if (z || this.aBW.getVisibility() != 0) {
                baA();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.aBW != null) {
            if (i != 0 && i2 > i && this.aBW.getVisibility() != 8) {
                ib(false);
            } else if ((i == 0 || i2 < i) && this.aBW.getVisibility() != 0) {
                ic(false);
            }
            this.egW = i;
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
            if (firstVisiblePosition > this.egW) {
                ib(true);
            } else if (firstVisiblePosition < this.egW) {
                ic(true);
            } else if (firstVisiblePosition == this.egW) {
                if (firstVisiblePosition == 0 || !this.egX) {
                    ic(true);
                } else {
                    ib(true);
                }
            }
        }
    }
}
