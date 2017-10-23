package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public class p {
    private View aLI;
    private int aLJ;
    private boolean aLK;
    private final Handler mHandler;

    public void GJ() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void GK() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void GL() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void cd(boolean z) {
        if (this.aLI != null) {
            if (z || this.aLI.getVisibility() != 8) {
                GK();
            }
        }
    }

    public void ce(boolean z) {
        if (this.aLI != null) {
            if (z || this.aLI.getVisibility() != 0) {
                GJ();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.aLI != null) {
            if (i != 0 && i2 > i && this.aLI.getVisibility() != 8) {
                cd(false);
            } else if ((i == 0 || i2 < i) && this.aLI.getVisibility() != 0) {
                ce(false);
            }
            this.aLJ = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.aLJ) {
                cd(true);
            } else if (firstVisiblePosition < this.aLJ) {
                ce(true);
            } else if (firstVisiblePosition == this.aLJ) {
                if (firstVisiblePosition == 0 || !this.aLK) {
                    ce(true);
                } else {
                    cd(true);
                }
            }
        }
    }
}
