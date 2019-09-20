package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {
    private float cQH = 2.1474836E9f;
    private final float cQI;
    private final WheelView cQJ;

    public a(WheelView wheelView, float f) {
        this.cQJ = wheelView;
        this.cQI = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.cQH == 2.1474836E9f) {
            if (Math.abs(this.cQI) > 2000.0f) {
                this.cQH = this.cQI <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.cQH = this.cQI;
            }
        }
        if (Math.abs(this.cQH) >= 0.0f && Math.abs(this.cQH) <= 20.0f) {
            this.cQJ.aAw();
            this.cQJ.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.cQH / 100.0f);
        this.cQJ.setTotalScrollY(this.cQJ.getTotalScrollY() - i);
        if (!this.cQJ.aAy()) {
            float itemHeight = this.cQJ.getItemHeight();
            float f = (-this.cQJ.getInitPosition()) * itemHeight;
            float itemsCount = ((this.cQJ.getItemsCount() - 1) - this.cQJ.getInitPosition()) * itemHeight;
            if (this.cQJ.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.cQJ.getTotalScrollY() + i;
            } else if (this.cQJ.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.cQJ.getTotalScrollY() + i;
            }
            if (this.cQJ.getTotalScrollY() <= f) {
                this.cQH = 40.0f;
                this.cQJ.setTotalScrollY((int) f);
            } else if (this.cQJ.getTotalScrollY() >= itemsCount) {
                this.cQJ.setTotalScrollY((int) itemsCount);
                this.cQH = -40.0f;
            }
        }
        if (this.cQH < 0.0f) {
            this.cQH += 20.0f;
        } else {
            this.cQH -= 20.0f;
        }
        this.cQJ.getHandler().sendEmptyMessage(1000);
    }
}
