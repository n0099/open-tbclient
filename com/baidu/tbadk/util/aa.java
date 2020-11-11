package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class aa {
    private View aYP;
    private int fyY;
    private boolean fyZ;
    private final Handler mHandler;

    public void bDQ() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bDR() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void hideFloatingView(boolean z) {
        if (this.aYP != null) {
            if (z || this.aYP.getVisibility() != 8) {
                bDR();
            }
        }
    }

    public void showFloatingView(boolean z) {
        if (this.aYP != null) {
            if (z || this.aYP.getVisibility() != 0) {
                bDQ();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.aYP != null) {
            if (i != 0 && i2 > i && this.aYP.getVisibility() != 8) {
                hideFloatingView(false);
            } else if ((i == 0 || i2 < i) && this.aYP.getVisibility() != 0) {
                showFloatingView(false);
            }
            this.fyY = i;
        }
    }

    public void m(ViewGroup viewGroup, int i) {
        int firstVisiblePosition;
        if (viewGroup != null && i == 0) {
            if (viewGroup instanceof BdRecyclerView) {
                firstVisiblePosition = ((BdRecyclerView) viewGroup).getFirstVisiblePosition();
            } else if (viewGroup instanceof AbsListView) {
                firstVisiblePosition = ((AbsListView) viewGroup).getFirstVisiblePosition();
            } else {
                return;
            }
            if (firstVisiblePosition > this.fyY) {
                hideFloatingView(true);
            } else if (firstVisiblePosition < this.fyY) {
                showFloatingView(true);
            } else if (firstVisiblePosition == this.fyY) {
                if (firstVisiblePosition == 0 || !this.fyZ) {
                    showFloatingView(true);
                } else {
                    hideFloatingView(true);
                }
            }
        }
    }
}
