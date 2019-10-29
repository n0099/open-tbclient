package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {
    private float cZZ = 2.1474836E9f;
    private final float daa;
    private final WheelView dab;

    public a(WheelView wheelView, float f) {
        this.dab = wheelView;
        this.daa = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.cZZ == 2.1474836E9f) {
            if (Math.abs(this.daa) > 2000.0f) {
                this.cZZ = this.daa <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.cZZ = this.daa;
            }
        }
        if (Math.abs(this.cZZ) >= 0.0f && Math.abs(this.cZZ) <= 20.0f) {
            this.dab.aAF();
            this.dab.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.cZZ / 100.0f);
        this.dab.setTotalScrollY(this.dab.getTotalScrollY() - i);
        if (!this.dab.aAH()) {
            float itemHeight = this.dab.getItemHeight();
            float f = (-this.dab.getInitPosition()) * itemHeight;
            float itemsCount = ((this.dab.getItemsCount() - 1) - this.dab.getInitPosition()) * itemHeight;
            if (this.dab.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.dab.getTotalScrollY() + i;
            } else if (this.dab.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.dab.getTotalScrollY() + i;
            }
            if (this.dab.getTotalScrollY() <= f) {
                this.cZZ = 40.0f;
                this.dab.setTotalScrollY((int) f);
            } else if (this.dab.getTotalScrollY() >= itemsCount) {
                this.dab.setTotalScrollY((int) itemsCount);
                this.cZZ = -40.0f;
            }
        }
        if (this.cZZ < 0.0f) {
            this.cZZ += 20.0f;
        } else {
            this.cZZ -= 20.0f;
        }
        this.dab.getHandler().sendEmptyMessage(1000);
    }
}
