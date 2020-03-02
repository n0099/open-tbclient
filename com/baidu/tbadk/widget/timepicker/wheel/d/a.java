package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class a extends TimerTask {
    private final WheelView dRZ;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView wheelView, float f) {
        this.dRZ = wheelView;
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
            this.dRZ.cancelFuture();
            this.dRZ.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.dRZ.setTotalScrollY(this.dRZ.getTotalScrollY() - i);
        if (!this.dRZ.isLoop()) {
            float itemHeight = this.dRZ.getItemHeight();
            float f = (-this.dRZ.getInitPosition()) * itemHeight;
            float itemsCount = ((this.dRZ.getItemsCount() - 1) - this.dRZ.getInitPosition()) * itemHeight;
            if (this.dRZ.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.dRZ.getTotalScrollY() + i;
            } else if (this.dRZ.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.dRZ.getTotalScrollY() + i;
            }
            if (this.dRZ.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.dRZ.setTotalScrollY((int) f);
            } else if (this.dRZ.getTotalScrollY() >= itemsCount) {
                this.dRZ.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.dRZ.getHandler().sendEmptyMessage(1000);
    }
}
