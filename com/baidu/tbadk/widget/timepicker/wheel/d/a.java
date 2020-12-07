package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes21.dex */
public final class a extends TimerTask {
    private final WheelView fTr;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView wheelView, float f) {
        this.fTr = wheelView;
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
            this.fTr.cancelFuture();
            this.fTr.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.fTr.setTotalScrollY(this.fTr.getTotalScrollY() - i);
        if (!this.fTr.isLoop()) {
            float itemHeight = this.fTr.getItemHeight();
            float f = (-this.fTr.getInitPosition()) * itemHeight;
            float itemsCount = ((this.fTr.getItemsCount() - 1) - this.fTr.getInitPosition()) * itemHeight;
            if (this.fTr.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.fTr.getTotalScrollY() + i;
            } else if (this.fTr.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.fTr.getTotalScrollY() + i;
            }
            if (this.fTr.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.fTr.setTotalScrollY((int) f);
            } else if (this.fTr.getTotalScrollY() >= itemsCount) {
                this.fTr.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.fTr.getHandler().sendEmptyMessage(1000);
    }
}
