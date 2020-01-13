package com.baidu.tbadk.widget.timepicker.wheel.d;

import com.baidu.tbadk.widget.timepicker.wheel.view.WheelView;
import java.util.TimerTask;
/* loaded from: classes6.dex */
public final class a extends TimerTask {
    private final WheelView dNS;
    private float mCurrentVelocityY = 2.1474836E9f;
    private final float mFirstVelocityY;

    public a(WheelView wheelView, float f) {
        this.dNS = wheelView;
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
            this.dNS.cancelFuture();
            this.dNS.getHandler().sendEmptyMessage(2000);
            return;
        }
        int i = (int) (this.mCurrentVelocityY / 100.0f);
        this.dNS.setTotalScrollY(this.dNS.getTotalScrollY() - i);
        if (!this.dNS.isLoop()) {
            float itemHeight = this.dNS.getItemHeight();
            float f = (-this.dNS.getInitPosition()) * itemHeight;
            float itemsCount = ((this.dNS.getItemsCount() - 1) - this.dNS.getInitPosition()) * itemHeight;
            if (this.dNS.getTotalScrollY() - (itemHeight * 0.25d) < f) {
                f = this.dNS.getTotalScrollY() + i;
            } else if (this.dNS.getTotalScrollY() + (itemHeight * 0.25d) > itemsCount) {
                itemsCount = this.dNS.getTotalScrollY() + i;
            }
            if (this.dNS.getTotalScrollY() <= f) {
                this.mCurrentVelocityY = 40.0f;
                this.dNS.setTotalScrollY((int) f);
            } else if (this.dNS.getTotalScrollY() >= itemsCount) {
                this.dNS.setTotalScrollY((int) itemsCount);
                this.mCurrentVelocityY = -40.0f;
            }
        }
        if (this.mCurrentVelocityY < 0.0f) {
            this.mCurrentVelocityY += 20.0f;
        } else {
            this.mCurrentVelocityY -= 20.0f;
        }
        this.dNS.getHandler().sendEmptyMessage(1000);
    }
}
