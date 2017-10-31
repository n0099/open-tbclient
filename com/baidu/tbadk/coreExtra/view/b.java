package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class b extends BaseViewPager {
    private PointF auM;
    private com.baidu.tbadk.widget.a auN;

    public b(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.auN = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.auN;
    }

    private float[] l(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.auM.x, pointF.y - this.auM.y};
            case 0:
                this.auM = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.auN != null) {
                this.auN.Hj();
            }
        }
        if (this.auN == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] l = l(motionEvent);
        if (this.auN.Hk()) {
            return super.onTouchEvent(motionEvent);
        }
        if (l != null && this.auN.Hq() && l[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (l != null && this.auN.Hr() && l[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (l == null) {
            if (this.auN.Hr() || this.auN.Hq()) {
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
        float[] l = l(motionEvent);
        if (this.auN == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.auN.Hk()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (l != null && this.auN.Hq() && l[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (l != null && this.auN.Hr() && l[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (l == null) {
            if (this.auN.Hr() || this.auN.Hq()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }
}
