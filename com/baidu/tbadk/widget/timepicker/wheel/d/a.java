package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {
    private float cGb = 2.1474836E9f;
    private final float cGc;
    private final WheelView cGd;

    public a(WheelView wheelView, float f) {
        this.cGd = wheelView;
        this.cGc = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.cGb == 2.1474836E9f) {
            if (Math.abs(this.cGc) > 2000.0f) {
                this.cGb = this.cGc <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.cGb = this.cGc;
            }
        }
        if (Math.abs(this.cGb) >= 0.0f && Math.abs(this.cGb) <= 20.0f) {
            this.cGd.atR();
            this.cGd.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.cGb / 100.0f);
        this.cGd.setTotalScrollY(this.cGd.getTotalScrollY() - i);
        if (!this.cGd.atT()) {
            float itemHeight = this.cGd.getItemHeight();
            float f = (-this.cGd.getInitPosition()) * itemHeight;
            float itemsCount = ((this.cGd.getItemsCount() - 1) - this.cGd.getInitPosition()) * itemHeight;
            if (this.cGd.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.cGd.getTotalScrollY() + i;
            } else if (this.cGd.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.cGd.getTotalScrollY() + i;
            }
            if (this.cGd.getTotalScrollY() <= f) {
                this.cGb = 40.0f;
                this.cGd.setTotalScrollY((int) f);
            } else if (this.cGd.getTotalScrollY() >= itemsCount) {
                this.cGd.setTotalScrollY((int) itemsCount);
                this.cGb = -40.0f;
            }
        }
        if (this.cGb < 0.0f) {
            this.cGb += 20.0f;
        } else {
            this.cGb -= 20.0f;
        }
        this.cGd.getHandler().sendEmptyMessage(1000);
    }
}
