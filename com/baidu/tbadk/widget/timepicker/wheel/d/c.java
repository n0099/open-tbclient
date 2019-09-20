package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class c extends TimerTask {
    private final WheelView cQG;
    private int cQK = Integer.MAX_VALUE;
    private int cQL = 0;
    private int offset;

    public c(WheelView wheelView, int i) {
        this.cQG = wheelView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.cQK == Integer.MAX_VALUE) {
            this.cQK = this.offset;
        }
        this.cQL = (int) (this.cQK * 0.1f);
        if (this.cQL == 0) {
            if (this.cQK < 0) {
                this.cQL = -1;
            } else {
                this.cQL = 1;
            }
        }
        if (Math.abs(this.cQK) <= 1) {
            this.cQG.aAw();
            this.cQG.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.cQG.setTotalScrollY(this.cQG.getTotalScrollY() + this.cQL);
        if (!this.cQG.aAy()) {
            float itemHeight = this.cQG.getItemHeight();
            float f = (-this.cQG.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.cQG.getItemsCount() - 1) - this.cQG.getInitPosition());
            if (this.cQG.getTotalScrollY() <= f || this.cQG.getTotalScrollY() >= itemsCount) {
                this.cQG.setTotalScrollY(this.cQG.getTotalScrollY() - this.cQL);
                this.cQG.aAw();
                this.cQG.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.cQG.getHandler().sendEmptyMessage(1000);
        this.cQK -= this.cQL;
    }
}
