package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class b extends BaseViewPager {
    private PointF bjJ;
    private com.baidu.tbadk.widget.a bjK;

    public b(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.bjK = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.bjK;
    }

    private float[] u(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.bjJ.x, pointF.y - this.bjJ.y};
            case 0:
                this.bjJ = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.bjK != null) {
                this.bjK.Pb();
            }
        }
        if (this.bjK == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] u = u(motionEvent);
        if (this.bjK.Pc()) {
            return super.onTouchEvent(motionEvent);
        }
        if (u != null && this.bjK.Pi() && u[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (u != null && this.bjK.Pj() && u[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (u == null) {
            if (this.bjK.Pj() || this.bjK.Pi()) {
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
        float[] u = u(motionEvent);
        if (this.bjK == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.bjK.Pc()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (u != null && this.bjK.Pi() && u[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (u != null && this.bjK.Pj() && u[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (u == null) {
            if (this.bjK.Pj() || this.bjK.Pi()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }
}
