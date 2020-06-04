package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class a extends TimerTask {
    private final WheelView eHr;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView wheelView, float f) {
        this.eHr = wheelView;
        this.mFirstVelocityY = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.mCurrentVelocityY == 2.1474836E9f) {
            if (Math.abs(this.mFirstVelocityY) > 2000.0f) {
                this.mCurrentVelocityY = this.mFirstVelocityY <= 0.0f ? -2000.0f : 2000.0f;
            } else {
                this.mCurrentVelocityY = this.mFirstVelocityY;
            }
        }
        if (Math.abs(this.mCurrentVelocityY) >= 0.0f && Math.abs(this.mCurrentVelocityY) <= 20.0f) {
            this.eHr.cancelFuture();
            this.eHr.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.eHr.setTotalScrollY(this.eHr.getTotalScrollY() - i);
        if (!this.eHr.isLoop()) {
            float itemHeight = this.eHr.getItemHeight();
            float f = (-this.eHr.getInitPosition()) * itemHeight;
            float itemsCount = ((this.eHr.getItemsCount() - 1) - this.eHr.getInitPosition()) * itemHeight;
            if (this.eHr.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.eHr.getTotalScrollY() + i;
            } else if (this.eHr.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.eHr.getTotalScrollY() + i;
            }
            if (this.eHr.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.eHr.setTotalScrollY((int) f);
            } else if (this.eHr.getTotalScrollY() >= itemsCount) {
                this.eHr.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.eHr.getHandler().sendEmptyMessage(1000);
    }
}
