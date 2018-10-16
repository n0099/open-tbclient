package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes.dex */
public final class a extends TimerTask {
    private float bpR = 2.1474836E9f;
    private final float bpS;
    private final WheelView bpT;

    public a(WheelView wheelView, float f) {
        this.bpT = wheelView;
        this.bpS = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.bpR == 2.1474836E9f) {
            if (Math.abs(this.bpS) > 2000.0f) {
                this.bpR = this.bpS <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.bpR = this.bpS;
            }
        }
        if (Math.abs(this.bpR) >= 0.0f && Math.abs(this.bpR) <= 20.0f) {
            this.bpT.Sf();
            this.bpT.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.bpR / 100.0f);
        this.bpT.setTotalScrollY(this.bpT.getTotalScrollY() - i);
        if (!this.bpT.Sh()) {
            float itemHeight = this.bpT.getItemHeight();
            float f = (-this.bpT.getInitPosition()) * itemHeight;
            float itemsCount = ((this.bpT.getItemsCount() - 1) - this.bpT.getInitPosition()) * itemHeight;
            if (this.bpT.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.bpT.getTotalScrollY() + i;
            } else if (this.bpT.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.bpT.getTotalScrollY() + i;
            }
            if (this.bpT.getTotalScrollY() <= f) {
                this.bpR = 40.0f;
                this.bpT.setTotalScrollY((int) f);
            } else if (this.bpT.getTotalScrollY() >= itemsCount) {
                this.bpT.setTotalScrollY((int) itemsCount);
                this.bpR = -40.0f;
            }
        }
        if (this.bpR < 0.0f) {
            this.bpR += 20.0f;
        } else {
            this.bpR -= 20.0f;
        }
        this.bpT.getHandler().sendEmptyMessage(1000);
    }
}
