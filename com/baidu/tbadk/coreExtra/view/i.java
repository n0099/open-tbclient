package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class i extends BaseViewPager {
    private PointF alF;
    private com.baidu.tbadk.widget.a alG;
    private com.baidu.tbadk.widget.a alH;

    public i(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.alG = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.alG;
    }

    private float[] i(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.alF.x, pointF.y - this.alF.y};
            case 0:
                this.alF = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.alG != null) {
                this.alG.actionUp();
            }
        }
        if (this.alG == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] i = i(motionEvent);
        if (this.alG.pagerCantScroll()) {
            return super.onTouchEvent(motionEvent);
        }
        if (i != null && this.alG.onRightSide() && i[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (i != null && this.alG.onLeftSide() && i[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (i == null) {
            if (this.alG.onLeftSide() || this.alG.onRightSide()) {
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
        float[] i = i(motionEvent);
        if (this.alG == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.alG.pagerCantScroll()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (i != null && this.alG.onRightSide() && i[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (i != null && this.alG.onLeftSide() && i[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (i == null) {
            if (this.alG.onLeftSide() || this.alG.onRightSide()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(com.baidu.tbadk.widget.a aVar) {
        this.alH = aVar;
    }

    public com.baidu.tbadk.widget.a getSelectedView() {
        return this.alH;
    }
}
