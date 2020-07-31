package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes15.dex */
public final class c extends TimerTask {
    private final WheelView eXX;
    private int offset;
    private int realTotalOffset = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int realOffset = 0;

    public c(WheelView wheelView, int i) {
        this.eXX = wheelView;
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
            this.eXX.cancelFuture();
            this.eXX.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.eXX.setTotalScrollY(this.eXX.getTotalScrollY() + this.realOffset);
        if (!this.eXX.isLoop()) {
            float itemHeight = this.eXX.getItemHeight();
            float f = (-this.eXX.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.eXX.getItemsCount() - 1) - this.eXX.getInitPosition());
            if (this.eXX.getTotalScrollY() <= f || this.eXX.getTotalScrollY() >= itemsCount) {
                this.eXX.setTotalScrollY(this.eXX.getTotalScrollY() - this.realOffset);
                this.eXX.cancelFuture();
                this.eXX.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.eXX.getHandler().sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
