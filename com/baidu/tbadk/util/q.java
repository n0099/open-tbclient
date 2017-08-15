package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public class q {
    private View aMP;
    private int aMQ;
    private boolean aMR;
    private final Handler mHandler;

    public void Hm() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Hn() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Ho() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void cf(boolean z) {
        if (this.aMP != null) {
            if (z || this.aMP.getVisibility() != 8) {
                Hn();
            }
        }
    }

    public void cg(boolean z) {
        if (this.aMP != null) {
            if (z || this.aMP.getVisibility() != 0) {
                Hm();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.aMP != null) {
            if (i != 0 && i2 > i && this.aMP.getVisibility() != 8) {
                cf(false);
            } else if ((i == 0 || i2 < i) && this.aMP.getVisibility() != 0) {
                cg(false);
            }
            this.aMQ = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.aMQ) {
                cf(true);
            } else if (firstVisiblePosition < this.aMQ) {
                cg(true);
            } else if (firstVisiblePosition == this.aMQ) {
                if (firstVisiblePosition == 0 || !this.aMR) {
                    cg(true);
                } else {
                    cf(true);
                }
            }
        }
    }
}
