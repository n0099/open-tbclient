package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public class s {
    private View aJc;
    private int aJd;
    private boolean aJe;
    private final Handler mHandler;

    public void Gs() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Gt() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Gu() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void ca(boolean z) {
        if (this.aJc != null) {
            if (z || this.aJc.getVisibility() != 8) {
                Gt();
            }
        }
    }

    public void cb(boolean z) {
        if (this.aJc != null) {
            if (z || this.aJc.getVisibility() != 0) {
                Gs();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.aJc != null) {
            if (i != 0 && i2 > i && this.aJc.getVisibility() != 8) {
                ca(false);
            } else if ((i == 0 || i2 < i) && this.aJc.getVisibility() != 0) {
                cb(false);
            }
            this.aJd = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.aJd) {
                ca(true);
            } else if (firstVisiblePosition < this.aJd) {
                cb(true);
            } else if (firstVisiblePosition == this.aJd) {
                if (firstVisiblePosition == 0 || !this.aJe) {
                    cb(true);
                } else {
                    ca(true);
                }
            }
        }
    }
}
