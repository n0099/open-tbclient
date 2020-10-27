package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes21.dex */
public final class a extends TimerTask {
    private final WheelView fGn;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView wheelView, float f) {
        this.fGn = wheelView;
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
            this.fGn.cancelFuture();
            this.fGn.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.fGn.setTotalScrollY(this.fGn.getTotalScrollY() - i);
        if (!this.fGn.isLoop()) {
            float itemHeight = this.fGn.getItemHeight();
            float f = (-this.fGn.getInitPosition()) * itemHeight;
            float itemsCount = ((this.fGn.getItemsCount() - 1) - this.fGn.getInitPosition()) * itemHeight;
            if (this.fGn.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.fGn.getTotalScrollY() + i;
            } else if (this.fGn.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.fGn.getTotalScrollY() + i;
            }
            if (this.fGn.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.fGn.setTotalScrollY((int) f);
            } else if (this.fGn.getTotalScrollY() >= itemsCount) {
                this.fGn.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.fGn.getHandler().sendEmptyMessage(1000);
    }
}
