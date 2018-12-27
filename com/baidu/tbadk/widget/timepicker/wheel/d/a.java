package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes.dex */
public final class a extends TimerTask {
    private float bue = 2.1474836E9f;
    private final float bug;
    private final WheelView buh;

    public a(WheelView wheelView, float f) {
        this.buh = wheelView;
        this.bug = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.bue == 2.1474836E9f) {
            if (Math.abs(this.bug) > 2000.0f) {
                this.bue = this.bug <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.bue = this.bug;
            }
        }
        if (Math.abs(this.bue) >= 0.0f && Math.abs(this.bue) <= 20.0f) {
            this.buh.Tw();
            this.buh.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.bue / 100.0f);
        this.buh.setTotalScrollY(this.buh.getTotalScrollY() - i);
        if (!this.buh.Ty()) {
            float itemHeight = this.buh.getItemHeight();
            float f = (-this.buh.getInitPosition()) * itemHeight;
            float itemsCount = ((this.buh.getItemsCount() - 1) - this.buh.getInitPosition()) * itemHeight;
            if (this.buh.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.buh.getTotalScrollY() + i;
            } else if (this.buh.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.buh.getTotalScrollY() + i;
            }
            if (this.buh.getTotalScrollY() <= f) {
                this.bue = 40.0f;
                this.buh.setTotalScrollY((int) f);
            } else if (this.buh.getTotalScrollY() >= itemsCount) {
                this.buh.setTotalScrollY((int) itemsCount);
                this.bue = -40.0f;
            }
        }
        if (this.bue < 0.0f) {
            this.bue += 20.0f;
        } else {
            this.bue -= 20.0f;
        }
        this.buh.getHandler().sendEmptyMessage(1000);
    }
}
