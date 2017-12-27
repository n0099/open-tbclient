package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public class r {
    private View bAY;
    private int bAZ;
    private boolean bBa;
    private final Handler mHandler;

    public void ON() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void OO() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void OP() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void cC(boolean z) {
        if (this.bAY != null) {
            if (z || this.bAY.getVisibility() != 8) {
                OO();
            }
        }
    }

    public void cD(boolean z) {
        if (this.bAY != null) {
            if (z || this.bAY.getVisibility() != 0) {
                ON();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.bAY != null) {
            if (i != 0 && i2 > i && this.bAY.getVisibility() != 8) {
                cC(false);
            } else if ((i == 0 || i2 < i) && this.bAY.getVisibility() != 0) {
                cD(false);
            }
            this.bAZ = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.bAZ) {
                cC(true);
            } else if (firstVisiblePosition < this.bAZ) {
                cD(true);
            } else if (firstVisiblePosition == this.bAZ) {
                if (firstVisiblePosition == 0 || !this.bBa) {
                    cD(true);
                } else {
                    cC(true);
                }
            }
        }
    }
}
