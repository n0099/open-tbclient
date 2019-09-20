package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class v {
    private View cEf;
    private int cEg;
    private boolean cEh;
    private final Handler mHandler;

    public void awH() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void awI() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void awJ() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void fO(boolean z) {
        if (this.cEf != null) {
            if (z || this.cEf.getVisibility() != 8) {
                awI();
            }
        }
    }

    public void fP(boolean z) {
        if (this.cEf != null) {
            if (z || this.cEf.getVisibility() != 0) {
                awH();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.cEf != null) {
            if (i != 0 && i2 > i && this.cEf.getVisibility() != 8) {
                fO(false);
            } else if ((i == 0 || i2 < i) && this.cEf.getVisibility() != 0) {
                fP(false);
            }
            this.cEg = i;
        }
    }

    public void i(ViewGroup viewGroup, int i) {
        int firstVisiblePosition;
        if (viewGroup != null && i == 0) {
            if (viewGroup instanceof BdRecyclerView) {
                firstVisiblePosition = ((BdRecyclerView) viewGroup).getFirstVisiblePosition();
            } else if (viewGroup instanceof AbsListView) {
                firstVisiblePosition = ((AbsListView) viewGroup).getFirstVisiblePosition();
            } else {
                return;
            }
            if (firstVisiblePosition > this.cEg) {
                fO(true);
            } else if (firstVisiblePosition < this.cEg) {
                fP(true);
            } else if (firstVisiblePosition == this.cEg) {
                if (firstVisiblePosition == 0 || !this.cEh) {
                    fP(true);
                } else {
                    fO(true);
                }
            }
        }
    }
}
