package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class c extends TimerTask {
    private final WheelView dRX;
    private int offset;
    private int realTotalOffset = Integer.MAX_VALUE;
    private int realOffset = 0;

    public c(WheelView wheelView, int i) {
        this.dRX = wheelView;
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
            this.dRX.cancelFuture();
            this.dRX.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.dRX.setTotalScrollY(this.dRX.getTotalScrollY() + this.realOffset);
        if (!this.dRX.isLoop()) {
            float itemHeight = this.dRX.getItemHeight();
            float f = (-this.dRX.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.dRX.getItemsCount() - 1) - this.dRX.getInitPosition());
            if (this.dRX.getTotalScrollY() <= f || this.dRX.getTotalScrollY() >= itemsCount) {
                this.dRX.setTotalScrollY(this.dRX.getTotalScrollY() - this.realOffset);
                this.dRX.cancelFuture();
                this.dRX.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.dRX.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
