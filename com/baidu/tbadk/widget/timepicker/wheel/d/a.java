package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes.dex */
public final class a extends TimerTask {
    private float buU = 2.1474836E9f;
    private final float buV;
    private final WheelView buW;

    public a(WheelView wheelView, float f) {
        this.buW = wheelView;
        this.buV = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.buU == 2.1474836E9f) {
            if (Math.abs(this.buV) > 2000.0f) {
                this.buU = this.buV <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.buU = this.buV;
            }
        }
        if (Math.abs(this.buU) >= 0.0f && Math.abs(this.buU) <= 20.0f) {
            this.buW.TS();
            this.buW.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.buU / 100.0f);
        this.buW.setTotalScrollY(this.buW.getTotalScrollY() - i);
        if (!this.buW.TU()) {
            float itemHeight = this.buW.getItemHeight();
            float f = (-this.buW.getInitPosition()) * itemHeight;
            float itemsCount = ((this.buW.getItemsCount() - 1) - this.buW.getInitPosition()) * itemHeight;
            if (this.buW.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.buW.getTotalScrollY() + i;
            } else if (this.buW.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.buW.getTotalScrollY() + i;
            }
            if (this.buW.getTotalScrollY() <= f) {
                this.buU = 40.0f;
                this.buW.setTotalScrollY((int) f);
            } else if (this.buW.getTotalScrollY() >= itemsCount) {
                this.buW.setTotalScrollY((int) itemsCount);
                this.buU = -40.0f;
            }
        }
        if (this.buU < 0.0f) {
            this.buU += 20.0f;
        } else {
            this.buU -= 20.0f;
        }
        this.buW.getHandler().sendEmptyMessage(1000);
    }
}
