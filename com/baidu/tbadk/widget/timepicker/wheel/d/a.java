package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {
    private float cZi = 2.1474836E9f;
    private final float cZj;
    private final WheelView cZk;

    public a(WheelView wheelView, float f) {
        this.cZk = wheelView;
        this.cZj = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.cZi == 2.1474836E9f) {
            if (Math.abs(this.cZj) > 2000.0f) {
                this.cZi = this.cZj <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.cZi = this.cZj;
            }
        }
        if (Math.abs(this.cZi) >= 0.0f && Math.abs(this.cZi) <= 20.0f) {
            this.cZk.aAD();
            this.cZk.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.cZi / 100.0f);
        this.cZk.setTotalScrollY(this.cZk.getTotalScrollY() - i);
        if (!this.cZk.aAF()) {
            float itemHeight = this.cZk.getItemHeight();
            float f = (-this.cZk.getInitPosition()) * itemHeight;
            float itemsCount = ((this.cZk.getItemsCount() - 1) - this.cZk.getInitPosition()) * itemHeight;
            if (this.cZk.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.cZk.getTotalScrollY() + i;
            } else if (this.cZk.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.cZk.getTotalScrollY() + i;
            }
            if (this.cZk.getTotalScrollY() <= f) {
                this.cZi = 40.0f;
                this.cZk.setTotalScrollY((int) f);
            } else if (this.cZk.getTotalScrollY() >= itemsCount) {
                this.cZk.setTotalScrollY((int) itemsCount);
                this.cZi = -40.0f;
            }
        }
        if (this.cZi < 0.0f) {
            this.cZi += 20.0f;
        } else {
            this.cZi -= 20.0f;
        }
        this.cZk.getHandler().sendEmptyMessage(1000);
    }
}
