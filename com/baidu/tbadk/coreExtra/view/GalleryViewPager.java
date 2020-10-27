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
    private PointF fcG;
    private DragImageView fcH;

    public GalleryViewPager(Context context) {
        super(context);
    }

    public GalleryViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCurrentView(DragImageView dragImageView) {
        this.fcH = dragImageView;
    }

    public DragImageView getCurrentView() {
        return this.fcH;
    }

    private float[] F(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.fcG.x, pointF.y - this.fcG.y};
            case 0:
                this.fcG = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.fcH != null) {
                this.fcH.actionUp();
            }
        }
        if (this.fcH == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] F = F(motionEvent);
        if (this.fcH.pagerCantScroll()) {
            return super.onTouchEvent(motionEvent);
        }
        if (F != null && this.fcH.onRightSide() && F[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (F != null && this.fcH.onLeftSide() && F[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (F == null) {
            if (this.fcH.onLeftSide() || this.fcH.onRightSide()) {
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
        float[] F = F(motionEvent);
        if (this.fcH == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.fcH.pagerCantScroll()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (F != null && this.fcH.onRightSide() && F[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (F != null && this.fcH.onLeftSide() && F[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (F == null) {
            if (this.fcH.onLeftSide() || this.fcH.onRightSide()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }
}
