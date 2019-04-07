package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class w {
    private View ctF;
    private int ctG;
    private boolean ctH;
    private final Handler mHandler;

    public void aqf() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aqg() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aqh() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void fk(boolean z) {
        if (this.ctF != null) {
            if (z || this.ctF.getVisibility() != 8) {
                aqg();
            }
        }
    }

    public void fl(boolean z) {
        if (this.ctF != null) {
            if (z || this.ctF.getVisibility() != 0) {
                aqf();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.ctF != null) {
            if (i != 0 && i2 > i && this.ctF.getVisibility() != 8) {
                fk(false);
            } else if ((i == 0 || i2 < i) && this.ctF.getVisibility() != 0) {
                fl(false);
            }
            this.ctG = i;
        }
    }

    public void h(ViewGroup viewGroup, int i) {
        int firstVisiblePosition;
        if (viewGroup != null && i == 0) {
            if (viewGroup instanceof BdRecyclerView) {
                firstVisiblePosition = ((BdRecyclerView) viewGroup).getFirstVisiblePosition();
            } else if (viewGroup instanceof AbsListView) {
                firstVisiblePosition = ((AbsListView) viewGroup).getFirstVisiblePosition();
            } else {
                return;
            }
            if (firstVisiblePosition > this.ctG) {
                fk(true);
            } else if (firstVisiblePosition < this.ctG) {
                fl(true);
            } else if (firstVisiblePosition == this.ctG) {
                if (firstVisiblePosition == 0 || !this.ctH) {
                    fl(true);
                } else {
                    fk(true);
                }
            }
        }
    }
}
