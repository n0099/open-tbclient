package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class c extends TimerTask {
    private final WheelView esF;
    private int offset;
    private int realTotalOffset = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int realOffset = 0;

    public c(WheelView wheelView, int i) {
        this.esF = wheelView;
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
            this.esF.cancelFuture();
            this.esF.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.esF.setTotalScrollY(this.esF.getTotalScrollY() + this.realOffset);
        if (!this.esF.isLoop()) {
            float itemHeight = this.esF.getItemHeight();
            float f = (-this.esF.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.esF.getItemsCount() - 1) - this.esF.getInitPosition());
            if (this.esF.getTotalScrollY() <= f || this.esF.getTotalScrollY() >= itemsCount) {
                this.esF.setTotalScrollY(this.esF.getTotalScrollY() - this.realOffset);
                this.esF.cancelFuture();
                this.esF.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.esF.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
