package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class w {
    private View cDh;
    private int cDi;
    private boolean cDj;
    private final Handler mHandler;

    public void awt() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void awu() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void awv() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void fL(boolean z) {
        if (this.cDh != null) {
            if (z || this.cDh.getVisibility() != 8) {
                awu();
            }
        }
    }

    public void fM(boolean z) {
        if (this.cDh != null) {
            if (z || this.cDh.getVisibility() != 0) {
                awt();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.cDh != null) {
            if (i != 0 && i2 > i && this.cDh.getVisibility() != 8) {
                fL(false);
            } else if ((i == 0 || i2 < i) && this.cDh.getVisibility() != 0) {
                fM(false);
            }
            this.cDi = i;
        }
    }

    public void i(ViewGroup viewGroup, int i) {
        int firstVisiblePosition;
        if (viewGroup != null && i == 0) {
            if (viewGroup instanceof BdRecyclerView) {
                firstVisiblePosition = ((BdRecyclerView) viewGroup).getFirstVisiblePosition();
            } else if (viewGroup instanceof AbsListView) {
                firstVisiblePosition = ((AbsListView) viewGroup).getFirstVisiblePosition();
            } else {
                return;
            }
            if (firstVisiblePosition > this.cDi) {
                fL(true);
            } else if (firstVisiblePosition < this.cDi) {
                fM(true);
            } else if (firstVisiblePosition == this.cDi) {
                if (firstVisiblePosition == 0 || !this.cDj) {
                    fM(true);
                } else {
                    fL(true);
                }
            }
        }
    }
}
