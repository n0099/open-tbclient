package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public class r {
    private View aNH;
    private int aNI;
    private boolean aNJ;
    private final Handler mHandler;

    public void HI() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void HJ() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void HK() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void bX(boolean z) {
        if (this.aNH != null) {
            if (z || this.aNH.getVisibility() != 8) {
                HJ();
            }
        }
    }

    public void bY(boolean z) {
        if (this.aNH != null) {
            if (z || this.aNH.getVisibility() != 0) {
                HI();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.aNH != null) {
            if (i != 0 && i2 > i && this.aNH.getVisibility() != 8) {
                bX(false);
            } else if ((i == 0 || i2 < i) && this.aNH.getVisibility() != 0) {
                bY(false);
            }
            this.aNI = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.aNI) {
                bX(true);
            } else if (firstVisiblePosition < this.aNI) {
                bY(true);
            } else if (firstVisiblePosition == this.aNI) {
                if (firstVisiblePosition == 0 || !this.aNJ) {
                    bY(true);
                } else {
                    bX(true);
                }
            }
        }
    }
}
