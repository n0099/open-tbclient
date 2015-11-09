package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class i extends BaseViewPager {
    private PointF ajU;
    private com.baidu.tbadk.widget.a ajV;
    private com.baidu.tbadk.widget.a ajW;

    public i(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.ajV = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.ajV;
    }

    private float[] h(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.ajU.x, pointF.y - this.ajU.y};
            case 0:
                this.ajU = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.ajV != null) {
                this.ajV.actionUp();
            }
        }
        if (this.ajV == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] h = h(motionEvent);
        if (this.ajV.pagerCantScroll()) {
            return super.onTouchEvent(motionEvent);
        }
        if (h != null && this.ajV.onRightSide() && h[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (h != null && this.ajV.onLeftSide() && h[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (h == null) {
            if (this.ajV.onLeftSide() || this.ajV.onRightSide()) {
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
        if (this.ajV == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.ajV.pagerCantScroll()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (h != null && this.ajV.onRightSide() && h[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (h != null && this.ajV.onLeftSide() && h[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (h == null) {
            if (this.ajV.onLeftSide() || this.ajV.onRightSide()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(com.baidu.tbadk.widget.a aVar) {
        this.ajW = aVar;
    }

    public com.baidu.tbadk.widget.a getSelectedView() {
        return this.ajW;
    }
}
