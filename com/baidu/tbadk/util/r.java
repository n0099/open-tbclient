package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public class r {
    private View bDj;
    private int bDk;
    private boolean bDl;
    private final Handler mHandler;

    public void Pi() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Pj() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Pk() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void cF(boolean z) {
        if (this.bDj != null) {
            if (z || this.bDj.getVisibility() != 8) {
                Pj();
            }
        }
    }

    public void cG(boolean z) {
        if (this.bDj != null) {
            if (z || this.bDj.getVisibility() != 0) {
                Pi();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.bDj != null) {
            if (i != 0 && i2 > i && this.bDj.getVisibility() != 8) {
                cF(false);
            } else if ((i == 0 || i2 < i) && this.bDj.getVisibility() != 0) {
                cG(false);
            }
            this.bDk = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.bDk) {
                cF(true);
            } else if (firstVisiblePosition < this.bDk) {
                cG(true);
            } else if (firstVisiblePosition == this.bDk) {
                if (firstVisiblePosition == 0 || !this.bDl) {
                    cG(true);
                } else {
                    cF(true);
                }
            }
        }
    }
}
