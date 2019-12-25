package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes5.dex */
public final class c extends TimerTask {
    private final WheelView dNJ;
    private int offset;
    private int realTotalOffset = Integer.MAX_VALUE;
    private int realOffset = 0;

    public c(WheelView wheelView, int i) {
        this.dNJ = wheelView;
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
            this.dNJ.cancelFuture();
            this.dNJ.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.dNJ.setTotalScrollY(this.dNJ.getTotalScrollY() + this.realOffset);
        if (!this.dNJ.isLoop()) {
            float itemHeight = this.dNJ.getItemHeight();
            float f = (-this.dNJ.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.dNJ.getItemsCount() - 1) - this.dNJ.getInitPosition());
            if (this.dNJ.getTotalScrollY() <= f || this.dNJ.getTotalScrollY() >= itemsCount) {
                this.dNJ.setTotalScrollY(this.dNJ.getTotalScrollY() - this.realOffset);
                this.dNJ.cancelFuture();
                this.dNJ.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.dNJ.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
