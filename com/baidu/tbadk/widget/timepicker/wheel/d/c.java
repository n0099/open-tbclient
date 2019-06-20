package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class c extends TimerTask {
    private final WheelView cOn;
    private int cOr = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int cOs = 0;
    private int offset;

    public c(WheelView wheelView, int i) {
        this.cOn = wheelView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.cOr == Integer.MAX_VALUE) {
            this.cOr = this.offset;
        }
        this.cOs = (int) (this.cOr * 0.1f);
        if (this.cOs == 0) {
            if (this.cOr < 0) {
                this.cOs = -1;
            } else {
                this.cOs = 1;
            }
        }
        if (Math.abs(this.cOr) <= 1) {
            this.cOn.ayU();
            this.cOn.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.cOn.setTotalScrollY(this.cOn.getTotalScrollY() + this.cOs);
        if (!this.cOn.ayW()) {
            float itemHeight = this.cOn.getItemHeight();
            float f = (-this.cOn.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.cOn.getItemsCount() - 1) - this.cOn.getInitPosition());
            if (this.cOn.getTotalScrollY() <= f || this.cOn.getTotalScrollY() >= itemsCount) {
                this.cOn.setTotalScrollY(this.cOn.getTotalScrollY() - this.cOs);
                this.cOn.ayU();
                this.cOn.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.cOn.getHandler().sendEmptyMessage(1000);
        this.cOr -= this.cOs;
    }
}
