package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public class q {
    private int aLA;
    private boolean aLB;
    private View aLz;
    private final Handler mHandler;

    public void He() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Hf() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Hg() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void cf(boolean z) {
        if (this.aLz != null) {
            if (z || this.aLz.getVisibility() != 8) {
                Hf();
            }
        }
    }

    public void cg(boolean z) {
        if (this.aLz != null) {
            if (z || this.aLz.getVisibility() != 0) {
                He();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.aLz != null) {
            if (i != 0 && i2 > i && this.aLz.getVisibility() != 8) {
                cf(false);
            } else if ((i == 0 || i2 < i) && this.aLz.getVisibility() != 0) {
                cg(false);
            }
            this.aLA = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.aLA) {
                cf(true);
            } else if (firstVisiblePosition < this.aLA) {
                cg(true);
            } else if (firstVisiblePosition == this.aLA) {
                if (firstVisiblePosition == 0 || !this.aLB) {
                    cg(true);
                } else {
                    cf(true);
                }
            }
        }
    }
}
