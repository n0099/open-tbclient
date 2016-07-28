package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class h extends BaseViewPager {
    private PointF ale;
    private com.baidu.tbadk.widget.a alf;
    private com.baidu.tbadk.widget.a alg;

    public h(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.alf = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.alf;
    }

    private float[] f(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.ale.x, pointF.y - this.ale.y};
            case 0:
                this.ale = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.alf != null) {
                this.alf.FS();
            }
        }
        if (this.alf == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] f = f(motionEvent);
        if (this.alf.FT()) {
            return super.onTouchEvent(motionEvent);
        }
        if (f != null && this.alf.FX() && f[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (f != null && this.alf.FY() && f[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (f == null) {
            if (this.alf.FY() || this.alf.FX()) {
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
        if (this.alf == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.alf.FT()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (f != null && this.alf.FX() && f[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (f != null && this.alf.FY() && f[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (f == null) {
            if (this.alf.FY() || this.alf.FX()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(com.baidu.tbadk.widget.a aVar) {
        this.alg = aVar;
    }

    public com.baidu.tbadk.widget.a getSelectedView() {
        return this.alg;
    }
}
