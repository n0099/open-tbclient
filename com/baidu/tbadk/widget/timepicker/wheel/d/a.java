package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class a extends TimerTask {
    private final WheelView esG;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView wheelView, float f) {
        this.esG = wheelView;
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
            this.esG.cancelFuture();
            this.esG.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.esG.setTotalScrollY(this.esG.getTotalScrollY() - i);
        if (!this.esG.isLoop()) {
            float itemHeight = this.esG.getItemHeight();
            float f = (-this.esG.getInitPosition()) * itemHeight;
            float itemsCount = ((this.esG.getItemsCount() - 1) - this.esG.getInitPosition()) * itemHeight;
            if (this.esG.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.esG.getTotalScrollY() + i;
            } else if (this.esG.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.esG.getTotalScrollY() + i;
            }
            if (this.esG.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.esG.setTotalScrollY((int) f);
            } else if (this.esG.getTotalScrollY() >= itemsCount) {
                this.esG.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.esG.getHandler().sendEmptyMessage(1000);
    }
}
