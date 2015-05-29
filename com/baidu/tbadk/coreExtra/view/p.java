package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class p extends BaseViewPager {
    private PointF afx;
    private com.baidu.tbadk.widget.a afy;
    private com.baidu.tbadk.widget.a afz;

    public p(Context context) {
        super(context);
    }

    public void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.afy = aVar;
    }

    public com.baidu.tbadk.widget.a getCurrentView() {
        return this.afy;
    }

    private float[] i(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.afx.x, pointF.y - this.afx.y};
            case 0:
                this.afx = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.afy != null) {
                this.afy.actionUp();
            }
        }
        if (this.afy == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] i = i(motionEvent);
        if (this.afy.pagerCantScroll()) {
            return super.onTouchEvent(motionEvent);
        }
        if (i != null && this.afy.onRightSide() && i[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (i != null && this.afy.onLeftSide() && i[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (i == null) {
            if (this.afy.onLeftSide() || this.afy.onRightSide()) {
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
        if (this.afy == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.afy.pagerCantScroll()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (i != null && this.afy.onRightSide() && i[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (i != null && this.afy.onLeftSide() && i[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (i == null) {
            if (this.afy.onLeftSide() || this.afy.onRightSide()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public void setSelectedView(com.baidu.tbadk.widget.a aVar) {
        this.afz = aVar;
    }

    public com.baidu.tbadk.widget.a getSelectedView() {
        return this.afz;
    }
}
