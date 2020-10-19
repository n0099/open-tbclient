package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes21.dex */
public final class c extends TimerTask {
    private final WheelView fxR;
    private int offset;
    private int realTotalOffset = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int realOffset = 0;

    public c(WheelView wheelView, int i) {
        this.fxR = wheelView;
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
            this.fxR.cancelFuture();
            this.fxR.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.fxR.setTotalScrollY(this.fxR.getTotalScrollY() + this.realOffset);
        if (!this.fxR.isLoop()) {
            float itemHeight = this.fxR.getItemHeight();
            float f = (-this.fxR.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.fxR.getItemsCount() - 1) - this.fxR.getInitPosition());
            if (this.fxR.getTotalScrollY() <= f || this.fxR.getTotalScrollY() >= itemsCount) {
                this.fxR.setTotalScrollY(this.fxR.getTotalScrollY() - this.realOffset);
                this.fxR.cancelFuture();
                this.fxR.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.fxR.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
