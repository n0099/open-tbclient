package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class w {
    private View ctG;
    private int ctH;
    private boolean ctI;
    private final Handler mHandler;

    public void aqi() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aqj() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aqk() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void fk(boolean z) {
        if (this.ctG != null) {
            if (z || this.ctG.getVisibility() != 8) {
                aqj();
            }
        }
    }

    public void fl(boolean z) {
        if (this.ctG != null) {
            if (z || this.ctG.getVisibility() != 0) {
                aqi();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.ctG != null) {
            if (i != 0 && i2 > i && this.ctG.getVisibility() != 8) {
                fk(false);
            } else if ((i == 0 || i2 < i) && this.ctG.getVisibility() != 0) {
                fl(false);
            }
            this.ctH = i;
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
            if (firstVisiblePosition > this.ctH) {
                fk(true);
            } else if (firstVisiblePosition < this.ctH) {
                fl(true);
            } else if (firstVisiblePosition == this.ctH) {
                if (firstVisiblePosition == 0 || !this.ctI) {
                    fl(true);
                } else {
                    fk(true);
                }
            }
        }
    }
}
