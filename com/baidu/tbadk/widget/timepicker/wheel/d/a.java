package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes.dex */
public final class a extends TimerTask {
    private float dCp = 2.1474836E9f;
    private final float dCq;
    private final WheelView gcc;

    public a(WheelView wheelView, float f) {
        this.gcc = wheelView;
        this.dCq = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.dCp == 2.1474836E9f) {
            if (Math.abs(this.dCq) > 2000.0f) {
                this.dCp = this.dCq <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.dCp = this.dCq;
            }
        }
        if (Math.abs(this.dCp) >= 0.0f && Math.abs(this.dCp) <= 20.0f) {
            this.gcc.aHG();
            this.gcc.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.dCp / 100.0f);
        this.gcc.setTotalScrollY(this.gcc.getTotalScrollY() - i);
        if (!this.gcc.aHI()) {
            float itemHeight = this.gcc.getItemHeight();
            float f = (-this.gcc.getInitPosition()) * itemHeight;
            float itemsCount = ((this.gcc.getItemsCount() - 1) - this.gcc.getInitPosition()) * itemHeight;
            if (this.gcc.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.gcc.getTotalScrollY() + i;
            } else if (this.gcc.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.gcc.getTotalScrollY() + i;
            }
            if (this.gcc.getTotalScrollY() <= f) {
                this.dCp = 40.0f;
                this.gcc.setTotalScrollY((int) f);
            } else if (this.gcc.getTotalScrollY() >= itemsCount) {
                this.gcc.setTotalScrollY((int) itemsCount);
                this.dCp = -40.0f;
            }
        }
        if (this.dCp < 0.0f) {
            this.dCp += 20.0f;
        } else {
            this.dCp -= 20.0f;
        }
        this.gcc.getHandler().sendEmptyMessage(1000);
    }
}
