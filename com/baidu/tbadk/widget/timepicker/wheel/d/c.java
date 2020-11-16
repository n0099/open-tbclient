package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes20.dex */
public final class c extends TimerTask {
    private final WheelView fLF;
    private int offset;
    private int realTotalOffset = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int realOffset = 0;

    public c(WheelView wheelView, int i) {
        this.fLF = wheelView;
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
            this.fLF.cancelFuture();
            this.fLF.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.fLF.setTotalScrollY(this.fLF.getTotalScrollY() + this.realOffset);
        if (!this.fLF.isLoop()) {
            float itemHeight = this.fLF.getItemHeight();
            float f = (-this.fLF.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.fLF.getItemsCount() - 1) - this.fLF.getInitPosition());
            if (this.fLF.getTotalScrollY() <= f || this.fLF.getTotalScrollY() >= itemsCount) {
                this.fLF.setTotalScrollY(this.fLF.getTotalScrollY() - this.realOffset);
                this.fLF.cancelFuture();
                this.fLF.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.fLF.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
