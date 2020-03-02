package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class c extends TimerTask {
    private final WheelView dRY;
    private int offset;
    private int realTotalOffset = Integer.MAX_VALUE;
    private int realOffset = 0;

    public c(WheelView wheelView, int i) {
        this.dRY = wheelView;
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
            this.dRY.cancelFuture();
            this.dRY.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.dRY.setTotalScrollY(this.dRY.getTotalScrollY() + this.realOffset);
        if (!this.dRY.isLoop()) {
            float itemHeight = this.dRY.getItemHeight();
            float f = (-this.dRY.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.dRY.getItemsCount() - 1) - this.dRY.getInitPosition());
            if (this.dRY.getTotalScrollY() <= f || this.dRY.getTotalScrollY() >= itemsCount) {
                this.dRY.setTotalScrollY(this.dRY.getTotalScrollY() - this.realOffset);
                this.dRY.cancelFuture();
                this.dRY.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.dRY.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
