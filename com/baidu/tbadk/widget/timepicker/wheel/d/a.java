package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {
    private float cOn = 2.1474836E9f;
    private final float cOo;
    private final WheelView cOp;

    public a(WheelView wheelView, float f) {
        this.cOp = wheelView;
        this.cOo = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.cOn == 2.1474836E9f) {
            if (Math.abs(this.cOo) > 2000.0f) {
                this.cOn = this.cOo <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.cOn = this.cOo;
            }
        }
        if (Math.abs(this.cOn) >= 0.0f && Math.abs(this.cOn) <= 20.0f) {
            this.cOp.ayT();
            this.cOp.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.cOn / 100.0f);
        this.cOp.setTotalScrollY(this.cOp.getTotalScrollY() - i);
        if (!this.cOp.ayV()) {
            float itemHeight = this.cOp.getItemHeight();
            float f = (-this.cOp.getInitPosition()) * itemHeight;
            float itemsCount = ((this.cOp.getItemsCount() - 1) - this.cOp.getInitPosition()) * itemHeight;
            if (this.cOp.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.cOp.getTotalScrollY() + i;
            } else if (this.cOp.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.cOp.getTotalScrollY() + i;
            }
            if (this.cOp.getTotalScrollY() <= f) {
                this.cOn = 40.0f;
                this.cOp.setTotalScrollY((int) f);
            } else if (this.cOp.getTotalScrollY() >= itemsCount) {
                this.cOp.setTotalScrollY((int) itemsCount);
                this.cOn = -40.0f;
            }
        }
        if (this.cOn < 0.0f) {
            this.cOn += 20.0f;
        } else {
            this.cOn -= 20.0f;
        }
        this.cOp.getHandler().sendEmptyMessage(1000);
    }
}
