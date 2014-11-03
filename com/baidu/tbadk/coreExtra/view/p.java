package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class p extends BaseViewPager {
    private PointF NU;
    private com.baidu.tbadk.widget.a NV;
    private com.baidu.tbadk.widget.a NW;

    public p(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.NV = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.NV;
    }

    private float[] a(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.NU.x, pointF.y - this.NU.y};
            case 0:
                this.NU = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.NV != null) {
                this.NV.vd();
            }
        }
        if (this.NV == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] a = a(motionEvent);
        if (this.NV.ve()) {
            return super.onTouchEvent(motionEvent);
        }
        if (a != null && this.NV.vl() && a[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (a != null && this.NV.vm() && a[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (a == null) {
            if (this.NV.vm() || this.NV.vl()) {
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
        if (this.NV == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.NV.ve()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (a != null && this.NV.vl() && a[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (a != null && this.NV.vm() && a[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (a == null) {
            if (this.NV.vm() || this.NV.vl()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(com.baidu.tbadk.widget.a aVar) {
        this.NW = aVar;
    }

    public com.baidu.tbadk.widget.a getSelectedView() {
        return this.NW;
    }
}
