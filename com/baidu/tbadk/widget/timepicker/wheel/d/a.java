package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes.dex */
public final class a extends TimerTask {
    private float buT = 2.1474836E9f;
    private final float buU;
    private final WheelView buV;

    public a(WheelView wheelView, float f) {
        this.buV = wheelView;
        this.buU = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.buT == 2.1474836E9f) {
            if (Math.abs(this.buU) > 2000.0f) {
                this.buT = this.buU <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.buT = this.buU;
            }
        }
        if (Math.abs(this.buT) >= 0.0f && Math.abs(this.buT) <= 20.0f) {
            this.buV.TS();
            this.buV.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.buT / 100.0f);
        this.buV.setTotalScrollY(this.buV.getTotalScrollY() - i);
        if (!this.buV.TU()) {
            float itemHeight = this.buV.getItemHeight();
            float f = (-this.buV.getInitPosition()) * itemHeight;
            float itemsCount = ((this.buV.getItemsCount() - 1) - this.buV.getInitPosition()) * itemHeight;
            if (this.buV.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.buV.getTotalScrollY() + i;
            } else if (this.buV.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.buV.getTotalScrollY() + i;
            }
            if (this.buV.getTotalScrollY() <= f) {
                this.buT = 40.0f;
                this.buV.setTotalScrollY((int) f);
            } else if (this.buV.getTotalScrollY() >= itemsCount) {
                this.buV.setTotalScrollY((int) itemsCount);
                this.buT = -40.0f;
            }
        }
        if (this.buT < 0.0f) {
            this.buT += 20.0f;
        } else {
            this.buT -= 20.0f;
        }
        this.buV.getHandler().sendEmptyMessage(1000);
    }
}
