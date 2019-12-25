package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes5.dex */
public final class a extends TimerTask {
    private final WheelView dNK;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView wheelView, float f) {
        this.dNK = wheelView;
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
            this.dNK.cancelFuture();
            this.dNK.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.dNK.setTotalScrollY(this.dNK.getTotalScrollY() - i);
        if (!this.dNK.isLoop()) {
            float itemHeight = this.dNK.getItemHeight();
            float f = (-this.dNK.getInitPosition()) * itemHeight;
            float itemsCount = ((this.dNK.getItemsCount() - 1) - this.dNK.getInitPosition()) * itemHeight;
            if (this.dNK.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.dNK.getTotalScrollY() + i;
            } else if (this.dNK.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.dNK.getTotalScrollY() + i;
            }
            if (this.dNK.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.dNK.setTotalScrollY((int) f);
            } else if (this.dNK.getTotalScrollY() >= itemsCount) {
                this.dNK.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.dNK.getHandler().sendEmptyMessage(1000);
    }
}
