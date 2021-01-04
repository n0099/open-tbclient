package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class x {
    private View bcb;
    private int fPD;
    private boolean fPE;
    private final Handler mHandler;

    public void bJb() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bJc() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void le(boolean z) {
        if (this.bcb != null) {
            if (z || this.bcb.getVisibility() != 8) {
                bJc();
            }
        }
    }

    public void ld(boolean z) {
        if (this.bcb != null) {
            if (z || this.bcb.getVisibility() != 0) {
                bJb();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.bcb != null) {
            if (i != 0 && i2 > i && this.bcb.getVisibility() != 8) {
                le(false);
            } else if ((i == 0 || i2 < i) && this.bcb.getVisibility() != 0) {
                ld(false);
            }
            this.fPD = i;
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
            if (firstVisiblePosition > this.fPD) {
                le(true);
            } else if (firstVisiblePosition < this.fPD) {
                ld(true);
            } else if (firstVisiblePosition == this.fPD) {
                if (firstVisiblePosition == 0 || !this.fPE) {
                    ld(true);
                } else {
                    le(true);
                }
            }
        }
    }
}
