package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class h extends BaseViewPager {
    private PointF asQ;
    private com.baidu.tbadk.widget.a asR;
    private com.baidu.tbadk.widget.a asS;

    public h(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.asR = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.asR;
    }

    private float[] h(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.asQ.x, pointF.y - this.asQ.y};
            case 0:
                this.asQ = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.asR != null) {
                this.asR.Hb();
            }
        }
        if (this.asR == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] h = h(motionEvent);
        if (this.asR.Hc()) {
            return super.onTouchEvent(motionEvent);
        }
        if (h != null && this.asR.Hg() && h[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (h != null && this.asR.Hh() && h[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (h == null) {
            if (this.asR.Hh() || this.asR.Hg()) {
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
        float[] h = h(motionEvent);
        if (this.asR == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.asR.Hc()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (h != null && this.asR.Hg() && h[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (h != null && this.asR.Hh() && h[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (h == null) {
            if (this.asR.Hh() || this.asR.Hg()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(com.baidu.tbadk.widget.a aVar) {
        this.asS = aVar;
    }

    public com.baidu.tbadk.widget.a getSelectedView() {
        return this.asS;
    }
}
