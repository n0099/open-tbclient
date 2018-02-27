package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class b extends BaseViewPager {
    private PointF bmd;
    private com.baidu.tbadk.widget.a bme;

    public b(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.bme = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.bme;
    }

    private float[] y(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.bmd.x, pointF.y - this.bmd.y};
            case 0:
                this.bmd = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.bme != null) {
                this.bme.Pv();
            }
        }
        if (this.bme == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] y = y(motionEvent);
        if (this.bme.Pw()) {
            return super.onTouchEvent(motionEvent);
        }
        if (y != null && this.bme.PC() && y[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (y != null && this.bme.PD() && y[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (y == null) {
            if (this.bme.PD() || this.bme.PC()) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onInterceptTouchEvent(motionEvent);
        }
        float[] y = y(motionEvent);
        if (this.bme == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.bme.Pw()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (y != null && this.bme.PC() && y[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (y != null && this.bme.PD() && y[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (y == null) {
            if (this.bme.PD() || this.bme.PC()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }
}
