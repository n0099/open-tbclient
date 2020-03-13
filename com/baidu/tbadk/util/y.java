package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class y {
    private View dGY;
    private int dGZ;
    private boolean dHa;
    private final Handler mHandler;

    public void aSn() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aSo() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void hc(boolean z) {
        if (this.dGY != null) {
            if (z || this.dGY.getVisibility() != 8) {
                aSo();
            }
        }
    }

    public void hd(boolean z) {
        if (this.dGY != null) {
            if (z || this.dGY.getVisibility() != 0) {
                aSn();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.dGY != null) {
            if (i != 0 && i2 > i && this.dGY.getVisibility() != 8) {
                hc(false);
            } else if ((i == 0 || i2 < i) && this.dGY.getVisibility() != 0) {
                hd(false);
            }
            this.dGZ = i;
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
            if (firstVisiblePosition > this.dGZ) {
                hc(true);
            } else if (firstVisiblePosition < this.dGZ) {
                hd(true);
            } else if (firstVisiblePosition == this.dGZ) {
                if (firstVisiblePosition == 0 || !this.dHa) {
                    hd(true);
                } else {
                    hc(true);
                }
            }
        }
    }
}
