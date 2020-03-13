package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class c extends TimerTask {
    private final WheelView dSl;
    private int offset;
    private int realTotalOffset = Integer.MAX_VALUE;
    private int realOffset = 0;

    public c(WheelView wheelView, int i) {
        this.dSl = wheelView;
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
            this.dSl.cancelFuture();
            this.dSl.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.dSl.setTotalScrollY(this.dSl.getTotalScrollY() + this.realOffset);
        if (!this.dSl.isLoop()) {
            float itemHeight = this.dSl.getItemHeight();
            float f = (-this.dSl.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.dSl.getItemsCount() - 1) - this.dSl.getInitPosition());
            if (this.dSl.getTotalScrollY() <= f || this.dSl.getTotalScrollY() >= itemsCount) {
                this.dSl.setTotalScrollY(this.dSl.getTotalScrollY() - this.realOffset);
                this.dSl.cancelFuture();
                this.dSl.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.dSl.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
