package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes15.dex */
public final class a extends TimerTask {
    private final WheelView eXY;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView wheelView, float f) {
        this.eXY = wheelView;
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
            this.eXY.cancelFuture();
            this.eXY.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.eXY.setTotalScrollY(this.eXY.getTotalScrollY() - i);
        if (!this.eXY.isLoop()) {
            float itemHeight = this.eXY.getItemHeight();
            float f = (-this.eXY.getInitPosition()) * itemHeight;
            float itemsCount = ((this.eXY.getItemsCount() - 1) - this.eXY.getInitPosition()) * itemHeight;
            if (this.eXY.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.eXY.getTotalScrollY() + i;
            } else if (this.eXY.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.eXY.getTotalScrollY() + i;
            }
            if (this.eXY.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.eXY.setTotalScrollY((int) f);
            } else if (this.eXY.getTotalScrollY() >= itemsCount) {
                this.eXY.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.eXY.getHandler().sendEmptyMessage(1000);
    }
}
