package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class y {
    private View bau;
    private int fGa;
    private boolean fGb;
    private final Handler mHandler;

    public void bGI() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bGJ() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void kI(boolean z) {
        if (this.bau != null) {
            if (z || this.bau.getVisibility() != 8) {
                bGJ();
            }
        }
    }

    public void kH(boolean z) {
        if (this.bau != null) {
            if (z || this.bau.getVisibility() != 0) {
                bGI();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.bau != null) {
            if (i != 0 && i2 > i && this.bau.getVisibility() != 8) {
                kI(false);
            } else if ((i == 0 || i2 < i) && this.bau.getVisibility() != 0) {
                kH(false);
            }
            this.fGa = i;
        }
    }

    public void m(ViewGroup viewGroup, int i) {
        int firstVisiblePosition;
        if (viewGroup != null && i == 0) {
            if (viewGroup instanceof BdRecyclerView) {
                firstVisiblePosition = ((BdRecyclerView) viewGroup).getFirstVisiblePosition();
            } else if (viewGroup instanceof AbsListView) {
                firstVisiblePosition = ((AbsListView) viewGroup).getFirstVisiblePosition();
            } else {
                return;
            }
            if (firstVisiblePosition > this.fGa) {
                kI(true);
            } else if (firstVisiblePosition < this.fGa) {
                kH(true);
            } else if (firstVisiblePosition == this.fGa) {
                if (firstVisiblePosition == 0 || !this.fGb) {
                    kH(true);
                } else {
                    kI(true);
                }
            }
        }
    }
}
