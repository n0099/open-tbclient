package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class w {
    private View cDo;
    private int cDp;
    private boolean cDq;
    private final Handler mHandler;

    public void awv() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aww() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void awx() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void fL(boolean z) {
        if (this.cDo != null) {
            if (z || this.cDo.getVisibility() != 8) {
                aww();
            }
        }
    }

    public void fM(boolean z) {
        if (this.cDo != null) {
            if (z || this.cDo.getVisibility() != 0) {
                awv();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.cDo != null) {
            if (i != 0 && i2 > i && this.cDo.getVisibility() != 8) {
                fL(false);
            } else if ((i == 0 || i2 < i) && this.cDo.getVisibility() != 0) {
                fM(false);
            }
            this.cDp = i;
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
            if (firstVisiblePosition > this.cDp) {
                fL(true);
            } else if (firstVisiblePosition < this.cDp) {
                fM(true);
            } else if (firstVisiblePosition == this.cDp) {
                if (firstVisiblePosition == 0 || !this.cDq) {
                    fM(true);
                } else {
                    fL(true);
                }
            }
        }
    }
}
