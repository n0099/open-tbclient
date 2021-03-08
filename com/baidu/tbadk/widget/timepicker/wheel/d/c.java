package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes.dex */
public final class c extends TimerTask {
    private int dCs = Integer.MAX_VALUE;
    private int dCt = 0;
    private final WheelView gcb;
    private int offset;

    public c(WheelView wheelView, int i) {
        this.gcb = wheelView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.dCs == Integer.MAX_VALUE) {
            this.dCs = this.offset;
        }
        this.dCt = (int) (this.dCs * 0.1f);
        if (this.dCt == 0) {
            if (this.dCs < 0) {
                this.dCt = -1;
            } else {
                this.dCt = 1;
            }
        }
        if (Math.abs(this.dCs) <= 1) {
            this.gcb.aHG();
            this.gcb.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.gcb.setTotalScrollY(this.gcb.getTotalScrollY() + this.dCt);
        if (!this.gcb.aHI()) {
            float itemHeight = this.gcb.getItemHeight();
            float f = (-this.gcb.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.gcb.getItemsCount() - 1) - this.gcb.getInitPosition());
            if (this.gcb.getTotalScrollY() <= f || this.gcb.getTotalScrollY() >= itemsCount) {
                this.gcb.setTotalScrollY(this.gcb.getTotalScrollY() - this.dCt);
                this.gcb.aHG();
                this.gcb.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.gcb.getHandler().sendEmptyMessage(1000);
        this.dCs -= this.dCt;
    }
}
