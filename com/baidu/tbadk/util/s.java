package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public class s {
    private View aJp;
    private int aJq;
    private boolean aJr;
    private final Handler mHandler;

    public void Gy() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Gz() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void GA() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void cd(boolean z) {
        if (this.aJp != null) {
            if (z || this.aJp.getVisibility() != 8) {
                Gz();
            }
        }
    }

    public void ce(boolean z) {
        if (this.aJp != null) {
            if (z || this.aJp.getVisibility() != 0) {
                Gy();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.aJp != null) {
            if (i != 0 && i2 > i && this.aJp.getVisibility() != 8) {
                cd(false);
            } else if ((i == 0 || i2 < i) && this.aJp.getVisibility() != 0) {
                ce(false);
            }
            this.aJq = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.aJq) {
                cd(true);
            } else if (firstVisiblePosition < this.aJq) {
                ce(true);
            } else if (firstVisiblePosition == this.aJq) {
                if (firstVisiblePosition == 0 || !this.aJr) {
                    ce(true);
                } else {
                    cd(true);
                }
            }
        }
    }
}
