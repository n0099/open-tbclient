package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes15.dex */
public final class c extends TimerTask {
    private final WheelView fiM;
    private int offset;
    private int realTotalOffset = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int realOffset = 0;

    public c(WheelView wheelView, int i) {
        this.fiM = wheelView;
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
            this.fiM.cancelFuture();
            this.fiM.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.fiM.setTotalScrollY(this.fiM.getTotalScrollY() + this.realOffset);
        if (!this.fiM.isLoop()) {
            float itemHeight = this.fiM.getItemHeight();
            float f = (-this.fiM.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.fiM.getItemsCount() - 1) - this.fiM.getInitPosition());
            if (this.fiM.getTotalScrollY() <= f || this.fiM.getTotalScrollY() >= itemsCount) {
                this.fiM.setTotalScrollY(this.fiM.getTotalScrollY() - this.realOffset);
                this.fiM.cancelFuture();
                this.fiM.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.fiM.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
