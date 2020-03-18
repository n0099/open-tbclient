package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class y {
    private View dHo;
    private int dHp;
    private boolean dHq;
    private final Handler mHandler;

    public void aSr() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aSs() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void hd(boolean z) {
        if (this.dHo != null) {
            if (z || this.dHo.getVisibility() != 8) {
                aSs();
            }
        }
    }

    public void he(boolean z) {
        if (this.dHo != null) {
            if (z || this.dHo.getVisibility() != 0) {
                aSr();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.dHo != null) {
            if (i != 0 && i2 > i && this.dHo.getVisibility() != 8) {
                hd(false);
            } else if ((i == 0 || i2 < i) && this.dHo.getVisibility() != 0) {
                he(false);
            }
            this.dHp = i;
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
            if (firstVisiblePosition > this.dHp) {
                hd(true);
            } else if (firstVisiblePosition < this.dHp) {
                he(true);
            } else if (firstVisiblePosition == this.dHp) {
                if (firstVisiblePosition == 0 || !this.dHq) {
                    he(true);
                } else {
                    hd(true);
                }
            }
        }
    }
}
