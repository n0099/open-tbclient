package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes.dex */
public final class a extends TimerTask {
    private float dDv = 2.1474836E9f;
    private final float dDw;
    private final WheelView gcU;

    public a(WheelView wheelView, float f) {
        this.gcU = wheelView;
        this.dDw = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.dDv == 2.1474836E9f) {
            if (Math.abs(this.dDw) > 2000.0f) {
                this.dDv = this.dDw <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.dDv = this.dDw;
            }
        }
        if (Math.abs(this.dDv) >= 0.0f && Math.abs(this.dDv) <= 20.0f) {
            this.gcU.aLd();
            this.gcU.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.dDv / 100.0f);
        this.gcU.setTotalScrollY(this.gcU.getTotalScrollY() - i);
        if (!this.gcU.aLf()) {
            float itemHeight = this.gcU.getItemHeight();
            float f = (-this.gcU.getInitPosition()) * itemHeight;
            float itemsCount = ((this.gcU.getItemsCount() - 1) - this.gcU.getInitPosition()) * itemHeight;
            if (this.gcU.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.gcU.getTotalScrollY() + i;
            } else if (this.gcU.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.gcU.getTotalScrollY() + i;
            }
            if (this.gcU.getTotalScrollY() <= f) {
                this.dDv = 40.0f;
                this.gcU.setTotalScrollY((int) f);
            } else if (this.gcU.getTotalScrollY() >= itemsCount) {
                this.gcU.setTotalScrollY((int) itemsCount);
                this.dDv = -40.0f;
            }
        }
        if (this.dDv < 0.0f) {
            this.dDv += 20.0f;
        } else {
            this.dDv -= 20.0f;
        }
        this.gcU.getHandler().sendEmptyMessage(1000);
    }
}
