package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes.dex */
public final class c extends TimerTask {
    private final WheelView bua;
    private int bue = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int bug = 0;
    private int offset;

    public c(WheelView wheelView, int i) {
        this.bua = wheelView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.bue == Integer.MAX_VALUE) {
            this.bue = this.offset;
        }
        this.bug = (int) (this.bue * 0.1f);
        if (this.bug == 0) {
            if (this.bue < 0) {
                this.bug = -1;
            } else {
                this.bug = 1;
            }
        }
        if (Math.abs(this.bue) <= 1) {
            this.bua.Tu();
            this.bua.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.bua.setTotalScrollY(this.bua.getTotalScrollY() + this.bug);
        if (!this.bua.Tw()) {
            float itemHeight = this.bua.getItemHeight();
            float f = (-this.bua.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.bua.getItemsCount() - 1) - this.bua.getInitPosition());
            if (this.bua.getTotalScrollY() <= f || this.bua.getTotalScrollY() >= itemsCount) {
                this.bua.setTotalScrollY(this.bua.getTotalScrollY() - this.bug);
                this.bua.Tu();
                this.bua.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.bua.getHandler().sendEmptyMessage(1000);
        this.bue -= this.bug;
    }
}
