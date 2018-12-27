package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes.dex */
public final class c extends TimerTask {
    private final WheelView bud;
    private int bui = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int buj = 0;
    private int offset;

    public c(WheelView wheelView, int i) {
        this.bud = wheelView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.bui == Integer.MAX_VALUE) {
            this.bui = this.offset;
        }
        this.buj = (int) (this.bui * 0.1f);
        if (this.buj == 0) {
            if (this.bui < 0) {
                this.buj = -1;
            } else {
                this.buj = 1;
            }
        }
        if (Math.abs(this.bui) <= 1) {
            this.bud.Tw();
            this.bud.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.bud.setTotalScrollY(this.bud.getTotalScrollY() + this.buj);
        if (!this.bud.Ty()) {
            float itemHeight = this.bud.getItemHeight();
            float f = (-this.bud.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.bud.getItemsCount() - 1) - this.bud.getInitPosition());
            if (this.bud.getTotalScrollY() <= f || this.bud.getTotalScrollY() >= itemsCount) {
                this.bud.setTotalScrollY(this.bud.getTotalScrollY() - this.buj);
                this.bud.Tw();
                this.bud.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.bud.getHandler().sendEmptyMessage(1000);
        this.bui -= this.buj;
    }
}
