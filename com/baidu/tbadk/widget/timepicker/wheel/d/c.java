package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class c extends TimerTask {
    private final WheelView cGd;
    private int cGh = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int cGi = 0;
    private int offset;

    public c(WheelView wheelView, int i) {
        this.cGd = wheelView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.cGh == Integer.MAX_VALUE) {
            this.cGh = this.offset;
        }
        this.cGi = (int) (this.cGh * 0.1f);
        if (this.cGi == 0) {
            if (this.cGh < 0) {
                this.cGi = -1;
            } else {
                this.cGi = 1;
            }
        }
        if (Math.abs(this.cGh) <= 1) {
            this.cGd.atR();
            this.cGd.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.cGd.setTotalScrollY(this.cGd.getTotalScrollY() + this.cGi);
        if (!this.cGd.atT()) {
            float itemHeight = this.cGd.getItemHeight();
            float f = (-this.cGd.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.cGd.getItemsCount() - 1) - this.cGd.getInitPosition());
            if (this.cGd.getTotalScrollY() <= f || this.cGd.getTotalScrollY() >= itemsCount) {
                this.cGd.setTotalScrollY(this.cGd.getTotalScrollY() - this.cGi);
                this.cGd.atR();
                this.cGd.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.cGd.getHandler().sendEmptyMessage(1000);
        this.cGh -= this.cGi;
    }
}
