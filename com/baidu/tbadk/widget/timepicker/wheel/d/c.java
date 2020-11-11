package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes21.dex */
public final class c extends TimerTask {
    private final WheelView fMc;
    private int offset;
    private int realTotalOffset = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int realOffset = 0;

    public c(WheelView wheelView, int i) {
        this.fMc = wheelView;
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
            this.fMc.cancelFuture();
            this.fMc.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.fMc.setTotalScrollY(this.fMc.getTotalScrollY() + this.realOffset);
        if (!this.fMc.isLoop()) {
            float itemHeight = this.fMc.getItemHeight();
            float f = (-this.fMc.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.fMc.getItemsCount() - 1) - this.fMc.getInitPosition());
            if (this.fMc.getTotalScrollY() <= f || this.fMc.getTotalScrollY() >= itemsCount) {
                this.fMc.setTotalScrollY(this.fMc.getTotalScrollY() - this.realOffset);
                this.fMc.cancelFuture();
                this.fMc.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.fMc.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
