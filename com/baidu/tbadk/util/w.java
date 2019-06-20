package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class w {
    private View cBQ;
    private int cBR;
    private boolean cBS;
    private final Handler mHandler;

    public void avk() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void avl() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void avm() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void fH(boolean z) {
        if (this.cBQ != null) {
            if (z || this.cBQ.getVisibility() != 8) {
                avl();
            }
        }
    }

    public void fI(boolean z) {
        if (this.cBQ != null) {
            if (z || this.cBQ.getVisibility() != 0) {
                avk();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.cBQ != null) {
            if (i != 0 && i2 > i && this.cBQ.getVisibility() != 8) {
                fH(false);
            } else if ((i == 0 || i2 < i) && this.cBQ.getVisibility() != 0) {
                fI(false);
            }
            this.cBR = i;
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
            if (firstVisiblePosition > this.cBR) {
                fH(true);
            } else if (firstVisiblePosition < this.cBR) {
                fI(true);
            } else if (firstVisiblePosition == this.cBR) {
                if (firstVisiblePosition == 0 || !this.cBS) {
                    fI(true);
                } else {
                    fH(true);
                }
            }
        }
    }
}
