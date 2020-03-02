package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdRecyclerView;
/* loaded from: classes.dex */
public class y {
    private View dGL;
    private int dGM;
    private boolean dGN;
    private final Handler mHandler;

    public void aSm() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aSn() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void hc(boolean z) {
        if (this.dGL != null) {
            if (z || this.dGL.getVisibility() != 8) {
                aSn();
            }
        }
    }

    public void hd(boolean z) {
        if (this.dGL != null) {
            if (z || this.dGL.getVisibility() != 0) {
                aSm();
            }
        }
    }

    public void onScroll(int i, int i2) {
        if (this.dGL != null) {
            if (i != 0 && i2 > i && this.dGL.getVisibility() != 8) {
                hc(false);
            } else if ((i == 0 || i2 < i) && this.dGL.getVisibility() != 0) {
                hd(false);
            }
            this.dGM = i;
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
            if (firstVisiblePosition > this.dGM) {
                hc(true);
            } else if (firstVisiblePosition < this.dGM) {
                hd(true);
            } else if (firstVisiblePosition == this.dGM) {
                if (firstVisiblePosition == 0 || !this.dGN) {
                    hd(true);
                } else {
                    hc(true);
                }
            }
        }
    }
}
