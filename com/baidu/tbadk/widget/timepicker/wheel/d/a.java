package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes.dex */
public final class a extends TimerTask {
    private float dAO = 2.1474836E9f;
    private final float dAP;
    private final WheelView gaC;

    public a(WheelView wheelView, float f) {
        this.gaC = wheelView;
        this.dAP = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.dAO == 2.1474836E9f) {
            if (Math.abs(this.dAP) > 2000.0f) {
                this.dAO = this.dAP <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.dAO = this.dAP;
            }
        }
        if (Math.abs(this.dAO) >= 0.0f && Math.abs(this.dAO) <= 20.0f) {
            this.gaC.aHD();
            this.gaC.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.dAO / 100.0f);
        this.gaC.setTotalScrollY(this.gaC.getTotalScrollY() - i);
        if (!this.gaC.aHF()) {
            float itemHeight = this.gaC.getItemHeight();
            float f = (-this.gaC.getInitPosition()) * itemHeight;
            float itemsCount = ((this.gaC.getItemsCount() - 1) - this.gaC.getInitPosition()) * itemHeight;
            if (this.gaC.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.gaC.getTotalScrollY() + i;
            } else if (this.gaC.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.gaC.getTotalScrollY() + i;
            }
            if (this.gaC.getTotalScrollY() <= f) {
                this.dAO = 40.0f;
                this.gaC.setTotalScrollY((int) f);
            } else if (this.gaC.getTotalScrollY() >= itemsCount) {
                this.gaC.setTotalScrollY((int) itemsCount);
                this.dAO = -40.0f;
            }
        }
        if (this.dAO < 0.0f) {
            this.dAO += 20.0f;
        } else {
            this.dAO -= 20.0f;
        }
        this.gaC.getHandler().sendEmptyMessage(1000);
    }
}
