package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class r {
    private View aWB;
    private int aWC;
    private boolean aWD;
    private final Handler mHandler;

    public void Lv() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Lw() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Lx() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void ce(boolean z) {
        if (this.aWB != null) {
            if (z || this.aWB.getVisibility() != 8) {
                Lw();
            }
        }
    }

    public void cf(boolean z) {
        if (this.aWB != null) {
            if (z || this.aWB.getVisibility() != 0) {
                Lv();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.aWB != null) {
            if (i != 0 && i2 > i && this.aWB.getVisibility() != 8) {
                ce(false);
            } else if ((i == 0 || i2 < i) && this.aWB.getVisibility() != 0) {
                cf(false);
            }
            this.aWC = i;
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
            if (firstVisiblePosition > this.aWC) {
                ce(true);
            } else if (firstVisiblePosition < this.aWC) {
                cf(true);
            } else if (firstVisiblePosition == this.aWC) {
                if (firstVisiblePosition == 0 || !this.aWD) {
                    cf(true);
                } else {
                    ce(true);
                }
            }
        }
    }
}
