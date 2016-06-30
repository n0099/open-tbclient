package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class h extends BaseViewPager {
    private PointF akp;
    private com.baidu.tbadk.widget.a akq;
    private com.baidu.tbadk.widget.a akr;

    public h(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.akq = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.akq;
    }

    private float[] f(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.akp.x, pointF.y - this.akp.y};
            case 0:
                this.akp = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.akq != null) {
                this.akq.FP();
            }
        }
        if (this.akq == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] f = f(motionEvent);
        if (this.akq.FQ()) {
            return super.onTouchEvent(motionEvent);
        }
        if (f != null && this.akq.FU() && f[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (f != null && this.akq.FV() && f[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (f == null) {
            if (this.akq.FV() || this.akq.FU()) {
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
        if (this.akq == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.akq.FQ()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (f != null && this.akq.FU() && f[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (f != null && this.akq.FV() && f[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (f == null) {
            if (this.akq.FV() || this.akq.FU()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(com.baidu.tbadk.widget.a aVar) {
        this.akr = aVar;
    }

    public com.baidu.tbadk.widget.a getSelectedView() {
        return this.akr;
    }
}
