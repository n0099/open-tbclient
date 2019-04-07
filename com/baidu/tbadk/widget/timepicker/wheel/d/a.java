package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {
    private float cGd = 2.1474836E9f;
    private final float cGe;
    private final WheelView cGf;

    public a(WheelView wheelView, float f) {
        this.cGf = wheelView;
        this.cGe = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.cGd == 2.1474836E9f) {
            if (Math.abs(this.cGe) > 2000.0f) {
                this.cGd = this.cGe <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.cGd = this.cGe;
            }
        }
        if (Math.abs(this.cGd) >= 0.0f && Math.abs(this.cGd) <= 20.0f) {
            this.cGf.atO();
            this.cGf.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.cGd / 100.0f);
        this.cGf.setTotalScrollY(this.cGf.getTotalScrollY() - i);
        if (!this.cGf.atQ()) {
            float itemHeight = this.cGf.getItemHeight();
            float f = (-this.cGf.getInitPosition()) * itemHeight;
            float itemsCount = ((this.cGf.getItemsCount() - 1) - this.cGf.getInitPosition()) * itemHeight;
            if (this.cGf.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.cGf.getTotalScrollY() + i;
            } else if (this.cGf.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.cGf.getTotalScrollY() + i;
            }
            if (this.cGf.getTotalScrollY() <= f) {
                this.cGd = 40.0f;
                this.cGf.setTotalScrollY((int) f);
            } else if (this.cGf.getTotalScrollY() >= itemsCount) {
                this.cGf.setTotalScrollY((int) itemsCount);
                this.cGd = -40.0f;
            }
        }
        if (this.cGd < 0.0f) {
            this.cGd += 20.0f;
        } else {
            this.cGd -= 20.0f;
        }
        this.cGf.getHandler().sendEmptyMessage(1000);
    }
}
