package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class c extends TimerTask {
    private final WheelView cGa;
    private int cGe = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int cGf = 0;
    private int offset;

    public c(WheelView wheelView, int i) {
        this.cGa = wheelView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.cGe == Integer.MAX_VALUE) {
            this.cGe = this.offset;
        }
        this.cGf = (int) (this.cGe * 0.1f);
        if (this.cGf == 0) {
            if (this.cGe < 0) {
                this.cGf = -1;
            } else {
                this.cGf = 1;
            }
        }
        if (Math.abs(this.cGe) <= 1) {
            this.cGa.atR();
            this.cGa.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.cGa.setTotalScrollY(this.cGa.getTotalScrollY() + this.cGf);
        if (!this.cGa.atT()) {
            float itemHeight = this.cGa.getItemHeight();
            float f = (-this.cGa.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.cGa.getItemsCount() - 1) - this.cGa.getInitPosition());
            if (this.cGa.getTotalScrollY() <= f || this.cGa.getTotalScrollY() >= itemsCount) {
                this.cGa.setTotalScrollY(this.cGa.getTotalScrollY() - this.cGf);
                this.cGa.atR();
                this.cGa.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.cGa.getHandler().sendEmptyMessage(1000);
        this.cGe -= this.cGf;
    }
}
