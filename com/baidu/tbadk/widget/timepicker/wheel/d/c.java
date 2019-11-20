package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class c extends TimerTask {
    private final WheelView cZh;
    private int cZl = Integer.MAX_VALUE;
    private int cZm = 0;
    private int offset;

    public c(WheelView wheelView, int i) {
        this.cZh = wheelView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.cZl == Integer.MAX_VALUE) {
            this.cZl = this.offset;
        }
        this.cZm = (int) (this.cZl * 0.1f);
        if (this.cZm == 0) {
            if (this.cZl < 0) {
                this.cZm = -1;
            } else {
                this.cZm = 1;
            }
        }
        if (Math.abs(this.cZl) <= 1) {
            this.cZh.aAD();
            this.cZh.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.cZh.setTotalScrollY(this.cZh.getTotalScrollY() + this.cZm);
        if (!this.cZh.aAF()) {
            float itemHeight = this.cZh.getItemHeight();
            float f = (-this.cZh.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.cZh.getItemsCount() - 1) - this.cZh.getInitPosition());
            if (this.cZh.getTotalScrollY() <= f || this.cZh.getTotalScrollY() >= itemsCount) {
                this.cZh.setTotalScrollY(this.cZh.getTotalScrollY() - this.cZm);
                this.cZh.aAD();
                this.cZh.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.cZh.getHandler().sendEmptyMessage(1000);
        this.cZl -= this.cZm;
    }
}
