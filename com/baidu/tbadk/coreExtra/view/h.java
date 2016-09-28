package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class h extends BaseViewPager {
    private PointF anT;
    private com.baidu.tbadk.widget.a anU;
    private com.baidu.tbadk.widget.a anV;

    public h(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.anU = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.anU;
    }

    private float[] h(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.anT.x, pointF.y - this.anT.y};
            case 0:
                this.anT = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.anU != null) {
                this.anU.Hl();
            }
        }
        if (this.anU == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] h = h(motionEvent);
        if (this.anU.Hm()) {
            return super.onTouchEvent(motionEvent);
        }
        if (h != null && this.anU.Hq() && h[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (h != null && this.anU.Hr() && h[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (h == null) {
            if (this.anU.Hr() || this.anU.Hq()) {
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
        if (this.anU == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.anU.Hm()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (h != null && this.anU.Hq() && h[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (h != null && this.anU.Hr() && h[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (h == null) {
            if (this.anU.Hr() || this.anU.Hq()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(com.baidu.tbadk.widget.a aVar) {
        this.anV = aVar;
    }

    public com.baidu.tbadk.widget.a getSelectedView() {
        return this.anV;
    }
}
