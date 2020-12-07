package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes21.dex */
public final class c extends TimerTask {
    private final WheelView fTq;
    private int offset;
    private int realTotalOffset = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int realOffset = 0;

    public c(WheelView wheelView, int i) {
        this.fTq = wheelView;
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
            this.fTq.cancelFuture();
            this.fTq.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.fTq.setTotalScrollY(this.fTq.getTotalScrollY() + this.realOffset);
        if (!this.fTq.isLoop()) {
            float itemHeight = this.fTq.getItemHeight();
            float f = (-this.fTq.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.fTq.getItemsCount() - 1) - this.fTq.getInitPosition());
            if (this.fTq.getTotalScrollY() <= f || this.fTq.getTotalScrollY() >= itemsCount) {
                this.fTq.setTotalScrollY(this.fTq.getTotalScrollY() - this.realOffset);
                this.fTq.cancelFuture();
                this.fTq.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.fTq.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
