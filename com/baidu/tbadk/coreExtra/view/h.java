package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class h extends BaseViewPager {
    private PointF anE;
    private com.baidu.tbadk.widget.a anF;
    private com.baidu.tbadk.widget.a anG;

    public h(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.anF = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.anF;
    }

    private float[] e(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.anE.x, pointF.y - this.anE.y};
            case 0:
                this.anE = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.anF != null) {
                this.anF.actionUp();
            }
        }
        if (this.anF == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] e = e(motionEvent);
        if (this.anF.pagerCantScroll()) {
            return super.onTouchEvent(motionEvent);
        }
        if (e != null && this.anF.onRightSide() && e[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (e != null && this.anF.onLeftSide() && e[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (e == null) {
            if (this.anF.onLeftSide() || this.anF.onRightSide()) {
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
        if (this.anF == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.anF.pagerCantScroll()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (e != null && this.anF.onRightSide() && e[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (e != null && this.anF.onLeftSide() && e[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (e == null) {
            if (this.anF.onLeftSide() || this.anF.onRightSide()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(com.baidu.tbadk.widget.a aVar) {
        this.anG = aVar;
    }

    public com.baidu.tbadk.widget.a getSelectedView() {
        return this.anG;
    }
}
