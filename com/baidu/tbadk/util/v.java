package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class v {
    private View cOu;
    private int cOv;
    private boolean cOw;
    private final Handler mHandler;

    public void axI() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void axJ() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void axK() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void fD(boolean z) {
        if (this.cOu != null) {
            if (z || this.cOu.getVisibility() != 8) {
                axJ();
            }
        }
    }

    public void fE(boolean z) {
        if (this.cOu != null) {
            if (z || this.cOu.getVisibility() != 0) {
                axI();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.cOu != null) {
            if (i != 0 && i2 > i && this.cOu.getVisibility() != 8) {
                fD(false);
            } else if ((i == 0 || i2 < i) && this.cOu.getVisibility() != 0) {
                fE(false);
            }
            this.cOv = i;
        }
    }

    public void g(ViewGroup viewGroup, int i) {
        int firstVisiblePosition;
        if (viewGroup != null && i == 0) {
            if (viewGroup instanceof BdRecyclerView) {
                firstVisiblePosition = ((BdRecyclerView) viewGroup).getFirstVisiblePosition();
            } else if (viewGroup instanceof AbsListView) {
                firstVisiblePosition = ((AbsListView) viewGroup).getFirstVisiblePosition();
            } else {
                return;
            }
            if (firstVisiblePosition > this.cOv) {
                fD(true);
            } else if (firstVisiblePosition < this.cOv) {
                fE(true);
            } else if (firstVisiblePosition == this.cOv) {
                if (firstVisiblePosition == 0 || !this.cOw) {
                    fE(true);
                } else {
                    fD(true);
                }
            }
        }
    }
}
