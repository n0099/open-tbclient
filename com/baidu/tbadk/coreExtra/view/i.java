package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class i extends BaseViewPager {
    private PointF ajO;
    private com.baidu.tbadk.widget.a ajP;
    private com.baidu.tbadk.widget.a ajQ;

    public i(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.ajP = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.ajP;
    }

    private float[] h(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.ajO.x, pointF.y - this.ajO.y};
            case 0:
                this.ajO = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.ajP != null) {
                this.ajP.actionUp();
            }
        }
        if (this.ajP == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] h = h(motionEvent);
        if (this.ajP.pagerCantScroll()) {
            return super.onTouchEvent(motionEvent);
        }
        if (h != null && this.ajP.onRightSide() && h[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (h != null && this.ajP.onLeftSide() && h[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (h == null) {
            if (this.ajP.onLeftSide() || this.ajP.onRightSide()) {
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
        if (this.ajP == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.ajP.pagerCantScroll()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (h != null && this.ajP.onRightSide() && h[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (h != null && this.ajP.onLeftSide() && h[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (h == null) {
            if (this.ajP.onLeftSide() || this.ajP.onRightSide()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(com.baidu.tbadk.widget.a aVar) {
        this.ajQ = aVar;
    }

    public com.baidu.tbadk.widget.a getSelectedView() {
        return this.ajQ;
    }
}
