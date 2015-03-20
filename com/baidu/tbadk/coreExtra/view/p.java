package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class p extends BaseViewPager {
    private PointF ael;
    private com.baidu.tbadk.widget.a aem;
    private com.baidu.tbadk.widget.a aen;

    public p(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.aem = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.aem;
    }

    private float[] i(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.ael.x, pointF.y - this.ael.y};
            case 0:
                this.ael = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.aem != null) {
                this.aem.actionUp();
            }
        }
        if (this.aem == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] i = i(motionEvent);
        if (this.aem.pagerCantScroll()) {
            return super.onTouchEvent(motionEvent);
        }
        if (i != null && this.aem.onRightSide() && i[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (i != null && this.aem.onLeftSide() && i[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (i == null) {
            if (this.aem.onLeftSide() || this.aem.onRightSide()) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onInterceptTouchEvent(motionEvent);
        }
        float[] i = i(motionEvent);
        if (this.aem == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.aem.pagerCantScroll()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (i != null && this.aem.onRightSide() && i[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (i != null && this.aem.onLeftSide() && i[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (i == null) {
            if (this.aem.onLeftSide() || this.aem.onRightSide()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(com.baidu.tbadk.widget.a aVar) {
        this.aen = aVar;
    }

    public com.baidu.tbadk.widget.a getSelectedView() {
        return this.aen;
    }
}
