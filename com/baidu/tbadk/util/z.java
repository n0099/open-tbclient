package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class z {
    private View aHz;
    private int evt;
    private boolean evu;
    private final Handler mHandler;

    public void bgK() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bgL() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void iy(boolean z) {
        if (this.aHz != null) {
            if (z || this.aHz.getVisibility() != 8) {
                bgL();
            }
        }
    }

    public void iz(boolean z) {
        if (this.aHz != null) {
            if (z || this.aHz.getVisibility() != 0) {
                bgK();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.aHz != null) {
            if (i != 0 && i2 > i && this.aHz.getVisibility() != 8) {
                iy(false);
            } else if ((i == 0 || i2 < i) && this.aHz.getVisibility() != 0) {
                iz(false);
            }
            this.evt = i;
        }
    }

    public void j(ViewGroup viewGroup, int i) {
        int firstVisiblePosition;
        if (viewGroup != null && i == 0) {
            if (viewGroup instanceof BdRecyclerView) {
                firstVisiblePosition = ((BdRecyclerView) viewGroup).getFirstVisiblePosition();
            } else if (viewGroup instanceof AbsListView) {
                firstVisiblePosition = ((AbsListView) viewGroup).getFirstVisiblePosition();
            } else {
                return;
            }
            if (firstVisiblePosition > this.evt) {
                iy(true);
            } else if (firstVisiblePosition < this.evt) {
                iz(true);
            } else if (firstVisiblePosition == this.evt) {
                if (firstVisiblePosition == 0 || !this.evu) {
                    iz(true);
                } else {
                    iy(true);
                }
            }
        }
    }
}
