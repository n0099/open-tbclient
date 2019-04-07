package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class c extends TimerTask {
    private final WheelView cGc;
    private int cGg = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int cGh = 0;
    private int offset;

    public c(WheelView wheelView, int i) {
        this.cGc = wheelView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.cGg == Integer.MAX_VALUE) {
            this.cGg = this.offset;
        }
        this.cGh = (int) (this.cGg * 0.1f);
        if (this.cGh == 0) {
            if (this.cGg < 0) {
                this.cGh = -1;
            } else {
                this.cGh = 1;
            }
        }
        if (Math.abs(this.cGg) <= 1) {
            this.cGc.atO();
            this.cGc.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.cGc.setTotalScrollY(this.cGc.getTotalScrollY() + this.cGh);
        if (!this.cGc.atQ()) {
            float itemHeight = this.cGc.getItemHeight();
            float f = (-this.cGc.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.cGc.getItemsCount() - 1) - this.cGc.getInitPosition());
            if (this.cGc.getTotalScrollY() <= f || this.cGc.getTotalScrollY() >= itemsCount) {
                this.cGc.setTotalScrollY(this.cGc.getTotalScrollY() - this.cGh);
                this.cGc.atO();
                this.cGc.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.cGc.getHandler().sendEmptyMessage(1000);
        this.cGg -= this.cGh;
    }
}
