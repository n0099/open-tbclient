package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes.dex */
public final class a extends TimerTask {
    private float blP = 2.1474836E9f;
    private final float blQ;
    private final WheelView blR;

    public a(WheelView wheelView, float f) {
        this.blR = wheelView;
        this.blQ = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.blP == 2.1474836E9f) {
            if (Math.abs(this.blQ) > 2000.0f) {
                this.blP = this.blQ <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.blP = this.blQ;
            }
        }
        if (Math.abs(this.blP) >= 0.0f && Math.abs(this.blP) <= 20.0f) {
            this.blR.Ql();
            this.blR.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.blP / 100.0f);
        this.blR.setTotalScrollY(this.blR.getTotalScrollY() - i);
        if (!this.blR.Qn()) {
            float itemHeight = this.blR.getItemHeight();
            float f = (-this.blR.getInitPosition()) * itemHeight;
            float itemsCount = ((this.blR.getItemsCount() - 1) - this.blR.getInitPosition()) * itemHeight;
            if (this.blR.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.blR.getTotalScrollY() + i;
            } else if (this.blR.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.blR.getTotalScrollY() + i;
            }
            if (this.blR.getTotalScrollY() <= f) {
                this.blP = 40.0f;
                this.blR.setTotalScrollY((int) f);
            } else if (this.blR.getTotalScrollY() >= itemsCount) {
                this.blR.setTotalScrollY((int) itemsCount);
                this.blP = -40.0f;
            }
        }
        if (this.blP < 0.0f) {
            this.blP += 20.0f;
        } else {
            this.blP -= 20.0f;
        }
        this.blR.getHandler().sendEmptyMessage(1000);
    }
}
