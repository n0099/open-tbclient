package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class z {
    private View bau;
    private int fNi;
    private boolean fNj;
    private final Handler mHandler;

    public void bFD() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bFE() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void ld(boolean z) {
        if (this.bau != null) {
            if (z || this.bau.getVisibility() != 8) {
                bFE();
            }
        }
    }

    public void lc(boolean z) {
        if (this.bau != null) {
            if (z || this.bau.getVisibility() != 0) {
                bFD();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.bau != null) {
            if (i != 0 && i2 > i && this.bau.getVisibility() != 8) {
                ld(false);
            } else if ((i == 0 || i2 < i) && this.bau.getVisibility() != 0) {
                lc(false);
            }
            this.fNi = i;
        }
    }

    public void q(ViewGroup viewGroup, int i) {
        int firstVisiblePosition;
        if (viewGroup != null && i == 0) {
            if (viewGroup instanceof BdRecyclerView) {
                firstVisiblePosition = ((BdRecyclerView) viewGroup).getFirstVisiblePosition();
            } else if (viewGroup instanceof AbsListView) {
                firstVisiblePosition = ((AbsListView) viewGroup).getFirstVisiblePosition();
            } else {
                return;
            }
            if (firstVisiblePosition > this.fNi) {
                ld(true);
            } else if (firstVisiblePosition < this.fNi) {
                lc(true);
            } else if (firstVisiblePosition == this.fNi) {
                if (firstVisiblePosition == 0 || !this.fNj) {
                    lc(true);
                } else {
                    ld(true);
                }
            }
        }
    }
}
