package com.baidu.tbadk.widget.timepicker.wheel.d;

import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes.dex */
public final class c extends TimerTask {
    private int dDy = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int dDz = 0;
    private final WheelView gcT;
    private int offset;

    public c(WheelView wheelView, int i) {
        this.gcT = wheelView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.dDy == Integer.MAX_VALUE) {
            this.dDy = this.offset;
        }
        this.dDz = (int) (this.dDy * 0.1f);
        if (this.dDz == 0) {
            if (this.dDy < 0) {
                this.dDz = -1;
            } else {
                this.dDz = 1;
            }
        }
        if (Math.abs(this.dDy) <= 1) {
            this.gcT.aLd();
            this.gcT.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.gcT.setTotalScrollY(this.gcT.getTotalScrollY() + this.dDz);
        if (!this.gcT.aLf()) {
            float itemHeight = this.gcT.getItemHeight();
            float f = (-this.gcT.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.gcT.getItemsCount() - 1) - this.gcT.getInitPosition());
            if (this.gcT.getTotalScrollY() <= f || this.gcT.getTotalScrollY() >= itemsCount) {
                this.gcT.setTotalScrollY(this.gcT.getTotalScrollY() - this.dDz);
                this.gcT.aLd();
                this.gcT.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.gcT.getHandler().sendEmptyMessage(1000);
        this.dDy -= this.dDz;
    }
}
