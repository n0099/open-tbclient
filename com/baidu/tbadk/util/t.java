package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class t {
    private View bfi;
    private int bfj;
    private boolean bfk;
    private final Handler mHandler;

    public void OU() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void OV() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void OW() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void cQ(boolean z) {
        if (this.bfi != null) {
            if (z || this.bfi.getVisibility() != 8) {
                OV();
            }
        }
    }

    public void cR(boolean z) {
        if (this.bfi != null) {
            if (z || this.bfi.getVisibility() != 0) {
                OU();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.bfi != null) {
            if (i != 0 && i2 > i && this.bfi.getVisibility() != 8) {
                cQ(false);
            } else if ((i == 0 || i2 < i) && this.bfi.getVisibility() != 0) {
                cR(false);
            }
            this.bfj = i;
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
            if (firstVisiblePosition > this.bfj) {
                cQ(true);
            } else if (firstVisiblePosition < this.bfj) {
                cR(true);
            } else if (firstVisiblePosition == this.bfj) {
                if (firstVisiblePosition == 0 || !this.bfk) {
                    cR(true);
                } else {
                    cQ(true);
                }
            }
        }
    }
}
