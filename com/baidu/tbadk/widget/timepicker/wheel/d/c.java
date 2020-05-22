package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class c extends TimerTask {
    private final WheelView eHf;
    private int offset;
    private int realTotalOffset = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int realOffset = 0;

    public c(WheelView wheelView, int i) {
        this.eHf = wheelView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.realTotalOffset == Integer.MAX_VALUE) {
            this.realTotalOffset = this.offset;
        }
        this.realOffset = (int) (this.realTotalOffset * 0.1f);
        if (this.realOffset == 0) {
            if (this.realTotalOffset < 0) {
                this.realOffset = -1;
            } else {
                this.realOffset = 1;
            }
        }
        if (Math.abs(this.realTotalOffset) <= 1) {
            this.eHf.cancelFuture();
            this.eHf.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.eHf.setTotalScrollY(this.eHf.getTotalScrollY() + this.realOffset);
        if (!this.eHf.isLoop()) {
            float itemHeight = this.eHf.getItemHeight();
            float f = (-this.eHf.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.eHf.getItemsCount() - 1) - this.eHf.getInitPosition());
            if (this.eHf.getTotalScrollY() <= f || this.eHf.getTotalScrollY() >= itemsCount) {
                this.eHf.setTotalScrollY(this.eHf.getTotalScrollY() - this.realOffset);
                this.eHf.cancelFuture();
                this.eHf.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.eHf.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
