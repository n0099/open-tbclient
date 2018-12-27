package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class t {
    private View biL;
    private int biM;
    private boolean biN;
    private final Handler mHandler;

    public void Qc() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Qd() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Qe() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void cR(boolean z) {
        if (this.biL != null) {
            if (z || this.biL.getVisibility() != 8) {
                Qd();
            }
        }
    }

    public void cS(boolean z) {
        if (this.biL != null) {
            if (z || this.biL.getVisibility() != 0) {
                Qc();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.biL != null) {
            if (i != 0 && i2 > i && this.biL.getVisibility() != 8) {
                cR(false);
            } else if ((i == 0 || i2 < i) && this.biL.getVisibility() != 0) {
                cS(false);
            }
            this.biM = i;
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
            if (firstVisiblePosition > this.biM) {
                cR(true);
            } else if (firstVisiblePosition < this.biM) {
                cS(true);
            } else if (firstVisiblePosition == this.biM) {
                if (firstVisiblePosition == 0 || !this.biN) {
                    cS(true);
                } else {
                    cR(true);
                }
            }
        }
    }
}
