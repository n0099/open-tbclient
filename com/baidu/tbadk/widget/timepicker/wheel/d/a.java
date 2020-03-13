package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class a extends TimerTask {
    private final WheelView dSm;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView wheelView, float f) {
        this.dSm = wheelView;
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
            this.dSm.cancelFuture();
            this.dSm.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.dSm.setTotalScrollY(this.dSm.getTotalScrollY() - i);
        if (!this.dSm.isLoop()) {
            float itemHeight = this.dSm.getItemHeight();
            float f = (-this.dSm.getInitPosition()) * itemHeight;
            float itemsCount = ((this.dSm.getItemsCount() - 1) - this.dSm.getInitPosition()) * itemHeight;
            if (this.dSm.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.dSm.getTotalScrollY() + i;
            } else if (this.dSm.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.dSm.getTotalScrollY() + i;
            }
            if (this.dSm.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.dSm.setTotalScrollY((int) f);
            } else if (this.dSm.getTotalScrollY() >= itemsCount) {
                this.dSm.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.dSm.getHandler().sendEmptyMessage(1000);
    }
}
