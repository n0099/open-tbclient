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
    private PointF drT;
    private DragImageView drU;

    public GalleryViewPager(Context context) {
        super(context);
    }

    public GalleryViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCurrentView(DragImageView dragImageView) {
        this.drU = dragImageView;
    }

    public DragImageView getCurrentView() {
        return this.drU;
    }

    private float[] r(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.drT.x, pointF.y - this.drT.y};
            case 0:
                this.drT = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.drU != null) {
                this.drU.actionUp();
            }
        }
        if (this.drU == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] r = r(motionEvent);
        if (this.drU.pagerCantScroll()) {
            return super.onTouchEvent(motionEvent);
        }
        if (r != null && this.drU.onRightSide() && r[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (r != null && this.drU.onLeftSide() && r[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (r == null) {
            if (this.drU.onLeftSide() || this.drU.onRightSide()) {
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
        float[] r = r(motionEvent);
        if (this.drU == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.drU.pagerCantScroll()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (r != null && this.drU.onRightSide() && r[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (r != null && this.drU.onLeftSide() && r[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (r == null) {
            if (this.drU.onLeftSide() || this.drU.onRightSide()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }
}
