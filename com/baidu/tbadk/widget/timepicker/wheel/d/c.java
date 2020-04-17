package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class c extends TimerTask {
    private final WheelView esA;
    private int offset;
    private int realTotalOffset = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int realOffset = 0;

    public c(WheelView wheelView, int i) {
        this.esA = wheelView;
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
            this.esA.cancelFuture();
            this.esA.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.esA.setTotalScrollY(this.esA.getTotalScrollY() + this.realOffset);
        if (!this.esA.isLoop()) {
            float itemHeight = this.esA.getItemHeight();
            float f = (-this.esA.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.esA.getItemsCount() - 1) - this.esA.getInitPosition());
            if (this.esA.getTotalScrollY() <= f || this.esA.getTotalScrollY() >= itemsCount) {
                this.esA.setTotalScrollY(this.esA.getTotalScrollY() - this.realOffset);
                this.esA.cancelFuture();
                this.esA.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.esA.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
