package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes.dex */
public final class c extends TimerTask {
    private final WheelView bpQ;
    private int bpU = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int bpV = 0;
    private int offset;

    public c(WheelView wheelView, int i) {
        this.bpQ = wheelView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.bpU == Integer.MAX_VALUE) {
            this.bpU = this.offset;
        }
        this.bpV = (int) (this.bpU * 0.1f);
        if (this.bpV == 0) {
            if (this.bpU < 0) {
                this.bpV = -1;
            } else {
                this.bpV = 1;
            }
        }
        if (Math.abs(this.bpU) <= 1) {
            this.bpQ.Sf();
            this.bpQ.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.bpQ.setTotalScrollY(this.bpQ.getTotalScrollY() + this.bpV);
        if (!this.bpQ.Sh()) {
            float itemHeight = this.bpQ.getItemHeight();
            float f = (-this.bpQ.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.bpQ.getItemsCount() - 1) - this.bpQ.getInitPosition());
            if (this.bpQ.getTotalScrollY() <= f || this.bpQ.getTotalScrollY() >= itemsCount) {
                this.bpQ.setTotalScrollY(this.bpQ.getTotalScrollY() - this.bpV);
                this.bpQ.Sf();
                this.bpQ.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.bpQ.getHandler().sendEmptyMessage(1000);
        this.bpU -= this.bpV;
    }
}
