package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class c extends TimerTask {
    private final WheelView cOm;
    private int cOq = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int cOr = 0;
    private int offset;

    public c(WheelView wheelView, int i) {
        this.cOm = wheelView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.cOq == Integer.MAX_VALUE) {
            this.cOq = this.offset;
        }
        this.cOr = (int) (this.cOq * 0.1f);
        if (this.cOr == 0) {
            if (this.cOq < 0) {
                this.cOr = -1;
            } else {
                this.cOr = 1;
            }
        }
        if (Math.abs(this.cOq) <= 1) {
            this.cOm.ayT();
            this.cOm.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.cOm.setTotalScrollY(this.cOm.getTotalScrollY() + this.cOr);
        if (!this.cOm.ayV()) {
            float itemHeight = this.cOm.getItemHeight();
            float f = (-this.cOm.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.cOm.getItemsCount() - 1) - this.cOm.getInitPosition());
            if (this.cOm.getTotalScrollY() <= f || this.cOm.getTotalScrollY() >= itemsCount) {
                this.cOm.setTotalScrollY(this.cOm.getTotalScrollY() - this.cOr);
                this.cOm.ayT();
                this.cOm.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.cOm.getHandler().sendEmptyMessage(1000);
        this.cOq -= this.cOr;
    }
}
