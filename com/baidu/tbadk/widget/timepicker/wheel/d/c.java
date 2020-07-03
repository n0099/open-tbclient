package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class c extends TimerTask {
    private final WheelView eRC;
    private int offset;
    private int realTotalOffset = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int realOffset = 0;

    public c(WheelView wheelView, int i) {
        this.eRC = wheelView;
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
            this.eRC.cancelFuture();
            this.eRC.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.eRC.setTotalScrollY(this.eRC.getTotalScrollY() + this.realOffset);
        if (!this.eRC.isLoop()) {
            float itemHeight = this.eRC.getItemHeight();
            float f = (-this.eRC.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.eRC.getItemsCount() - 1) - this.eRC.getInitPosition());
            if (this.eRC.getTotalScrollY() <= f || this.eRC.getTotalScrollY() >= itemsCount) {
                this.eRC.setTotalScrollY(this.eRC.getTotalScrollY() - this.realOffset);
                this.eRC.cancelFuture();
                this.eRC.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.eRC.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
