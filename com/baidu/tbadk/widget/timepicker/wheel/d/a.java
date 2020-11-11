package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes21.dex */
public final class a extends TimerTask {
    private final WheelView fMd;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView wheelView, float f) {
        this.fMd = wheelView;
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
            this.fMd.cancelFuture();
            this.fMd.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.fMd.setTotalScrollY(this.fMd.getTotalScrollY() - i);
        if (!this.fMd.isLoop()) {
            float itemHeight = this.fMd.getItemHeight();
            float f = (-this.fMd.getInitPosition()) * itemHeight;
            float itemsCount = ((this.fMd.getItemsCount() - 1) - this.fMd.getInitPosition()) * itemHeight;
            if (this.fMd.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.fMd.getTotalScrollY() + i;
            } else if (this.fMd.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.fMd.getTotalScrollY() + i;
            }
            if (this.fMd.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.fMd.setTotalScrollY((int) f);
            } else if (this.fMd.getTotalScrollY() >= itemsCount) {
                this.fMd.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.fMd.getHandler().sendEmptyMessage(1000);
    }
}
