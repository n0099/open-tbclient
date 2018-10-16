package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class t {
    private View bev;
    private int bew;
    private boolean bex;
    private final Handler mHandler;

    public void OL() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void OM() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void ON() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void cz(boolean z) {
        if (this.bev != null) {
            if (z || this.bev.getVisibility() != 8) {
                OM();
            }
        }
    }

    public void cA(boolean z) {
        if (this.bev != null) {
            if (z || this.bev.getVisibility() != 0) {
                OL();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.bev != null) {
            if (i != 0 && i2 > i && this.bev.getVisibility() != 8) {
                cz(false);
            } else if ((i == 0 || i2 < i) && this.bev.getVisibility() != 0) {
                cA(false);
            }
            this.bew = i;
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
            if (firstVisiblePosition > this.bew) {
                cz(true);
            } else if (firstVisiblePosition < this.bew) {
                cA(true);
            } else if (firstVisiblePosition == this.bew) {
                if (firstVisiblePosition == 0 || !this.bex) {
                    cA(true);
                } else {
                    cz(true);
                }
            }
        }
    }
}
