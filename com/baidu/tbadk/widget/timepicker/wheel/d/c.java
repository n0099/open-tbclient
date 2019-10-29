package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class c extends TimerTask {
    private final WheelView cZY;
    private int dac = Integer.MAX_VALUE;
    private int dad = 0;
    private int offset;

    public c(WheelView wheelView, int i) {
        this.cZY = wheelView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.dac == Integer.MAX_VALUE) {
            this.dac = this.offset;
        }
        this.dad = (int) (this.dac * 0.1f);
        if (this.dad == 0) {
            if (this.dac < 0) {
                this.dad = -1;
            } else {
                this.dad = 1;
            }
        }
        if (Math.abs(this.dac) <= 1) {
            this.cZY.aAF();
            this.cZY.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.cZY.setTotalScrollY(this.cZY.getTotalScrollY() + this.dad);
        if (!this.cZY.aAH()) {
            float itemHeight = this.cZY.getItemHeight();
            float f = (-this.cZY.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.cZY.getItemsCount() - 1) - this.cZY.getInitPosition());
            if (this.cZY.getTotalScrollY() <= f || this.cZY.getTotalScrollY() >= itemsCount) {
                this.cZY.setTotalScrollY(this.cZY.getTotalScrollY() - this.dad);
                this.cZY.aAF();
                this.cZY.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.cZY.getHandler().sendEmptyMessage(1000);
        this.dac -= this.dad;
    }
}
