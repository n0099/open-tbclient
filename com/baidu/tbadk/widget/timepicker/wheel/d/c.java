package com.baidu.tbadk.widget.timepicker.wheel.d;

import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes.dex */
public final class c extends TimerTask {
    private int dyM = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int dyN = 0;
    private final WheelView fYk;
    private int offset;

    public c(WheelView wheelView, int i) {
        this.fYk = wheelView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.dyM == Integer.MAX_VALUE) {
            this.dyM = this.offset;
        }
        this.dyN = (int) (this.dyM * 0.1f);
        if (this.dyN == 0) {
            if (this.dyM < 0) {
                this.dyN = -1;
            } else {
                this.dyN = 1;
            }
        }
        if (Math.abs(this.dyM) <= 1) {
            this.fYk.aHk();
            this.fYk.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.fYk.setTotalScrollY(this.fYk.getTotalScrollY() + this.dyN);
        if (!this.fYk.aHm()) {
            float itemHeight = this.fYk.getItemHeight();
            float f = (-this.fYk.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.fYk.getItemsCount() - 1) - this.fYk.getInitPosition());
            if (this.fYk.getTotalScrollY() <= f || this.fYk.getTotalScrollY() >= itemsCount) {
                this.fYk.setTotalScrollY(this.fYk.getTotalScrollY() - this.dyN);
                this.fYk.aHk();
                this.fYk.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.fYk.getHandler().sendEmptyMessage(1000);
        this.dyM -= this.dyN;
    }
}
