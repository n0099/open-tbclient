package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class r {
    private View aWB;
    private int aWC;
    private boolean aWD;
    private final Handler mHandler;

    public void Lr() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Ls() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Lt() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void cd(boolean z) {
        if (this.aWB != null) {
            if (z || this.aWB.getVisibility() != 8) {
                Ls();
            }
        }
    }

    public void ce(boolean z) {
        if (this.aWB != null) {
            if (z || this.aWB.getVisibility() != 0) {
                Lr();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.aWB != null) {
            if (i != 0 && i2 > i && this.aWB.getVisibility() != 8) {
                cd(false);
            } else if ((i == 0 || i2 < i) && this.aWB.getVisibility() != 0) {
                ce(false);
            }
            this.aWC = i;
        }
    }

    public void g(ViewGroup viewGroup, int i) {
        int firstVisiblePosition;
        if (viewGroup != null && i == 0) {
            if (viewGroup instanceof BdRecyclerView) {
                firstVisiblePosition = ((BdRecyclerView) viewGroup).getFirstVisiblePosition();
            } else if (viewGroup instanceof AbsListView) {
                firstVisiblePosition = ((AbsListView) viewGroup).getFirstVisiblePosition();
            } else {
                return;
            }
            if (firstVisiblePosition > this.aWC) {
                cd(true);
            } else if (firstVisiblePosition < this.aWC) {
                ce(true);
            } else if (firstVisiblePosition == this.aWC) {
                if (firstVisiblePosition == 0 || !this.aWD) {
                    ce(true);
                } else {
                    cd(true);
                }
            }
        }
    }
}
