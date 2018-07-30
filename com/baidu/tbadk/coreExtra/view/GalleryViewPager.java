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
    private PointF aHg;
    private DragImageView aHh;

    public GalleryViewPager(Context context) {
        super(context);
    }

    public GalleryViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCurrentView(DragImageView dragImageView) {
        this.aHh = dragImageView;
    }

    public DragImageView getCurrentView() {
        return this.aHh;
    }

    private float[] s(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.aHg.x, pointF.y - this.aHg.y};
            case 0:
                this.aHg = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.aHh != null) {
                this.aHh.LG();
            }
        }
        if (this.aHh == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] s = s(motionEvent);
        if (this.aHh.LH()) {
            return super.onTouchEvent(motionEvent);
        }
        if (s != null && this.aHh.LN() && s[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (s != null && this.aHh.LO() && s[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (s == null) {
            if (this.aHh.LO() || this.aHh.LN()) {
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
        if (this.aHh == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.aHh.LH()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (s != null && this.aHh.LN() && s[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (s != null && this.aHh.LO() && s[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (s == null) {
            if (this.aHh.LO() || this.aHh.LN()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }
}
