package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class b extends BaseViewPager {
    private PointF bmg;
    private com.baidu.tbadk.widget.a bmh;

    public b(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.bmh = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.bmh;
    }

    private float[] y(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.bmg.x, pointF.y - this.bmg.y};
            case 0:
                this.bmg = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.bmh != null) {
                this.bmh.Pw();
            }
        }
        if (this.bmh == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] y = y(motionEvent);
        if (this.bmh.Px()) {
            return super.onTouchEvent(motionEvent);
        }
        if (y != null && this.bmh.PD() && y[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (y != null && this.bmh.PE() && y[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (y == null) {
            if (this.bmh.PE() || this.bmh.PD()) {
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
        float[] y = y(motionEvent);
        if (this.bmh == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.bmh.Px()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (y != null && this.bmh.PD() && y[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (y != null && this.bmh.PE() && y[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (y == null) {
            if (this.bmh.PE() || this.bmh.PD()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }
}
