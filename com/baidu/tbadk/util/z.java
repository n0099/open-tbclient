package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class z {
    private View aLz;
    private int eKV;
    private boolean eKW;
    private final Handler mHandler;

    public void bmR() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bmS() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void hideFloatingView(boolean z) {
        if (this.aLz != null) {
            if (z || this.aLz.getVisibility() != 8) {
                bmS();
            }
        }
    }

    public void showFloatingView(boolean z) {
        if (this.aLz != null) {
            if (z || this.aLz.getVisibility() != 0) {
                bmR();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.aLz != null) {
            if (i != 0 && i2 > i && this.aLz.getVisibility() != 8) {
                hideFloatingView(false);
            } else if ((i == 0 || i2 < i) && this.aLz.getVisibility() != 0) {
                showFloatingView(false);
            }
            this.eKV = i;
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
            if (firstVisiblePosition > this.eKV) {
                hideFloatingView(true);
            } else if (firstVisiblePosition < this.eKV) {
                showFloatingView(true);
            } else if (firstVisiblePosition == this.eKV) {
                if (firstVisiblePosition == 0 || !this.eKW) {
                    showFloatingView(true);
                } else {
                    hideFloatingView(true);
                }
            }
        }
    }
}
