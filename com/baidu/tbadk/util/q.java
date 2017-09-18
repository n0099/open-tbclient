package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public class q {
    private View aMt;
    private int aMu;
    private boolean aMv;
    private final Handler mHandler;

    public void Hl() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Hm() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Hn() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void cf(boolean z) {
        if (this.aMt != null) {
            if (z || this.aMt.getVisibility() != 8) {
                Hm();
            }
        }
    }

    public void cg(boolean z) {
        if (this.aMt != null) {
            if (z || this.aMt.getVisibility() != 0) {
                Hl();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.aMt != null) {
            if (i != 0 && i2 > i && this.aMt.getVisibility() != 8) {
                cf(false);
            } else if ((i == 0 || i2 < i) && this.aMt.getVisibility() != 0) {
                cg(false);
            }
            this.aMu = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.aMu) {
                cf(true);
            } else if (firstVisiblePosition < this.aMu) {
                cg(true);
            } else if (firstVisiblePosition == this.aMu) {
                if (firstVisiblePosition == 0 || !this.aMv) {
                    cg(true);
                } else {
                    cf(true);
                }
            }
        }
    }
}
