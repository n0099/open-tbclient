package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class z {
    private View aKd;
    private boolean eEA;
    private int eEz;
    private final Handler mHandler;

    public void biX() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void biY() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void iJ(boolean z) {
        if (this.aKd != null) {
            if (z || this.aKd.getVisibility() != 8) {
                biY();
            }
        }
    }

    public void iK(boolean z) {
        if (this.aKd != null) {
            if (z || this.aKd.getVisibility() != 0) {
                biX();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.aKd != null) {
            if (i != 0 && i2 > i && this.aKd.getVisibility() != 8) {
                iJ(false);
            } else if ((i == 0 || i2 < i) && this.aKd.getVisibility() != 0) {
                iK(false);
            }
            this.eEz = i;
        }
    }

    public void k(ViewGroup viewGroup, int i) {
        int firstVisiblePosition;
        if (viewGroup != null && i == 0) {
            if (viewGroup instanceof BdRecyclerView) {
                firstVisiblePosition = ((BdRecyclerView) viewGroup).getFirstVisiblePosition();
            } else if (viewGroup instanceof AbsListView) {
                firstVisiblePosition = ((AbsListView) viewGroup).getFirstVisiblePosition();
            } else {
                return;
            }
            if (firstVisiblePosition > this.eEz) {
                iJ(true);
            } else if (firstVisiblePosition < this.eEz) {
                iK(true);
            } else if (firstVisiblePosition == this.eEz) {
                if (firstVisiblePosition == 0 || !this.eEA) {
                    iK(true);
                } else {
                    iJ(true);
                }
            }
        }
    }
}
