package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class t {
    private View aZT;
    private int aZU;
    private boolean aZV;
    private final Handler mHandler;

    public void MN() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void MO() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void MP() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void cq(boolean z) {
        if (this.aZT != null) {
            if (z || this.aZT.getVisibility() != 8) {
                MO();
            }
        }
    }

    public void cr(boolean z) {
        if (this.aZT != null) {
            if (z || this.aZT.getVisibility() != 0) {
                MN();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.aZT != null) {
            if (i != 0 && i2 > i && this.aZT.getVisibility() != 8) {
                cq(false);
            } else if ((i == 0 || i2 < i) && this.aZT.getVisibility() != 0) {
                cr(false);
            }
            this.aZU = i;
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
            if (firstVisiblePosition > this.aZU) {
                cq(true);
            } else if (firstVisiblePosition < this.aZU) {
                cr(true);
            } else if (firstVisiblePosition == this.aZU) {
                if (firstVisiblePosition == 0 || !this.aZV) {
                    cr(true);
                } else {
                    cq(true);
                }
            }
        }
    }
}
