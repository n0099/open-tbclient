package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class i extends BaseViewPager {
    private PointF amL;
    private com.baidu.tbadk.widget.a amM;
    private com.baidu.tbadk.widget.a amN;

    public i(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.amM = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.amM;
    }

    private float[] e(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.amL.x, pointF.y - this.amL.y};
            case 0:
                this.amL = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.amM != null) {
                this.amM.actionUp();
            }
        }
        if (this.amM == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] e = e(motionEvent);
        if (this.amM.pagerCantScroll()) {
            return super.onTouchEvent(motionEvent);
        }
        if (e != null && this.amM.onRightSide() && e[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (e != null && this.amM.onLeftSide() && e[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (e == null) {
            if (this.amM.onLeftSide() || this.amM.onRightSide()) {
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
        float[] e = e(motionEvent);
        if (this.amM == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.amM.pagerCantScroll()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (e != null && this.amM.onRightSide() && e[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (e != null && this.amM.onLeftSide() && e[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (e == null) {
            if (this.amM.onLeftSide() || this.amM.onRightSide()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(com.baidu.tbadk.widget.a aVar) {
        this.amN = aVar;
    }

    public com.baidu.tbadk.widget.a getSelectedView() {
        return this.amN;
    }
}
