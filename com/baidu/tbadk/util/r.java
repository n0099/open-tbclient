package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public class r {
    private View aNi;
    private int aNj;
    private boolean aNk;
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
        if (this.aNi != null) {
            if (z || this.aNi.getVisibility() != 8) {
                Hp();
            }
        }
    }

    public void ca(boolean z) {
        if (this.aNi != null) {
            if (z || this.aNi.getVisibility() != 0) {
                Ho();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.aNi != null) {
            if (i != 0 && i2 > i && this.aNi.getVisibility() != 8) {
                bZ(false);
            } else if ((i == 0 || i2 < i) && this.aNi.getVisibility() != 0) {
                ca(false);
            }
            this.aNj = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.aNj) {
                bZ(true);
            } else if (firstVisiblePosition < this.aNj) {
                ca(true);
            } else if (firstVisiblePosition == this.aNj) {
                if (firstVisiblePosition == 0 || !this.aNk) {
                    ca(true);
                } else {
                    bZ(true);
                }
            }
        }
    }
}
