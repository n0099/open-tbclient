package com.baidu.tbadk.util;

import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public class s {
    private View aVE;
    private int aVF;
    private boolean aVG;
    private final Handler mHandler;

    public void Le() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Lf() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Lg() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void cc(boolean z) {
        if (this.aVE != null) {
            if (z || this.aVE.getVisibility() != 8) {
                Lf();
            }
        }
    }

    public void cd(boolean z) {
        if (this.aVE != null) {
            if (z || this.aVE.getVisibility() != 0) {
                Le();
            }
        }
    }

    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
        if (this.aVE != null) {
            if (i != 0 && i2 > i && this.aVE.getVisibility() != 8) {
                cc(false);
            } else if ((i == 0 || i2 < i) && this.aVE.getVisibility() != 0) {
                cd(false);
            }
            this.aVF = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView != null && i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            if (firstVisiblePosition > this.aVF) {
                cc(true);
            } else if (firstVisiblePosition < this.aVF) {
                cd(true);
            } else if (firstVisiblePosition == this.aVF) {
                if (firstVisiblePosition == 0 || !this.aVG) {
                    cd(true);
                } else {
                    cc(true);
                }
            }
        }
    }
}
