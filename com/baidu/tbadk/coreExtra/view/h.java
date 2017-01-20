package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class h extends BaseViewPager {
    private PointF anv;
    private com.baidu.tbadk.widget.a anw;
    private com.baidu.tbadk.widget.a anx;

    public h(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.anw = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.anw;
    }

    private float[] h(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.anv.x, pointF.y - this.anv.y};
            case 0:
                this.anv = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.anw != null) {
                this.anw.GC();
            }
        }
        if (this.anw == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] h = h(motionEvent);
        if (this.anw.GD()) {
            return super.onTouchEvent(motionEvent);
        }
        if (h != null && this.anw.GH() && h[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (h != null && this.anw.GI() && h[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (h == null) {
            if (this.anw.GI() || this.anw.GH()) {
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
        if (this.anw == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.anw.GD()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (h != null && this.anw.GH() && h[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (h != null && this.anw.GI() && h[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (h == null) {
            if (this.anw.GI() || this.anw.GH()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(com.baidu.tbadk.widget.a aVar) {
        this.anx = aVar;
    }

    public com.baidu.tbadk.widget.a getSelectedView() {
        return this.anx;
    }
}
