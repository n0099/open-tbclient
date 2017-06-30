package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public class t {
    private View aKr;
    private int aKs;
    private boolean aKt;
    private final Handler mHandler;

    public void GP() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void GQ() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void GR() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void cc(boolean z) {
        if (this.aKr != null) {
            if (z || this.aKr.getVisibility() != 8) {
                GQ();
            }
        }
    }

    public void cd(boolean z) {
        if (this.aKr != null) {
            if (z || this.aKr.getVisibility() != 0) {
                GP();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.aKr != null) {
            if (i != 0 && i2 > i && this.aKr.getVisibility() != 8) {
                cc(false);
            } else if ((i == 0 || i2 < i) && this.aKr.getVisibility() != 0) {
                cd(false);
            }
            this.aKs = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.aKs) {
                cc(true);
            } else if (firstVisiblePosition < this.aKs) {
                cd(true);
            } else if (firstVisiblePosition == this.aKs) {
                if (firstVisiblePosition == 0 || !this.aKt) {
                    cd(true);
                } else {
                    cc(true);
                }
            }
        }
    }
}
