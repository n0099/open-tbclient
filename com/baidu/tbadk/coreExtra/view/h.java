package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class h extends BaseViewPager {
    private PointF atm;
    private com.baidu.tbadk.widget.b atn;
    private com.baidu.tbadk.widget.b ato;

    public h(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.b bVar) {
        this.atn = bVar;
    }

    public com.baidu.tbadk.widget.b getCurrentView() {
        return this.atn;
    }

    private float[] l(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.atm.x, pointF.y - this.atm.y};
            case 0:
                this.atm = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.atn != null) {
                this.atn.GL();
            }
        }
        if (this.atn == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] l = l(motionEvent);
        if (this.atn.GM()) {
            return super.onTouchEvent(motionEvent);
        }
        if (l != null && this.atn.GQ() && l[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (l != null && this.atn.GR() && l[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (l == null) {
            if (this.atn.GR() || this.atn.GQ()) {
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
        if (this.atn == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.atn.GM()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (l != null && this.atn.GQ() && l[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (l != null && this.atn.GR() && l[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (l == null) {
            if (this.atn.GR() || this.atn.GQ()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(com.baidu.tbadk.widget.b bVar) {
        this.ato = bVar;
    }

    public com.baidu.tbadk.widget.b getSelectedView() {
        return this.ato;
    }
}
