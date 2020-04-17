package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class a extends TimerTask {
    private final WheelView esB;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView wheelView, float f) {
        this.esB = wheelView;
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
            this.esB.cancelFuture();
            this.esB.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.esB.setTotalScrollY(this.esB.getTotalScrollY() - i);
        if (!this.esB.isLoop()) {
            float itemHeight = this.esB.getItemHeight();
            float f = (-this.esB.getInitPosition()) * itemHeight;
            float itemsCount = ((this.esB.getItemsCount() - 1) - this.esB.getInitPosition()) * itemHeight;
            if (this.esB.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.esB.getTotalScrollY() + i;
            } else if (this.esB.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.esB.getTotalScrollY() + i;
            }
            if (this.esB.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.esB.setTotalScrollY((int) f);
            } else if (this.esB.getTotalScrollY() >= itemsCount) {
                this.esB.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.esB.getHandler().sendEmptyMessage(1000);
    }
}
