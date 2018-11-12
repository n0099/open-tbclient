package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes.dex */
public final class c extends TimerTask {
    private final WheelView bqC;
    private int bqG = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int bqH = 0;
    private int offset;

    public c(WheelView wheelView, int i) {
        this.bqC = wheelView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.bqG == Integer.MAX_VALUE) {
            this.bqG = this.offset;
        }
        this.bqH = (int) (this.bqG * 0.1f);
        if (this.bqH == 0) {
            if (this.bqG < 0) {
                this.bqH = -1;
            } else {
                this.bqH = 1;
            }
        }
        if (Math.abs(this.bqG) <= 1) {
            this.bqC.So();
            this.bqC.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.bqC.setTotalScrollY(this.bqC.getTotalScrollY() + this.bqH);
        if (!this.bqC.Sq()) {
            float itemHeight = this.bqC.getItemHeight();
            float f = (-this.bqC.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.bqC.getItemsCount() - 1) - this.bqC.getInitPosition());
            if (this.bqC.getTotalScrollY() <= f || this.bqC.getTotalScrollY() >= itemsCount) {
                this.bqC.setTotalScrollY(this.bqC.getTotalScrollY() - this.bqH);
                this.bqC.So();
                this.bqC.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.bqC.getHandler().sendEmptyMessage(1000);
        this.bqG -= this.bqH;
    }
}
