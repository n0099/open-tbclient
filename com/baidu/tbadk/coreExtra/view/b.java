package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class b extends BaseViewPager {
    private PointF awk;
    private com.baidu.tbadk.widget.a awl;
    private com.baidu.tbadk.widget.a awm;

    public b(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.awl = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.awl;
    }

    private float[] l(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.awk.x, pointF.y - this.awk.y};
            case 0:
                this.awk = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.awl != null) {
                this.awl.Hz();
            }
        }
        if (this.awl == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] l = l(motionEvent);
        if (this.awl.HA()) {
            return super.onTouchEvent(motionEvent);
        }
        if (l != null && this.awl.HE() && l[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (l != null && this.awl.HF() && l[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (l == null) {
            if (this.awl.HF() || this.awl.HE()) {
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
        if (this.awl == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.awl.HA()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (l != null && this.awl.HE() && l[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (l != null && this.awl.HF() && l[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (l == null) {
            if (this.awl.HF() || this.awl.HE()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(com.baidu.tbadk.widget.a aVar) {
        this.awm = aVar;
    }

    public com.baidu.tbadk.widget.a getSelectedView() {
        return this.awm;
    }
}
