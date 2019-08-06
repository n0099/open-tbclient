package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class c extends TimerTask {
    private final WheelView cPQ;
    private int cPU = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int cPV = 0;
    private int offset;

    public c(WheelView wheelView, int i) {
        this.cPQ = wheelView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.cPU == Integer.MAX_VALUE) {
            this.cPU = this.offset;
        }
        this.cPV = (int) (this.cPU * 0.1f);
        if (this.cPV == 0) {
            if (this.cPU < 0) {
                this.cPV = -1;
            } else {
                this.cPV = 1;
            }
        }
        if (Math.abs(this.cPU) <= 1) {
            this.cPQ.aAk();
            this.cPQ.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.cPQ.setTotalScrollY(this.cPQ.getTotalScrollY() + this.cPV);
        if (!this.cPQ.aAm()) {
            float itemHeight = this.cPQ.getItemHeight();
            float f = (-this.cPQ.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.cPQ.getItemsCount() - 1) - this.cPQ.getInitPosition());
            if (this.cPQ.getTotalScrollY() <= f || this.cPQ.getTotalScrollY() >= itemsCount) {
                this.cPQ.setTotalScrollY(this.cPQ.getTotalScrollY() - this.cPV);
                this.cPQ.aAk();
                this.cPQ.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.cPQ.getHandler().sendEmptyMessage(1000);
        this.cPU -= this.cPV;
    }
}
