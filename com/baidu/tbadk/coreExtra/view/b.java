package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class b extends BaseViewPager {
    private PointF avw;
    private com.baidu.tbadk.widget.a avx;
    private com.baidu.tbadk.widget.a avy;

    public b(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.avx = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.avx;
    }

    private float[] l(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.avw.x, pointF.y - this.avw.y};
            case 0:
                this.avw = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.avx != null) {
                this.avx.Hy();
            }
        }
        if (this.avx == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] l = l(motionEvent);
        if (this.avx.Hz()) {
            return super.onTouchEvent(motionEvent);
        }
        if (l != null && this.avx.HD() && l[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (l != null && this.avx.HE() && l[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (l == null) {
            if (this.avx.HE() || this.avx.HD()) {
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
        if (this.avx == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.avx.Hz()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (l != null && this.avx.HD() && l[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (l != null && this.avx.HE() && l[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (l == null) {
            if (this.avx.HE() || this.avx.HD()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(com.baidu.tbadk.widget.a aVar) {
        this.avy = aVar;
    }

    public com.baidu.tbadk.widget.a getSelectedView() {
        return this.avy;
    }
}
