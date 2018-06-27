package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class s {
    private int aWA;
    private boolean aWB;
    private View aWz;
    private final Handler mHandler;

    public void Lw() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Lx() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Ly() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void cf(boolean z) {
        if (this.aWz != null) {
            if (z || this.aWz.getVisibility() != 8) {
                Lx();
            }
        }
    }

    public void cg(boolean z) {
        if (this.aWz != null) {
            if (z || this.aWz.getVisibility() != 0) {
                Lw();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.aWz != null) {
            if (i != 0 && i2 > i && this.aWz.getVisibility() != 8) {
                cf(false);
            } else if ((i == 0 || i2 < i) && this.aWz.getVisibility() != 0) {
                cg(false);
            }
            this.aWA = i;
        }
    }

    public void h(ViewGroup viewGroup, int i) {
        int firstVisiblePosition;
        if (viewGroup != null && i == 0) {
            if (viewGroup instanceof BdRecyclerView) {
                firstVisiblePosition = ((BdRecyclerView) viewGroup).getFirstVisiblePosition();
            } else if (viewGroup instanceof AbsListView) {
                firstVisiblePosition = ((AbsListView) viewGroup).getFirstVisiblePosition();
            } else {
                return;
            }
            if (firstVisiblePosition > this.aWA) {
                cf(true);
            } else if (firstVisiblePosition < this.aWA) {
                cg(true);
            } else if (firstVisiblePosition == this.aWA) {
                if (firstVisiblePosition == 0 || !this.aWB) {
                    cg(true);
                } else {
                    cf(true);
                }
            }
        }
    }
}
