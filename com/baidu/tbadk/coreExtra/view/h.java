package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class h extends BaseViewPager {
    private PointF ajJ;
    private com.baidu.tbadk.widget.a ajK;
    private com.baidu.tbadk.widget.a ajL;

    public h(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.ajK = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.ajK;
    }

    private float[] f(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.ajJ.x, pointF.y - this.ajJ.y};
            case 0:
                this.ajJ = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.ajK != null) {
                this.ajK.FO();
            }
        }
        if (this.ajK == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] f = f(motionEvent);
        if (this.ajK.FP()) {
            return super.onTouchEvent(motionEvent);
        }
        if (f != null && this.ajK.FT() && f[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (f != null && this.ajK.FU() && f[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (f == null) {
            if (this.ajK.FU() || this.ajK.FT()) {
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
        float[] f = f(motionEvent);
        if (this.ajK == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.ajK.FP()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (f != null && this.ajK.FT() && f[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (f != null && this.ajK.FU() && f[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (f == null) {
            if (this.ajK.FU() || this.ajK.FT()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(com.baidu.tbadk.widget.a aVar) {
        this.ajL = aVar;
    }

    public com.baidu.tbadk.widget.a getSelectedView() {
        return this.ajL;
    }
}
