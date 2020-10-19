package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes21.dex */
public final class a extends TimerTask {
    private final WheelView fxS;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView wheelView, float f) {
        this.fxS = wheelView;
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
            this.fxS.cancelFuture();
            this.fxS.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.fxS.setTotalScrollY(this.fxS.getTotalScrollY() - i);
        if (!this.fxS.isLoop()) {
            float itemHeight = this.fxS.getItemHeight();
            float f = (-this.fxS.getInitPosition()) * itemHeight;
            float itemsCount = ((this.fxS.getItemsCount() - 1) - this.fxS.getInitPosition()) * itemHeight;
            if (this.fxS.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.fxS.getTotalScrollY() + i;
            } else if (this.fxS.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.fxS.getTotalScrollY() + i;
            }
            if (this.fxS.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.fxS.setTotalScrollY((int) f);
            } else if (this.fxS.getTotalScrollY() >= itemsCount) {
                this.fxS.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.fxS.getHandler().sendEmptyMessage(1000);
    }
}
