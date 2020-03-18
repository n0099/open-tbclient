package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class a extends TimerTask {
    private final WheelView dSD;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView wheelView, float f) {
        this.dSD = wheelView;
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
            this.dSD.cancelFuture();
            this.dSD.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.dSD.setTotalScrollY(this.dSD.getTotalScrollY() - i);
        if (!this.dSD.isLoop()) {
            float itemHeight = this.dSD.getItemHeight();
            float f = (-this.dSD.getInitPosition()) * itemHeight;
            float itemsCount = ((this.dSD.getItemsCount() - 1) - this.dSD.getInitPosition()) * itemHeight;
            if (this.dSD.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.dSD.getTotalScrollY() + i;
            } else if (this.dSD.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.dSD.getTotalScrollY() + i;
            }
            if (this.dSD.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.dSD.setTotalScrollY((int) f);
            } else if (this.dSD.getTotalScrollY() >= itemsCount) {
                this.dSD.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.dSD.getHandler().sendEmptyMessage(1000);
    }
}
