package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class aa {
    private View aXx;
    private int ftg;
    private boolean fth;
    private final Handler mHandler;

    public void bBr() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bBs() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void hideFloatingView(boolean z) {
        if (this.aXx != null) {
            if (z || this.aXx.getVisibility() != 8) {
                bBs();
            }
        }
    }

    public void showFloatingView(boolean z) {
        if (this.aXx != null) {
            if (z || this.aXx.getVisibility() != 0) {
                bBr();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.aXx != null) {
            if (i != 0 && i2 > i && this.aXx.getVisibility() != 8) {
                hideFloatingView(false);
            } else if ((i == 0 || i2 < i) && this.aXx.getVisibility() != 0) {
                showFloatingView(false);
            }
            this.ftg = i;
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
            if (firstVisiblePosition > this.ftg) {
                hideFloatingView(true);
            } else if (firstVisiblePosition < this.ftg) {
                showFloatingView(true);
            } else if (firstVisiblePosition == this.ftg) {
                if (firstVisiblePosition == 0 || !this.fth) {
                    showFloatingView(true);
                } else {
                    hideFloatingView(true);
                }
            }
        }
    }
}
