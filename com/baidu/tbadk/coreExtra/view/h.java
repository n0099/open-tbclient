package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class h extends BaseViewPager {
    private PointF asW;
    private com.baidu.tbadk.widget.b asX;
    private com.baidu.tbadk.widget.b asY;

    public h(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.b bVar) {
        this.asX = bVar;
    }

    public com.baidu.tbadk.widget.b getCurrentView() {
        return this.asX;
    }

    private float[] l(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.asW.x, pointF.y - this.asW.y};
            case 0:
                this.asW = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.asX != null) {
                this.asX.GF();
            }
        }
        if (this.asX == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] l = l(motionEvent);
        if (this.asX.GG()) {
            return super.onTouchEvent(motionEvent);
        }
        if (l != null && this.asX.GK() && l[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (l != null && this.asX.GL() && l[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (l == null) {
            if (this.asX.GL() || this.asX.GK()) {
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
        if (this.asX == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.asX.GG()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (l != null && this.asX.GK() && l[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (l != null && this.asX.GL() && l[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (l == null) {
            if (this.asX.GL() || this.asX.GK()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(com.baidu.tbadk.widget.b bVar) {
        this.asY = bVar;
    }

    public com.baidu.tbadk.widget.b getSelectedView() {
        return this.asY;
    }
}
