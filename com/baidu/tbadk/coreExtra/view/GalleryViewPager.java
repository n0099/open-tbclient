package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes3.dex */
public class GalleryViewPager extends BaseViewPager {
    public PointF m;
    public DragImageView n;

    public GalleryViewPager(Context context) {
        super(context);
    }

    public final float[] f(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        if (action == 0) {
            this.m = new PointF(motionEvent.getX(), motionEvent.getY());
            return null;
        } else if (action == 1 || action == 2) {
            PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
            float f2 = pointF.x;
            PointF pointF2 = this.m;
            return new float[]{f2 - pointF2.x, pointF.y - pointF2.y};
        } else {
            return null;
        }
    }

    public DragImageView getCurrentView() {
        return this.n;
    }

    @Override // com.baidu.tbadk.widget.TbViewPager, androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onInterceptTouchEvent(motionEvent);
        }
        float[] f2 = f(motionEvent);
        DragImageView dragImageView = this.n;
        if (dragImageView == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (dragImageView.f0()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (f2 != null && this.n.e0() && f2[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (f2 != null && this.n.d0() && f2[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (f2 == null && (this.n.d0() || this.n.e0())) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            DragImageView dragImageView = this.n;
            if (dragImageView != null) {
                dragImageView.N();
            }
        }
        if (this.n == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] f2 = f(motionEvent);
        if (this.n.f0()) {
            return super.onTouchEvent(motionEvent);
        }
        if (f2 != null && this.n.e0() && f2[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (f2 != null && this.n.d0() && f2[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (f2 == null && (this.n.d0() || this.n.e0())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setCurrentView(DragImageView dragImageView) {
        this.n = dragImageView;
    }

    public GalleryViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
