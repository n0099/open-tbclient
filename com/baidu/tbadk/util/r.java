package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public class r {
    private View aNf;
    private int aNg;
    private boolean aNh;
    private final Handler mHandler;

    public void Hn() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Ho() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Hp() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void bY(boolean z) {
        if (this.aNf != null) {
            if (z || this.aNf.getVisibility() != 8) {
                Ho();
            }
        }
    }

    public void bZ(boolean z) {
        if (this.aNf != null) {
            if (z || this.aNf.getVisibility() != 0) {
                Hn();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.aNf != null) {
            if (i != 0 && i2 > i && this.aNf.getVisibility() != 8) {
                bY(false);
            } else if ((i == 0 || i2 < i) && this.aNf.getVisibility() != 0) {
                bZ(false);
            }
            this.aNg = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.aNg) {
                bY(true);
            } else if (firstVisiblePosition < this.aNg) {
                bZ(true);
            } else if (firstVisiblePosition == this.aNg) {
                if (firstVisiblePosition == 0 || !this.aNh) {
                    bZ(true);
                } else {
                    bY(true);
                }
            }
        }
    }
}
