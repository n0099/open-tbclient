package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public class r {
    private View aMw;
    private int aMx;
    private boolean aMy;
    private final Handler mHandler;

    public void GV() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void GW() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void GX() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void bY(boolean z) {
        if (this.aMw != null) {
            if (z || this.aMw.getVisibility() != 8) {
                GW();
            }
        }
    }

    public void bZ(boolean z) {
        if (this.aMw != null) {
            if (z || this.aMw.getVisibility() != 0) {
                GV();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.aMw != null) {
            if (i != 0 && i2 > i && this.aMw.getVisibility() != 8) {
                bY(false);
            } else if ((i == 0 || i2 < i) && this.aMw.getVisibility() != 0) {
                bZ(false);
            }
            this.aMx = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.aMx) {
                bY(true);
            } else if (firstVisiblePosition < this.aMx) {
                bZ(true);
            } else if (firstVisiblePosition == this.aMx) {
                if (firstVisiblePosition == 0 || !this.aMy) {
                    bZ(true);
                } else {
                    bY(true);
                }
            }
        }
    }
}
