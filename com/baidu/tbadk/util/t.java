package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class t {
    private View biI;
    private int biJ;
    private boolean biK;
    private final Handler mHandler;

    public void Qa() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Qb() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Qc() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void cR(boolean z) {
        if (this.biI != null) {
            if (z || this.biI.getVisibility() != 8) {
                Qb();
            }
        }
    }

    public void cS(boolean z) {
        if (this.biI != null) {
            if (z || this.biI.getVisibility() != 0) {
                Qa();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.biI != null) {
            if (i != 0 && i2 > i && this.biI.getVisibility() != 8) {
                cR(false);
            } else if ((i == 0 || i2 < i) && this.biI.getVisibility() != 0) {
                cS(false);
            }
            this.biJ = i;
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
            if (firstVisiblePosition > this.biJ) {
                cR(true);
            } else if (firstVisiblePosition < this.biJ) {
                cS(true);
            } else if (firstVisiblePosition == this.biJ) {
                if (firstVisiblePosition == 0 || !this.biK) {
                    cS(true);
                } else {
                    cR(true);
                }
            }
        }
    }
}
