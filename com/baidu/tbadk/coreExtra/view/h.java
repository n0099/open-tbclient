package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class h extends BaseViewPager {
    private PointF anV;
    private com.baidu.tbadk.widget.a anW;
    private com.baidu.tbadk.widget.a anX;

    public h(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.anW = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.anW;
    }

    private float[] e(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.anV.x, pointF.y - this.anV.y};
            case 0:
                this.anV = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.anW != null) {
                this.anW.actionUp();
            }
        }
        if (this.anW == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] e = e(motionEvent);
        if (this.anW.pagerCantScroll()) {
            return super.onTouchEvent(motionEvent);
        }
        if (e != null && this.anW.onRightSide() && e[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (e != null && this.anW.onLeftSide() && e[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (e == null) {
            if (this.anW.onLeftSide() || this.anW.onRightSide()) {
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
        if (this.anW == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.anW.pagerCantScroll()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (e != null && this.anW.onRightSide() && e[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (e != null && this.anW.onLeftSide() && e[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (e == null) {
            if (this.anW.onLeftSide() || this.anW.onRightSide()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(com.baidu.tbadk.widget.a aVar) {
        this.anX = aVar;
    }

    public com.baidu.tbadk.widget.a getSelectedView() {
        return this.anX;
    }
}
