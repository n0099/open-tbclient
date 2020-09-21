package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes20.dex */
public final class a extends TimerTask {
    private final WheelView flE;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView wheelView, float f) {
        this.flE = wheelView;
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
            this.flE.cancelFuture();
            this.flE.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.flE.setTotalScrollY(this.flE.getTotalScrollY() - i);
        if (!this.flE.isLoop()) {
            float itemHeight = this.flE.getItemHeight();
            float f = (-this.flE.getInitPosition()) * itemHeight;
            float itemsCount = ((this.flE.getItemsCount() - 1) - this.flE.getInitPosition()) * itemHeight;
            if (this.flE.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.flE.getTotalScrollY() + i;
            } else if (this.flE.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.flE.getTotalScrollY() + i;
            }
            if (this.flE.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.flE.setTotalScrollY((int) f);
            } else if (this.flE.getTotalScrollY() >= itemsCount) {
                this.flE.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.flE.getHandler().sendEmptyMessage(1000);
    }
}
