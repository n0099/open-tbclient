package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes.dex */
public final class a extends TimerTask {
    private float bub = 2.1474836E9f;
    private final float buc;
    private final WheelView bud;

    public a(WheelView wheelView, float f) {
        this.bud = wheelView;
        this.buc = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.bub == 2.1474836E9f) {
            if (Math.abs(this.buc) > 2000.0f) {
                this.bub = this.buc <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.bub = this.buc;
            }
        }
        if (Math.abs(this.bub) >= 0.0f && Math.abs(this.bub) <= 20.0f) {
            this.bud.Tu();
            this.bud.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.bub / 100.0f);
        this.bud.setTotalScrollY(this.bud.getTotalScrollY() - i);
        if (!this.bud.Tw()) {
            float itemHeight = this.bud.getItemHeight();
            float f = (-this.bud.getInitPosition()) * itemHeight;
            float itemsCount = ((this.bud.getItemsCount() - 1) - this.bud.getInitPosition()) * itemHeight;
            if (this.bud.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.bud.getTotalScrollY() + i;
            } else if (this.bud.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.bud.getTotalScrollY() + i;
            }
            if (this.bud.getTotalScrollY() <= f) {
                this.bub = 40.0f;
                this.bud.setTotalScrollY((int) f);
            } else if (this.bud.getTotalScrollY() >= itemsCount) {
                this.bud.setTotalScrollY((int) itemsCount);
                this.bub = -40.0f;
            }
        }
        if (this.bub < 0.0f) {
            this.bub += 20.0f;
        } else {
            this.bub -= 20.0f;
        }
        this.bud.getHandler().sendEmptyMessage(1000);
    }
}
