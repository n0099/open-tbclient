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
    private PointF axS;
    private DragImageView axT;

    public GalleryViewPager(Context context) {
        super(context);
    }

    public GalleryViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCurrentView(DragImageView dragImageView) {
        this.axT = dragImageView;
    }

    public DragImageView getCurrentView() {
        return this.axT;
    }

    private float[] q(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.axS.x, pointF.y - this.axS.y};
            case 0:
                this.axS = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.axT != null) {
                this.axT.HY();
            }
        }
        if (this.axT == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] q = q(motionEvent);
        if (this.axT.HZ()) {
            return super.onTouchEvent(motionEvent);
        }
        if (q != null && this.axT.If() && q[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (q != null && this.axT.Ig() && q[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (q == null) {
            if (this.axT.Ig() || this.axT.If()) {
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
        if (this.axT == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.axT.HZ()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (q != null && this.axT.If() && q[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (q != null && this.axT.Ig() && q[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (q == null) {
            if (this.axT.Ig() || this.axT.If()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }
}
