package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class y {
    private View aCc;
    private int ehb;
    private boolean ehc;
    private final Handler mHandler;

    public void bay() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void baz() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void ib(boolean z) {
        if (this.aCc != null) {
            if (z || this.aCc.getVisibility() != 8) {
                baz();
            }
        }
    }

    public void ic(boolean z) {
        if (this.aCc != null) {
            if (z || this.aCc.getVisibility() != 0) {
                bay();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.aCc != null) {
            if (i != 0 && i2 > i && this.aCc.getVisibility() != 8) {
                ib(false);
            } else if ((i == 0 || i2 < i) && this.aCc.getVisibility() != 0) {
                ic(false);
            }
            this.ehb = i;
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
            if (firstVisiblePosition > this.ehb) {
                ib(true);
            } else if (firstVisiblePosition < this.ehb) {
                ic(true);
            } else if (firstVisiblePosition == this.ehb) {
                if (firstVisiblePosition == 0 || !this.ehc) {
                    ic(true);
                } else {
                    ib(true);
                }
            }
        }
    }
}
