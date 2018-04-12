package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public class r {
    private View aNG;
    private int aNH;
    private boolean aNI;
    private final Handler mHandler;

    public void HK() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void HL() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void HM() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void bX(boolean z) {
        if (this.aNG != null) {
            if (z || this.aNG.getVisibility() != 8) {
                HL();
            }
        }
    }

    public void bY(boolean z) {
        if (this.aNG != null) {
            if (z || this.aNG.getVisibility() != 0) {
                HK();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.aNG != null) {
            if (i != 0 && i2 > i && this.aNG.getVisibility() != 8) {
                bX(false);
            } else if ((i == 0 || i2 < i) && this.aNG.getVisibility() != 0) {
                bY(false);
            }
            this.aNH = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.aNH) {
                bX(true);
            } else if (firstVisiblePosition < this.aNH) {
                bY(true);
            } else if (firstVisiblePosition == this.aNH) {
                if (firstVisiblePosition == 0 || !this.aNI) {
                    bY(true);
                } else {
                    bX(true);
                }
            }
        }
    }
}
