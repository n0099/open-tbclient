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
    private PointF aOV;
    private DragImageView aOW;

    public GalleryViewPager(Context context) {
        super(context);
    }

    public GalleryViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCurrentView(DragImageView dragImageView) {
        this.aOW = dragImageView;
    }

    public DragImageView getCurrentView() {
        return this.aOW;
    }

    private float[] s(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.aOV.x, pointF.y - this.aOV.y};
            case 0:
                this.aOV = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.aOW != null) {
                this.aOW.Pa();
            }
        }
        if (this.aOW == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] s = s(motionEvent);
        if (this.aOW.Pb()) {
            return super.onTouchEvent(motionEvent);
        }
        if (s != null && this.aOW.Ph() && s[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (s != null && this.aOW.Pi() && s[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (s == null) {
            if (this.aOW.Pi() || this.aOW.Ph()) {
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
        if (this.aOW == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.aOW.Pb()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (s != null && this.aOW.Ph() && s[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (s != null && this.aOW.Pi() && s[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (s == null) {
            if (this.aOW.Pi() || this.aOW.Ph()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }
}
