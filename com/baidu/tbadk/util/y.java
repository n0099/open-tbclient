package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class y {
    private View dCG;
    private int dCH;
    private boolean dCI;
    private final Handler mHandler;

    public void aPT() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aPU() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void gV(boolean z) {
        if (this.dCG != null) {
            if (z || this.dCG.getVisibility() != 8) {
                aPU();
            }
        }
    }

    public void gW(boolean z) {
        if (this.dCG != null) {
            if (z || this.dCG.getVisibility() != 0) {
                aPT();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.dCG != null) {
            if (i != 0 && i2 > i && this.dCG.getVisibility() != 8) {
                gV(false);
            } else if ((i == 0 || i2 < i) && this.dCG.getVisibility() != 0) {
                gW(false);
            }
            this.dCH = i;
        }
    }

    public void l(ViewGroup viewGroup, int i) {
        int firstVisiblePosition;
        if (viewGroup != null && i == 0) {
            if (viewGroup instanceof BdRecyclerView) {
                firstVisiblePosition = ((BdRecyclerView) viewGroup).getFirstVisiblePosition();
            } else if (viewGroup instanceof AbsListView) {
                firstVisiblePosition = ((AbsListView) viewGroup).getFirstVisiblePosition();
            } else {
                return;
            }
            if (firstVisiblePosition > this.dCH) {
                gV(true);
            } else if (firstVisiblePosition < this.dCH) {
                gW(true);
            } else if (firstVisiblePosition == this.dCH) {
                if (firstVisiblePosition == 0 || !this.dCI) {
                    gW(true);
                } else {
                    gV(true);
                }
            }
        }
    }
}
