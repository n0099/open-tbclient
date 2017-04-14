package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class h extends BaseViewPager {
    private PointF atg;
    private com.baidu.tbadk.widget.a ath;
    private com.baidu.tbadk.widget.a ati;

    public h(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.ath = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.ath;
    }

    private float[] l(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.atg.x, pointF.y - this.atg.y};
            case 0:
                this.atg = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.ath != null) {
                this.ath.HA();
            }
        }
        if (this.ath == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] l = l(motionEvent);
        if (this.ath.HB()) {
            return super.onTouchEvent(motionEvent);
        }
        if (l != null && this.ath.HF() && l[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (l != null && this.ath.HG() && l[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (l == null) {
            if (this.ath.HG() || this.ath.HF()) {
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
        if (this.ath == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.ath.HB()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (l != null && this.ath.HF() && l[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (l != null && this.ath.HG() && l[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (l == null) {
            if (this.ath.HG() || this.ath.HF()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(com.baidu.tbadk.widget.a aVar) {
        this.ati = aVar;
    }

    public com.baidu.tbadk.widget.a getSelectedView() {
        return this.ati;
    }
}
