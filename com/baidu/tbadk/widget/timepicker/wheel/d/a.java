package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {
    private float cPK = 2.1474836E9f;
    private final float cPL;
    private final WheelView cPM;

    public a(WheelView wheelView, float f) {
        this.cPM = wheelView;
        this.cPL = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.cPK == 2.1474836E9f) {
            if (Math.abs(this.cPL) > 2000.0f) {
                this.cPK = this.cPL <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.cPK = this.cPL;
            }
        }
        if (Math.abs(this.cPK) >= 0.0f && Math.abs(this.cPK) <= 20.0f) {
            this.cPM.aAi();
            this.cPM.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.cPK / 100.0f);
        this.cPM.setTotalScrollY(this.cPM.getTotalScrollY() - i);
        if (!this.cPM.aAk()) {
            float itemHeight = this.cPM.getItemHeight();
            float f = (-this.cPM.getInitPosition()) * itemHeight;
            float itemsCount = ((this.cPM.getItemsCount() - 1) - this.cPM.getInitPosition()) * itemHeight;
            if (this.cPM.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.cPM.getTotalScrollY() + i;
            } else if (this.cPM.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.cPM.getTotalScrollY() + i;
            }
            if (this.cPM.getTotalScrollY() <= f) {
                this.cPK = 40.0f;
                this.cPM.setTotalScrollY((int) f);
            } else if (this.cPM.getTotalScrollY() >= itemsCount) {
                this.cPM.setTotalScrollY((int) itemsCount);
                this.cPK = -40.0f;
            }
        }
        if (this.cPK < 0.0f) {
            this.cPK += 20.0f;
        } else {
            this.cPK -= 20.0f;
        }
        this.cPM.getHandler().sendEmptyMessage(1000);
    }
}
