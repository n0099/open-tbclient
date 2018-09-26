package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes.dex */
public final class c extends TimerTask {
    private final WheelView blO;
    private int blS = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int blT = 0;
    private int offset;

    public c(WheelView wheelView, int i) {
        this.blO = wheelView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.blS == Integer.MAX_VALUE) {
            this.blS = this.offset;
        }
        this.blT = (int) (this.blS * 0.1f);
        if (this.blT == 0) {
            if (this.blS < 0) {
                this.blT = -1;
            } else {
                this.blT = 1;
            }
        }
        if (Math.abs(this.blS) <= 1) {
            this.blO.Ql();
            this.blO.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.blO.setTotalScrollY(this.blO.getTotalScrollY() + this.blT);
        if (!this.blO.Qn()) {
            float itemHeight = this.blO.getItemHeight();
            float f = (-this.blO.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.blO.getItemsCount() - 1) - this.blO.getInitPosition());
            if (this.blO.getTotalScrollY() <= f || this.blO.getTotalScrollY() >= itemsCount) {
                this.blO.setTotalScrollY(this.blO.getTotalScrollY() - this.blT);
                this.blO.Ql();
                this.blO.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.blO.getHandler().sendEmptyMessage(1000);
        this.blS -= this.blT;
    }
}
