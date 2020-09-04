package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes15.dex */
public final class a extends TimerTask {
    private final WheelView fiN;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView wheelView, float f) {
        this.fiN = wheelView;
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
            this.fiN.cancelFuture();
            this.fiN.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.fiN.setTotalScrollY(this.fiN.getTotalScrollY() - i);
        if (!this.fiN.isLoop()) {
            float itemHeight = this.fiN.getItemHeight();
            float f = (-this.fiN.getInitPosition()) * itemHeight;
            float itemsCount = ((this.fiN.getItemsCount() - 1) - this.fiN.getInitPosition()) * itemHeight;
            if (this.fiN.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.fiN.getTotalScrollY() + i;
            } else if (this.fiN.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.fiN.getTotalScrollY() + i;
            }
            if (this.fiN.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.fiN.setTotalScrollY((int) f);
            } else if (this.fiN.getTotalScrollY() >= itemsCount) {
                this.fiN.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.fiN.getHandler().sendEmptyMessage(1000);
    }
}
