package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes.dex */
public final class c extends TimerTask {
    private final WheelView buT;
    private int buX = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int buY = 0;
    private int offset;

    public c(WheelView wheelView, int i) {
        this.buT = wheelView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.buX == Integer.MAX_VALUE) {
            this.buX = this.offset;
        }
        this.buY = (int) (this.buX * 0.1f);
        if (this.buY == 0) {
            if (this.buX < 0) {
                this.buY = -1;
            } else {
                this.buY = 1;
            }
        }
        if (Math.abs(this.buX) <= 1) {
            this.buT.TS();
            this.buT.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.buT.setTotalScrollY(this.buT.getTotalScrollY() + this.buY);
        if (!this.buT.TU()) {
            float itemHeight = this.buT.getItemHeight();
            float f = (-this.buT.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.buT.getItemsCount() - 1) - this.buT.getInitPosition());
            if (this.buT.getTotalScrollY() <= f || this.buT.getTotalScrollY() >= itemsCount) {
                this.buT.setTotalScrollY(this.buT.getTotalScrollY() - this.buY);
                this.buT.TS();
                this.buT.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.buT.getHandler().sendEmptyMessage(1000);
        this.buX -= this.buY;
    }
}
