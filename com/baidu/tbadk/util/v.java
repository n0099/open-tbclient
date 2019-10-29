package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class v {
    private View cPl;
    private int cPm;
    private boolean cPn;
    private final Handler mHandler;

    public void axK() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void axL() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void axM() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void fD(boolean z) {
        if (this.cPl != null) {
            if (z || this.cPl.getVisibility() != 8) {
                axL();
            }
        }
    }

    public void fE(boolean z) {
        if (this.cPl != null) {
            if (z || this.cPl.getVisibility() != 0) {
                axK();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.cPl != null) {
            if (i != 0 && i2 > i && this.cPl.getVisibility() != 8) {
                fD(false);
            } else if ((i == 0 || i2 < i) && this.cPl.getVisibility() != 0) {
                fE(false);
            }
            this.cPm = i;
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
            if (firstVisiblePosition > this.cPm) {
                fD(true);
            } else if (firstVisiblePosition < this.cPm) {
                fE(true);
            } else if (firstVisiblePosition == this.cPm) {
                if (firstVisiblePosition == 0 || !this.cPn) {
                    fE(true);
                } else {
                    fD(true);
                }
            }
        }
    }
}
