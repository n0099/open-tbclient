package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes.dex */
public final class a extends TimerTask {
    private float bqD = 2.1474836E9f;
    private final float bqE;
    private final WheelView bqF;

    public a(WheelView wheelView, float f) {
        this.bqF = wheelView;
        this.bqE = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.bqD == 2.1474836E9f) {
            if (Math.abs(this.bqE) > 2000.0f) {
                this.bqD = this.bqE <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.bqD = this.bqE;
            }
        }
        if (Math.abs(this.bqD) >= 0.0f && Math.abs(this.bqD) <= 20.0f) {
            this.bqF.So();
            this.bqF.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.bqD / 100.0f);
        this.bqF.setTotalScrollY(this.bqF.getTotalScrollY() - i);
        if (!this.bqF.Sq()) {
            float itemHeight = this.bqF.getItemHeight();
            float f = (-this.bqF.getInitPosition()) * itemHeight;
            float itemsCount = ((this.bqF.getItemsCount() - 1) - this.bqF.getInitPosition()) * itemHeight;
            if (this.bqF.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.bqF.getTotalScrollY() + i;
            } else if (this.bqF.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.bqF.getTotalScrollY() + i;
            }
            if (this.bqF.getTotalScrollY() <= f) {
                this.bqD = 40.0f;
                this.bqF.setTotalScrollY((int) f);
            } else if (this.bqF.getTotalScrollY() >= itemsCount) {
                this.bqF.setTotalScrollY((int) itemsCount);
                this.bqD = -40.0f;
            }
        }
        if (this.bqD < 0.0f) {
            this.bqD += 20.0f;
        } else {
            this.bqD -= 20.0f;
        }
        this.bqF.getHandler().sendEmptyMessage(1000);
    }
}
