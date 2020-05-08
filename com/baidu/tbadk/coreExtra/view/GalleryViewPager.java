package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class GalleryViewPager extends BaseViewPager {
    private PointF dSh;
    private DragImageView dSi;

    public GalleryViewPager(Context context) {
        super(context);
    }

    public GalleryViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCurrentView(DragImageView dragImageView) {
        this.dSi = dragImageView;
    }

    public DragImageView getCurrentView() {
        return this.dSi;
    }

    private float[] q(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.dSh.x, pointF.y - this.dSh.y};
            case 0:
                this.dSh = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.dSi != null) {
                this.dSi.actionUp();
            }
        }
        if (this.dSi == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] q = q(motionEvent);
        if (this.dSi.pagerCantScroll()) {
            return super.onTouchEvent(motionEvent);
        }
        if (q != null && this.dSi.onRightSide() && q[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (q != null && this.dSi.onLeftSide() && q[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (q == null) {
            if (this.dSi.onLeftSide() || this.dSi.onRightSide()) {
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
        float[] q = q(motionEvent);
        if (this.dSi == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.dSi.pagerCantScroll()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (q != null && this.dSi.onRightSide() && q[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (q != null && this.dSi.onLeftSide() && q[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (q == null) {
            if (this.dSi.onLeftSide() || this.dSi.onRightSide()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }
}
