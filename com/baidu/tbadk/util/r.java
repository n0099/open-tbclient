package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public class r {
    private View bBp;
    private int bBq;
    private boolean bBr;
    private final Handler mHandler;

    public void OD() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void OE() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void OF() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void cB(boolean z) {
        if (this.bBp != null) {
            if (z || this.bBp.getVisibility() != 8) {
                OE();
            }
        }
    }

    public void cC(boolean z) {
        if (this.bBp != null) {
            if (z || this.bBp.getVisibility() != 0) {
                OD();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.bBp != null) {
            if (i != 0 && i2 > i && this.bBp.getVisibility() != 8) {
                cB(false);
            } else if ((i == 0 || i2 < i) && this.bBp.getVisibility() != 0) {
                cC(false);
            }
            this.bBq = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.bBq) {
                cB(true);
            } else if (firstVisiblePosition < this.bBq) {
                cC(true);
            } else if (firstVisiblePosition == this.bBq) {
                if (firstVisiblePosition == 0 || !this.bBr) {
                    cC(true);
                } else {
                    cB(true);
                }
            }
        }
    }
}
