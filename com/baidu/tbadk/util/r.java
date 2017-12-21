package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public class r {
    private View aNl;
    private int aNm;
    private boolean aNn;
    private final Handler mHandler;

    public void Ho() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Hp() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Hq() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void bZ(boolean z) {
        if (this.aNl != null) {
            if (z || this.aNl.getVisibility() != 8) {
                Hp();
            }
        }
    }

    public void ca(boolean z) {
        if (this.aNl != null) {
            if (z || this.aNl.getVisibility() != 0) {
                Ho();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.aNl != null) {
            if (i != 0 && i2 > i && this.aNl.getVisibility() != 8) {
                bZ(false);
            } else if ((i == 0 || i2 < i) && this.aNl.getVisibility() != 0) {
                ca(false);
            }
            this.aNm = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.aNm) {
                bZ(true);
            } else if (firstVisiblePosition < this.aNm) {
                ca(true);
            } else if (firstVisiblePosition == this.aNm) {
                if (firstVisiblePosition == 0 || !this.aNn) {
                    ca(true);
                } else {
                    bZ(true);
                }
            }
        }
    }
}
