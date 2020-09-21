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
    private PointF eIc;
    private DragImageView eId;

    public GalleryViewPager(Context context) {
        super(context);
    }

    public GalleryViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCurrentView(DragImageView dragImageView) {
        this.eId = dragImageView;
    }

    public DragImageView getCurrentView() {
        return this.eId;
    }

    private float[] F(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.eIc.x, pointF.y - this.eIc.y};
            case 0:
                this.eIc = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.eId != null) {
                this.eId.actionUp();
            }
        }
        if (this.eId == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] F = F(motionEvent);
        if (this.eId.pagerCantScroll()) {
            return super.onTouchEvent(motionEvent);
        }
        if (F != null && this.eId.onRightSide() && F[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (F != null && this.eId.onLeftSide() && F[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (F == null) {
            if (this.eId.onLeftSide() || this.eId.onRightSide()) {
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
        if (this.eId == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.eId.pagerCantScroll()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (F != null && this.eId.onRightSide() && F[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (F != null && this.eId.onLeftSide() && F[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (F == null) {
            if (this.eId.onLeftSide() || this.eId.onRightSide()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }
}
