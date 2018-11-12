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
    private PointF aPL;
    private DragImageView aPM;

    public GalleryViewPager(Context context) {
        super(context);
    }

    public GalleryViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCurrentView(DragImageView dragImageView) {
        this.aPM = dragImageView;
    }

    public DragImageView getCurrentView() {
        return this.aPM;
    }

    private float[] s(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.aPL.x, pointF.y - this.aPL.y};
            case 0:
                this.aPL = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.aPM != null) {
                this.aPM.Pj();
            }
        }
        if (this.aPM == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] s = s(motionEvent);
        if (this.aPM.Pk()) {
            return super.onTouchEvent(motionEvent);
        }
        if (s != null && this.aPM.Pq() && s[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (s != null && this.aPM.Pr() && s[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (s == null) {
            if (this.aPM.Pr() || this.aPM.Pq()) {
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
        float[] s = s(motionEvent);
        if (this.aPM == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.aPM.Pk()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (s != null && this.aPM.Pq() && s[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (s != null && this.aPM.Pr() && s[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (s == null) {
            if (this.aPM.Pr() || this.aPM.Pq()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }
}
