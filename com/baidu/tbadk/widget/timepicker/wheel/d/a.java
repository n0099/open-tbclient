package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {
    private float cOo = 2.1474836E9f;
    private final float cOp;
    private final WheelView cOq;

    public a(WheelView wheelView, float f) {
        this.cOq = wheelView;
        this.cOp = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.cOo == 2.1474836E9f) {
            if (Math.abs(this.cOp) > 2000.0f) {
                this.cOo = this.cOp <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.cOo = this.cOp;
            }
        }
        if (Math.abs(this.cOo) >= 0.0f && Math.abs(this.cOo) <= 20.0f) {
            this.cOq.ayU();
            this.cOq.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.cOo / 100.0f);
        this.cOq.setTotalScrollY(this.cOq.getTotalScrollY() - i);
        if (!this.cOq.ayW()) {
            float itemHeight = this.cOq.getItemHeight();
            float f = (-this.cOq.getInitPosition()) * itemHeight;
            float itemsCount = ((this.cOq.getItemsCount() - 1) - this.cOq.getInitPosition()) * itemHeight;
            if (this.cOq.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.cOq.getTotalScrollY() + i;
            } else if (this.cOq.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.cOq.getTotalScrollY() + i;
            }
            if (this.cOq.getTotalScrollY() <= f) {
                this.cOo = 40.0f;
                this.cOq.setTotalScrollY((int) f);
            } else if (this.cOq.getTotalScrollY() >= itemsCount) {
                this.cOq.setTotalScrollY((int) itemsCount);
                this.cOo = -40.0f;
            }
        }
        if (this.cOo < 0.0f) {
            this.cOo += 20.0f;
        } else {
            this.cOo -= 20.0f;
        }
        this.cOq.getHandler().sendEmptyMessage(1000);
    }
}
