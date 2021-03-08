package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class z {
    private View bbU;
    private int fOI;
    private boolean fOJ;
    private final Handler mHandler;

    public void bFH() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bFI() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void ld(boolean z) {
        if (this.bbU != null) {
            if (z || this.bbU.getVisibility() != 8) {
                bFI();
            }
        }
    }

    public void lc(boolean z) {
        if (this.bbU != null) {
            if (z || this.bbU.getVisibility() != 0) {
                bFH();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.bbU != null) {
            if (i != 0 && i2 > i && this.bbU.getVisibility() != 8) {
                ld(false);
            } else if ((i == 0 || i2 < i) && this.bbU.getVisibility() != 0) {
                lc(false);
            }
            this.fOI = i;
        }
    }

    public void q(ViewGroup viewGroup, int i) {
        int firstVisiblePosition;
        if (viewGroup != null && i == 0) {
            if (viewGroup instanceof BdRecyclerView) {
                firstVisiblePosition = ((BdRecyclerView) viewGroup).getFirstVisiblePosition();
            } else if (viewGroup instanceof AbsListView) {
                firstVisiblePosition = ((AbsListView) viewGroup).getFirstVisiblePosition();
            } else {
                return;
            }
            if (firstVisiblePosition > this.fOI) {
                ld(true);
            } else if (firstVisiblePosition < this.fOI) {
                lc(true);
            } else if (firstVisiblePosition == this.fOI) {
                if (firstVisiblePosition == 0 || !this.fOJ) {
                    lc(true);
                } else {
                    ld(true);
                }
            }
        }
    }
}
