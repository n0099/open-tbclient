package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes6.dex */
public final class c extends TimerTask {
    private final WheelView dNR;
    private int offset;
    private int realTotalOffset = Integer.MAX_VALUE;
    private int realOffset = 0;

    public c(WheelView wheelView, int i) {
        this.dNR = wheelView;
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
            this.dNR.cancelFuture();
            this.dNR.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.dNR.setTotalScrollY(this.dNR.getTotalScrollY() + this.realOffset);
        if (!this.dNR.isLoop()) {
            float itemHeight = this.dNR.getItemHeight();
            float f = (-this.dNR.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.dNR.getItemsCount() - 1) - this.dNR.getInitPosition());
            if (this.dNR.getTotalScrollY() <= f || this.dNR.getTotalScrollY() >= itemsCount) {
                this.dNR.setTotalScrollY(this.dNR.getTotalScrollY() - this.realOffset);
                this.dNR.cancelFuture();
                this.dNR.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.dNR.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
