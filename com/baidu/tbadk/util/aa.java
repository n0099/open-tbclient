package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class aa {
    private View aWc;
    private int fkH;
    private boolean fkI;
    private final Handler mHandler;

    public void bzy() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bzz() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void hideFloatingView(boolean z) {
        if (this.aWc != null) {
            if (z || this.aWc.getVisibility() != 8) {
                bzz();
            }
        }
    }

    public void showFloatingView(boolean z) {
        if (this.aWc != null) {
            if (z || this.aWc.getVisibility() != 0) {
                bzy();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.aWc != null) {
            if (i != 0 && i2 > i && this.aWc.getVisibility() != 8) {
                hideFloatingView(false);
            } else if ((i == 0 || i2 < i) && this.aWc.getVisibility() != 0) {
                showFloatingView(false);
            }
            this.fkH = i;
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
            if (firstVisiblePosition > this.fkH) {
                hideFloatingView(true);
            } else if (firstVisiblePosition < this.fkH) {
                showFloatingView(true);
            } else if (firstVisiblePosition == this.fkH) {
                if (firstVisiblePosition == 0 || !this.fkI) {
                    showFloatingView(true);
                } else {
                    hideFloatingView(true);
                }
            }
        }
    }
}
