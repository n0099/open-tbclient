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
    private PointF aHf;
    private DragImageView aHg;

    public GalleryViewPager(Context context) {
        super(context);
    }

    public GalleryViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCurrentView(DragImageView dragImageView) {
        this.aHg = dragImageView;
    }

    public DragImageView getCurrentView() {
        return this.aHg;
    }

    private float[] s(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.aHf.x, pointF.y - this.aHf.y};
            case 0:
                this.aHf = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.aHg != null) {
                this.aHg.LK();
            }
        }
        if (this.aHg == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] s = s(motionEvent);
        if (this.aHg.LL()) {
            return super.onTouchEvent(motionEvent);
        }
        if (s != null && this.aHg.LR() && s[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (s != null && this.aHg.LS() && s[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (s == null) {
            if (this.aHg.LS() || this.aHg.LR()) {
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
        if (this.aHg == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.aHg.LL()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (s != null && this.aHg.LR() && s[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (s != null && this.aHg.LS() && s[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (s == null) {
            if (this.aHg.LS() || this.aHg.LR()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }
}
