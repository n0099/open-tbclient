package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class a extends TimerTask {
    private final WheelView dRY;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView wheelView, float f) {
        this.dRY = wheelView;
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
            this.dRY.cancelFuture();
            this.dRY.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.dRY.setTotalScrollY(this.dRY.getTotalScrollY() - i);
        if (!this.dRY.isLoop()) {
            float itemHeight = this.dRY.getItemHeight();
            float f = (-this.dRY.getInitPosition()) * itemHeight;
            float itemsCount = ((this.dRY.getItemsCount() - 1) - this.dRY.getInitPosition()) * itemHeight;
            if (this.dRY.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.dRY.getTotalScrollY() + i;
            } else if (this.dRY.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.dRY.getTotalScrollY() + i;
            }
            if (this.dRY.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.dRY.setTotalScrollY((int) f);
            } else if (this.dRY.getTotalScrollY() >= itemsCount) {
                this.dRY.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.dRY.getHandler().sendEmptyMessage(1000);
    }
}
