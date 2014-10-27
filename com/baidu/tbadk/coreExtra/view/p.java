package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class p extends BaseViewPager {
    private PointF NQ;
    private com.baidu.tbadk.widget.a NR;
    private com.baidu.tbadk.widget.a NS;

    public p(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.NR = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.NR;
    }

    private float[] a(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.NQ.x, pointF.y - this.NQ.y};
            case 0:
                this.NQ = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.NR != null) {
                this.NR.vb();
            }
        }
        if (this.NR == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] a = a(motionEvent);
        if (this.NR.vc()) {
            return super.onTouchEvent(motionEvent);
        }
        if (a != null && this.NR.vj() && a[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (a != null && this.NR.vk() && a[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (a == null) {
            if (this.NR.vk() || this.NR.vj()) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onInterceptTouchEvent(motionEvent);
        }
        float[] a = a(motionEvent);
        if (this.NR == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.NR.vc()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (a != null && this.NR.vj() && a[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (a != null && this.NR.vk() && a[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (a == null) {
            if (this.NR.vk() || this.NR.vj()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(com.baidu.tbadk.widget.a aVar) {
        this.NS = aVar;
    }

    public com.baidu.tbadk.widget.a getSelectedView() {
        return this.NS;
    }
}
