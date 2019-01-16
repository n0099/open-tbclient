package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class u {
    private boolean bjA;
    private View bjy;
    private int bjz;
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
        if (this.bjy != null) {
            if (z || this.bjy.getVisibility() != 8) {
                Qy();
            }
        }
    }

    public void cV(boolean z) {
        if (this.bjy != null) {
            if (z || this.bjy.getVisibility() != 0) {
                Qx();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.bjy != null) {
            if (i != 0 && i2 > i && this.bjy.getVisibility() != 8) {
                cU(false);
            } else if ((i == 0 || i2 < i) && this.bjy.getVisibility() != 0) {
                cV(false);
            }
            this.bjz = i;
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
            if (firstVisiblePosition > this.bjz) {
                cU(true);
            } else if (firstVisiblePosition < this.bjz) {
                cV(true);
            } else if (firstVisiblePosition == this.bjz) {
                if (firstVisiblePosition == 0 || !this.bjA) {
                    cV(true);
                } else {
                    cU(true);
                }
            }
        }
    }
}
