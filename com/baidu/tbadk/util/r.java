package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public class r {
    private View bDg;
    private int bDh;
    private boolean bDi;
    private final Handler mHandler;

    public void Ph() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Pi() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Pj() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void cF(boolean z) {
        if (this.bDg != null) {
            if (z || this.bDg.getVisibility() != 8) {
                Pi();
            }
        }
    }

    public void cG(boolean z) {
        if (this.bDg != null) {
            if (z || this.bDg.getVisibility() != 0) {
                Ph();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.bDg != null) {
            if (i != 0 && i2 > i && this.bDg.getVisibility() != 8) {
                cF(false);
            } else if ((i == 0 || i2 < i) && this.bDg.getVisibility() != 0) {
                cG(false);
            }
            this.bDh = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.bDh) {
                cF(true);
            } else if (firstVisiblePosition < this.bDh) {
                cG(true);
            } else if (firstVisiblePosition == this.bDh) {
                if (firstVisiblePosition == 0 || !this.bDi) {
                    cG(true);
                } else {
                    cF(true);
                }
            }
        }
    }
}
