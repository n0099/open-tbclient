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
    private PointF ccZ;
    private DragImageView cda;

    public GalleryViewPager(Context context) {
        super(context);
    }

    public GalleryViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCurrentView(DragImageView dragImageView) {
        this.cda = dragImageView;
    }

    public DragImageView getCurrentView() {
        return this.cda;
    }

    private float[] w(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.ccZ.x, pointF.y - this.ccZ.y};
            case 0:
                this.ccZ = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.cda != null) {
                this.cda.aqB();
            }
        }
        if (this.cda == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] w = w(motionEvent);
        if (this.cda.aqC()) {
            return super.onTouchEvent(motionEvent);
        }
        if (w != null && this.cda.aqI() && w[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (w != null && this.cda.aqJ() && w[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (w == null) {
            if (this.cda.aqJ() || this.cda.aqI()) {
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
        float[] w = w(motionEvent);
        if (this.cda == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.cda.aqC()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (w != null && this.cda.aqI() && w[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (w != null && this.cda.aqJ() && w[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (w == null) {
            if (this.cda.aqJ() || this.cda.aqI()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }
}
