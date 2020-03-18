package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class c extends TimerTask {
    private final WheelView dSC;
    private int offset;
    private int realTotalOffset = Integer.MAX_VALUE;
    private int realOffset = 0;

    public c(WheelView wheelView, int i) {
        this.dSC = wheelView;
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
            this.dSC.cancelFuture();
            this.dSC.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.dSC.setTotalScrollY(this.dSC.getTotalScrollY() + this.realOffset);
        if (!this.dSC.isLoop()) {
            float itemHeight = this.dSC.getItemHeight();
            float f = (-this.dSC.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.dSC.getItemsCount() - 1) - this.dSC.getInitPosition());
            if (this.dSC.getTotalScrollY() <= f || this.dSC.getTotalScrollY() >= itemsCount) {
                this.dSC.setTotalScrollY(this.dSC.getTotalScrollY() - this.realOffset);
                this.dSC.cancelFuture();
                this.dSC.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.dSC.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
