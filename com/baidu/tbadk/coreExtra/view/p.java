package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class p extends BaseViewPager {
    private PointF TH;
    private com.baidu.tbadk.widget.a TI;
    private com.baidu.tbadk.widget.a TJ;

    public p(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.TI = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.TI;
    }

    private float[] g(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.TH.x, pointF.y - this.TH.y};
            case 0:
                this.TH = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.TI != null) {
                this.TI.actionUp();
            }
        }
        if (this.TI == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] g = g(motionEvent);
        if (this.TI.pagerCantScroll()) {
            return super.onTouchEvent(motionEvent);
        }
        if (g != null && this.TI.onRightSide() && g[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (g != null && this.TI.onLeftSide() && g[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (g == null) {
            if (this.TI.onLeftSide() || this.TI.onRightSide()) {
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
        float[] g = g(motionEvent);
        if (this.TI == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.TI.pagerCantScroll()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (g != null && this.TI.onRightSide() && g[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (g != null && this.TI.onLeftSide() && g[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (g == null) {
            if (this.TI.onLeftSide() || this.TI.onRightSide()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(com.baidu.tbadk.widget.a aVar) {
        this.TJ = aVar;
    }

    public com.baidu.tbadk.widget.a getSelectedView() {
        return this.TJ;
    }
}
