package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class b extends BaseViewPager {
    private PointF awi;
    private com.baidu.tbadk.widget.a awj;
    private com.baidu.tbadk.widget.a awk;

    public b(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.awj = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.awj;
    }

    private float[] l(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.awi.x, pointF.y - this.awi.y};
            case 0:
                this.awi = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.awj != null) {
                this.awj.Hz();
            }
        }
        if (this.awj == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] l = l(motionEvent);
        if (this.awj.HA()) {
            return super.onTouchEvent(motionEvent);
        }
        if (l != null && this.awj.HE() && l[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (l != null && this.awj.HF() && l[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (l == null) {
            if (this.awj.HF() || this.awj.HE()) {
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
        if (this.awj == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.awj.HA()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (l != null && this.awj.HE() && l[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (l != null && this.awj.HF() && l[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (l == null) {
            if (this.awj.HF() || this.awj.HE()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(com.baidu.tbadk.widget.a aVar) {
        this.awk = aVar;
    }

    public com.baidu.tbadk.widget.a getSelectedView() {
        return this.awk;
    }
}
