package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes.dex */
public final class c extends TimerTask {
    private final WheelView buS;
    private int buW = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int buX = 0;
    private int offset;

    public c(WheelView wheelView, int i) {
        this.buS = wheelView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.buW == Integer.MAX_VALUE) {
            this.buW = this.offset;
        }
        this.buX = (int) (this.buW * 0.1f);
        if (this.buX == 0) {
            if (this.buW < 0) {
                this.buX = -1;
            } else {
                this.buX = 1;
            }
        }
        if (Math.abs(this.buW) <= 1) {
            this.buS.TS();
            this.buS.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.buS.setTotalScrollY(this.buS.getTotalScrollY() + this.buX);
        if (!this.buS.TU()) {
            float itemHeight = this.buS.getItemHeight();
            float f = (-this.buS.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.buS.getItemsCount() - 1) - this.buS.getInitPosition());
            if (this.buS.getTotalScrollY() <= f || this.buS.getTotalScrollY() >= itemsCount) {
                this.buS.setTotalScrollY(this.buS.getTotalScrollY() - this.buX);
                this.buS.TS();
                this.buS.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.buS.getHandler().sendEmptyMessage(1000);
        this.buW -= this.buX;
    }
}
