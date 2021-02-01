package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes.dex */
public final class c extends TimerTask {
    private int dAR = Integer.MAX_VALUE;
    private int dAS = 0;
    private final WheelView gaB;
    private int offset;

    public c(WheelView wheelView, int i) {
        this.gaB = wheelView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.dAR == Integer.MAX_VALUE) {
            this.dAR = this.offset;
        }
        this.dAS = (int) (this.dAR * 0.1f);
        if (this.dAS == 0) {
            if (this.dAR < 0) {
                this.dAS = -1;
            } else {
                this.dAS = 1;
            }
        }
        if (Math.abs(this.dAR) <= 1) {
            this.gaB.aHD();
            this.gaB.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.gaB.setTotalScrollY(this.gaB.getTotalScrollY() + this.dAS);
        if (!this.gaB.aHF()) {
            float itemHeight = this.gaB.getItemHeight();
            float f = (-this.gaB.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.gaB.getItemsCount() - 1) - this.gaB.getInitPosition());
            if (this.gaB.getTotalScrollY() <= f || this.gaB.getTotalScrollY() >= itemsCount) {
                this.gaB.setTotalScrollY(this.gaB.getTotalScrollY() - this.dAS);
                this.gaB.aHD();
                this.gaB.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.gaB.getHandler().sendEmptyMessage(1000);
        this.dAR -= this.dAS;
    }
}
