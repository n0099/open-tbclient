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
    private PointF axT;
    private DragImageView axU;

    public GalleryViewPager(Context context) {
        super(context);
    }

    public GalleryViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCurrentView(DragImageView dragImageView) {
        this.axU = dragImageView;
    }

    public DragImageView getCurrentView() {
        return this.axU;
    }

    private float[] q(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.axT.x, pointF.y - this.axT.y};
            case 0:
                this.axT = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.axU != null) {
                this.axU.HW();
            }
        }
        if (this.axU == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] q = q(motionEvent);
        if (this.axU.HX()) {
            return super.onTouchEvent(motionEvent);
        }
        if (q != null && this.axU.Id() && q[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (q != null && this.axU.Ie() && q[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (q == null) {
            if (this.axU.Ie() || this.axU.Id()) {
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
        if (this.axU == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.axU.HX()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (q != null && this.axU.Id() && q[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (q != null && this.axU.Ie() && q[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (q == null) {
            if (this.axU.Ie() || this.axU.Id()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }
}
