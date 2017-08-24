package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public class q {
    private View aMQ;
    private int aMR;
    private boolean aMS;
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
        if (this.aMQ != null) {
            if (z || this.aMQ.getVisibility() != 8) {
                Hn();
            }
        }
    }

    public void cg(boolean z) {
        if (this.aMQ != null) {
            if (z || this.aMQ.getVisibility() != 0) {
                Hm();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.aMQ != null) {
            if (i != 0 && i2 > i && this.aMQ.getVisibility() != 8) {
                cf(false);
            } else if ((i == 0 || i2 < i) && this.aMQ.getVisibility() != 0) {
                cg(false);
            }
            this.aMR = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.aMR) {
                cf(true);
            } else if (firstVisiblePosition < this.aMR) {
                cg(true);
            } else if (firstVisiblePosition == this.aMR) {
                if (firstVisiblePosition == 0 || !this.aMS) {
                    cg(true);
                } else {
                    cf(true);
                }
            }
        }
    }
}
