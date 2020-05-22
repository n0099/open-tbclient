package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class a extends TimerTask {
    private final WheelView eHg;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView wheelView, float f) {
        this.eHg = wheelView;
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
            this.eHg.cancelFuture();
            this.eHg.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.eHg.setTotalScrollY(this.eHg.getTotalScrollY() - i);
        if (!this.eHg.isLoop()) {
            float itemHeight = this.eHg.getItemHeight();
            float f = (-this.eHg.getInitPosition()) * itemHeight;
            float itemsCount = ((this.eHg.getItemsCount() - 1) - this.eHg.getInitPosition()) * itemHeight;
            if (this.eHg.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.eHg.getTotalScrollY() + i;
            } else if (this.eHg.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.eHg.getTotalScrollY() + i;
            }
            if (this.eHg.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.eHg.setTotalScrollY((int) f);
            } else if (this.eHg.getTotalScrollY() >= itemsCount) {
                this.eHg.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.eHg.getHandler().sendEmptyMessage(1000);
    }
}
