package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes.dex */
public final class a extends TimerTask {
    private float dyJ = 2.1474836E9f;
    private final float dyK;
    private final WheelView fYl;

    public a(WheelView wheelView, float f) {
        this.fYl = wheelView;
        this.dyK = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.dyJ == 2.1474836E9f) {
            if (Math.abs(this.dyK) > 2000.0f) {
                this.dyJ = this.dyK <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.dyJ = this.dyK;
            }
        }
        if (Math.abs(this.dyJ) >= 0.0f && Math.abs(this.dyJ) <= 20.0f) {
            this.fYl.aHk();
            this.fYl.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.dyJ / 100.0f);
        this.fYl.setTotalScrollY(this.fYl.getTotalScrollY() - i);
        if (!this.fYl.aHm()) {
            float itemHeight = this.fYl.getItemHeight();
            float f = (-this.fYl.getInitPosition()) * itemHeight;
            float itemsCount = ((this.fYl.getItemsCount() - 1) - this.fYl.getInitPosition()) * itemHeight;
            if (this.fYl.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.fYl.getTotalScrollY() + i;
            } else if (this.fYl.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.fYl.getTotalScrollY() + i;
            }
            if (this.fYl.getTotalScrollY() <= f) {
                this.dyJ = 40.0f;
                this.fYl.setTotalScrollY((int) f);
            } else if (this.fYl.getTotalScrollY() >= itemsCount) {
                this.fYl.setTotalScrollY((int) itemsCount);
                this.dyJ = -40.0f;
            }
        }
        if (this.dyJ < 0.0f) {
            this.dyJ += 20.0f;
        } else {
            this.dyJ -= 20.0f;
        }
        this.fYl.getHandler().sendEmptyMessage(1000);
    }
}
