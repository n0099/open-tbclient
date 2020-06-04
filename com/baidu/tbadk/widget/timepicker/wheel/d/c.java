package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class c extends TimerTask {
    private final WheelView eHq;
    private int offset;
    private int realTotalOffset = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int realOffset = 0;

    public c(WheelView wheelView, int i) {
        this.eHq = wheelView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.realTotalOffset == Integer.MAX_VALUE) {
            this.realTotalOffset = this.offset;
        }
        this.realOffset = (int) (this.realTotalOffset * 0.1f);
        if (this.realOffset == 0) {
            if (this.realTotalOffset < 0) {
                this.realOffset = -1;
            } else {
                this.realOffset = 1;
            }
        }
        if (Math.abs(this.realTotalOffset) <= 1) {
            this.eHq.cancelFuture();
            this.eHq.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.eHq.setTotalScrollY(this.eHq.getTotalScrollY() + this.realOffset);
        if (!this.eHq.isLoop()) {
            float itemHeight = this.eHq.getItemHeight();
            float f = (-this.eHq.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.eHq.getItemsCount() - 1) - this.eHq.getInitPosition());
            if (this.eHq.getTotalScrollY() <= f || this.eHq.getTotalScrollY() >= itemsCount) {
                this.eHq.setTotalScrollY(this.eHq.getTotalScrollY() - this.realOffset);
                this.eHq.cancelFuture();
                this.eHq.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.eHq.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
