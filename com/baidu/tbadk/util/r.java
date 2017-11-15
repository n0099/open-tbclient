package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public class r {
    private View aME;
    private int aMF;
    private boolean aMG;
    private final Handler mHandler;

    public void Hg() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Hh() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Hi() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void bZ(boolean z) {
        if (this.aME != null) {
            if (z || this.aME.getVisibility() != 8) {
                Hh();
            }
        }
    }

    public void ca(boolean z) {
        if (this.aME != null) {
            if (z || this.aME.getVisibility() != 0) {
                Hg();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.aME != null) {
            if (i != 0 && i2 > i && this.aME.getVisibility() != 8) {
                bZ(false);
            } else if ((i == 0 || i2 < i) && this.aME.getVisibility() != 0) {
                ca(false);
            }
            this.aMF = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.aMF) {
                bZ(true);
            } else if (firstVisiblePosition < this.aMF) {
                ca(true);
            } else if (firstVisiblePosition == this.aMF) {
                if (firstVisiblePosition == 0 || !this.aMG) {
                    ca(true);
                } else {
                    bZ(true);
                }
            }
        }
    }
}
