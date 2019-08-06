package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class a extends TimerTask {
    private float cPR = 2.1474836E9f;
    private final float cPS;
    private final WheelView cPT;

    public a(WheelView wheelView, float f) {
        this.cPT = wheelView;
        this.cPS = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.cPR == 2.1474836E9f) {
            if (Math.abs(this.cPS) > 2000.0f) {
                this.cPR = this.cPS <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.cPR = this.cPS;
            }
        }
        if (Math.abs(this.cPR) >= 0.0f && Math.abs(this.cPR) <= 20.0f) {
            this.cPT.aAk();
            this.cPT.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.cPR / 100.0f);
        this.cPT.setTotalScrollY(this.cPT.getTotalScrollY() - i);
        if (!this.cPT.aAm()) {
            float itemHeight = this.cPT.getItemHeight();
            float f = (-this.cPT.getInitPosition()) * itemHeight;
            float itemsCount = ((this.cPT.getItemsCount() - 1) - this.cPT.getInitPosition()) * itemHeight;
            if (this.cPT.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.cPT.getTotalScrollY() + i;
            } else if (this.cPT.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.cPT.getTotalScrollY() + i;
            }
            if (this.cPT.getTotalScrollY() <= f) {
                this.cPR = 40.0f;
                this.cPT.setTotalScrollY((int) f);
            } else if (this.cPT.getTotalScrollY() >= itemsCount) {
                this.cPT.setTotalScrollY((int) itemsCount);
                this.cPR = -40.0f;
            }
        }
        if (this.cPR < 0.0f) {
            this.cPR += 20.0f;
        } else {
            this.cPR -= 20.0f;
        }
        this.cPT.getHandler().sendEmptyMessage(1000);
    }
}
