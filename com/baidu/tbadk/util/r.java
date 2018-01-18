package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public class r {
    private View bBh;
    private int bBi;
    private boolean bBj;
    private final Handler mHandler;

    public void OB() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void OC() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void OD() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void cA(boolean z) {
        if (this.bBh != null) {
            if (z || this.bBh.getVisibility() != 8) {
                OC();
            }
        }
    }

    public void cB(boolean z) {
        if (this.bBh != null) {
            if (z || this.bBh.getVisibility() != 0) {
                OB();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.bBh != null) {
            if (i != 0 && i2 > i && this.bBh.getVisibility() != 8) {
                cA(false);
            } else if ((i == 0 || i2 < i) && this.bBh.getVisibility() != 0) {
                cB(false);
            }
            this.bBi = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.bBi) {
                cA(true);
            } else if (firstVisiblePosition < this.bBi) {
                cB(true);
            } else if (firstVisiblePosition == this.bBi) {
                if (firstVisiblePosition == 0 || !this.bBj) {
                    cB(true);
                } else {
                    cA(true);
                }
            }
        }
    }
}
