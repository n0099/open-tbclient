package com.baidu.tbadk.widget.timepicker.wheel.d;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public final class c extends TimerTask {
    private final WheelView cPJ;
    private int cPN = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int cPO = 0;
    private int offset;

    public c(WheelView wheelView, int i) {
        this.cPJ = wheelView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.cPN == Integer.MAX_VALUE) {
            this.cPN = this.offset;
        }
        this.cPO = (int) (this.cPN * 0.1f);
        if (this.cPO == 0) {
            if (this.cPN < 0) {
                this.cPO = -1;
            } else {
                this.cPO = 1;
            }
        }
        if (Math.abs(this.cPN) <= 1) {
            this.cPJ.aAi();
            this.cPJ.getHandler().sendEmptyMessage(3000);
            return;
        }
        this.cPJ.setTotalScrollY(this.cPJ.getTotalScrollY() + this.cPO);
        if (!this.cPJ.aAk()) {
            float itemHeight = this.cPJ.getItemHeight();
            float f = (-this.cPJ.getInitPosition()) * itemHeight;
            float itemsCount = itemHeight * ((this.cPJ.getItemsCount() - 1) - this.cPJ.getInitPosition());
            if (this.cPJ.getTotalScrollY() <= f || this.cPJ.getTotalScrollY() >= itemsCount) {
                this.cPJ.setTotalScrollY(this.cPJ.getTotalScrollY() - this.cPO);
                this.cPJ.aAi();
                this.cPJ.getHandler().sendEmptyMessage(3000);
                return;
            }
        }
        this.cPJ.getHandler().sendEmptyMessage(1000);
        this.cPN -= this.cPO;
    }
}
