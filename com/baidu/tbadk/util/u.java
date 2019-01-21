package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class u {
    private int bjA;
    private boolean bjB;
    private View bjz;
    private final Handler mHandler;

    public void Qx() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Qy() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Qz() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void cU(boolean z) {
        if (this.bjz != null) {
            if (z || this.bjz.getVisibility() != 8) {
                Qy();
            }
        }
    }

    public void cV(boolean z) {
        if (this.bjz != null) {
            if (z || this.bjz.getVisibility() != 0) {
                Qx();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.bjz != null) {
            if (i != 0 && i2 > i && this.bjz.getVisibility() != 8) {
                cU(false);
            } else if ((i == 0 || i2 < i) && this.bjz.getVisibility() != 0) {
                cV(false);
            }
            this.bjA = i;
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
            if (firstVisiblePosition > this.bjA) {
                cU(true);
            } else if (firstVisiblePosition < this.bjA) {
                cV(true);
            } else if (firstVisiblePosition == this.bjA) {
                if (firstVisiblePosition == 0 || !this.bjB) {
                    cV(true);
                } else {
                    cU(true);
                }
            }
        }
    }
}
