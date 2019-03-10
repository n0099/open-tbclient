package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {
    private float cGe = 2.1474836E9f;
    private final float cGf;
    private final WheelView cGg;

    public a(WheelView wheelView, float f) {
        this.cGg = wheelView;
        this.cGf = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.cGe == 2.1474836E9f) {
            if (Math.abs(this.cGf) > 2000.0f) {
                this.cGe = this.cGf <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.cGe = this.cGf;
            }
        }
        if (Math.abs(this.cGe) >= 0.0f && Math.abs(this.cGe) <= 20.0f) {
            this.cGg.atS();
            this.cGg.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.cGe / 100.0f);
        this.cGg.setTotalScrollY(this.cGg.getTotalScrollY() - i);
        if (!this.cGg.atU()) {
            float itemHeight = this.cGg.getItemHeight();
            float f = (-this.cGg.getInitPosition()) * itemHeight;
            float itemsCount = ((this.cGg.getItemsCount() - 1) - this.cGg.getInitPosition()) * itemHeight;
            if (this.cGg.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.cGg.getTotalScrollY() + i;
            } else if (this.cGg.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.cGg.getTotalScrollY() + i;
            }
            if (this.cGg.getTotalScrollY() <= f) {
                this.cGe = 40.0f;
                this.cGg.setTotalScrollY((int) f);
            } else if (this.cGg.getTotalScrollY() >= itemsCount) {
                this.cGg.setTotalScrollY((int) itemsCount);
                this.cGe = -40.0f;
            }
        }
        if (this.cGe < 0.0f) {
            this.cGe += 20.0f;
        } else {
            this.cGe -= 20.0f;
        }
        this.cGg.getHandler().sendEmptyMessage(1000);
    }
}
