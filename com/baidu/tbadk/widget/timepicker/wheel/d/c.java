package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes21.dex */
public final class c extends TimerTask {
    private final WheelView fGm;
    private int offset;
    private int realTotalOffset = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int realOffset = 0;

    public c(WheelView wheelView, int i) {
        this.fGm = wheelView;
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
            this.fGm.cancelFuture();
            this.fGm.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.fGm.setTotalScrollY(this.fGm.getTotalScrollY() + this.realOffset);
        if (!this.fGm.isLoop()) {
            float itemHeight = this.fGm.getItemHeight();
            float f = (-this.fGm.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.fGm.getItemsCount() - 1) - this.fGm.getInitPosition());
            if (this.fGm.getTotalScrollY() <= f || this.fGm.getTotalScrollY() >= itemsCount) {
                this.fGm.setTotalScrollY(this.fGm.getTotalScrollY() - this.realOffset);
                this.fGm.cancelFuture();
                this.fGm.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.fGm.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
