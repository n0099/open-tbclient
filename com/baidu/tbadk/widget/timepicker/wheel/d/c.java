package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes20.dex */
public final class c extends TimerTask {
    private final WheelView flD;
    private int offset;
    private int realTotalOffset = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int realOffset = 0;

    public c(WheelView wheelView, int i) {
        this.flD = wheelView;
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
            this.flD.cancelFuture();
            this.flD.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.flD.setTotalScrollY(this.flD.getTotalScrollY() + this.realOffset);
        if (!this.flD.isLoop()) {
            float itemHeight = this.flD.getItemHeight();
            float f = (-this.flD.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.flD.getItemsCount() - 1) - this.flD.getInitPosition());
            if (this.flD.getTotalScrollY() <= f || this.flD.getTotalScrollY() >= itemsCount) {
                this.flD.setTotalScrollY(this.flD.getTotalScrollY() - this.realOffset);
                this.flD.cancelFuture();
                this.flD.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.flD.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
