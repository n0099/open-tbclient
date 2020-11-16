package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class y {
    private View aXe;
    private int fyl;
    private boolean fym;
    private final Handler mHandler;

    public void bDh() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bDi() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void hideFloatingView(boolean z) {
        if (this.aXe != null) {
            if (z || this.aXe.getVisibility() != 8) {
                bDi();
            }
        }
    }

    public void showFloatingView(boolean z) {
        if (this.aXe != null) {
            if (z || this.aXe.getVisibility() != 0) {
                bDh();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.aXe != null) {
            if (i != 0 && i2 > i && this.aXe.getVisibility() != 8) {
                hideFloatingView(false);
            } else if ((i == 0 || i2 < i) && this.aXe.getVisibility() != 0) {
                showFloatingView(false);
            }
            this.fyl = i;
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
            if (firstVisiblePosition > this.fyl) {
                hideFloatingView(true);
            } else if (firstVisiblePosition < this.fyl) {
                showFloatingView(true);
            } else if (firstVisiblePosition == this.fyl) {
                if (firstVisiblePosition == 0 || !this.fym) {
                    showFloatingView(true);
                } else {
                    hideFloatingView(true);
                }
            }
        }
    }
}
