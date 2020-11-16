package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes20.dex */
public final class a extends TimerTask {
    private final WheelView fLG;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView wheelView, float f) {
        this.fLG = wheelView;
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
            this.fLG.cancelFuture();
            this.fLG.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.fLG.setTotalScrollY(this.fLG.getTotalScrollY() - i);
        if (!this.fLG.isLoop()) {
            float itemHeight = this.fLG.getItemHeight();
            float f = (-this.fLG.getInitPosition()) * itemHeight;
            float itemsCount = ((this.fLG.getItemsCount() - 1) - this.fLG.getInitPosition()) * itemHeight;
            if (this.fLG.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.fLG.getTotalScrollY() + i;
            } else if (this.fLG.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.fLG.getTotalScrollY() + i;
            }
            if (this.fLG.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.fLG.setTotalScrollY((int) f);
            } else if (this.fLG.getTotalScrollY() >= itemsCount) {
                this.fLG.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.fLG.getHandler().sendEmptyMessage(1000);
    }
}
