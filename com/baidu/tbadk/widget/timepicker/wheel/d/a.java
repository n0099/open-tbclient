package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes8.dex */
public final class a extends TimerTask {
    private final WheelView eRD;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView wheelView, float f) {
        this.eRD = wheelView;
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
            this.eRD.cancelFuture();
            this.eRD.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.eRD.setTotalScrollY(this.eRD.getTotalScrollY() - i);
        if (!this.eRD.isLoop()) {
            float itemHeight = this.eRD.getItemHeight();
            float f = (-this.eRD.getInitPosition()) * itemHeight;
            float itemsCount = ((this.eRD.getItemsCount() - 1) - this.eRD.getInitPosition()) * itemHeight;
            if (this.eRD.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.eRD.getTotalScrollY() + i;
            } else if (this.eRD.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.eRD.getTotalScrollY() + i;
            }
            if (this.eRD.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.eRD.setTotalScrollY((int) f);
            } else if (this.eRD.getTotalScrollY() >= itemsCount) {
                this.eRD.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.eRD.getHandler().sendEmptyMessage(1000);
    }
}
