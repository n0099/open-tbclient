package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public class p {
    private View aLV;
    private int aLW;
    private boolean aLX;
    private final Handler mHandler;

    public void GP() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void GQ() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void GR() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void ce(boolean z) {
        if (this.aLV != null) {
            if (z || this.aLV.getVisibility() != 8) {
                GQ();
            }
        }
    }

    public void cf(boolean z) {
        if (this.aLV != null) {
            if (z || this.aLV.getVisibility() != 0) {
                GP();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.aLV != null) {
            if (i != 0 && i2 > i && this.aLV.getVisibility() != 8) {
                ce(false);
            } else if ((i == 0 || i2 < i) && this.aLV.getVisibility() != 0) {
                cf(false);
            }
            this.aLW = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.aLW) {
                ce(true);
            } else if (firstVisiblePosition < this.aLW) {
                cf(true);
            } else if (firstVisiblePosition == this.aLW) {
                if (firstVisiblePosition == 0 || !this.aLX) {
                    cf(true);
                } else {
                    ce(true);
                }
            }
        }
    }
}
