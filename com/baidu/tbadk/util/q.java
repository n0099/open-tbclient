package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public class q {
    private View aMO;
    private int aMP;
    private boolean aMQ;
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
        if (this.aMO != null) {
            if (z || this.aMO.getVisibility() != 8) {
                Hn();
            }
        }
    }

    public void cg(boolean z) {
        if (this.aMO != null) {
            if (z || this.aMO.getVisibility() != 0) {
                Hm();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.aMO != null) {
            if (i != 0 && i2 > i && this.aMO.getVisibility() != 8) {
                cf(false);
            } else if ((i == 0 || i2 < i) && this.aMO.getVisibility() != 0) {
                cg(false);
            }
            this.aMP = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.aMP) {
                cf(true);
            } else if (firstVisiblePosition < this.aMP) {
                cg(true);
            } else if (firstVisiblePosition == this.aMP) {
                if (firstVisiblePosition == 0 || !this.aMQ) {
                    cg(true);
                } else {
                    cf(true);
                }
            }
        }
    }
}
