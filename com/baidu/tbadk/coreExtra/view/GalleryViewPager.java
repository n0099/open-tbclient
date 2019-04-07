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
    private PointF cdb;
    private DragImageView cdc;

    public GalleryViewPager(Context context) {
        super(context);
    }

    public GalleryViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCurrentView(DragImageView dragImageView) {
        this.cdc = dragImageView;
    }

    public DragImageView getCurrentView() {
        return this.cdc;
    }

    private float[] w(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.cdb.x, pointF.y - this.cdb.y};
            case 0:
                this.cdb = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.cdc != null) {
                this.cdc.aqy();
            }
        }
        if (this.cdc == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] w = w(motionEvent);
        if (this.cdc.aqz()) {
            return super.onTouchEvent(motionEvent);
        }
        if (w != null && this.cdc.aqF() && w[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (w != null && this.cdc.aqG() && w[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (w == null) {
            if (this.cdc.aqG() || this.cdc.aqF()) {
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
        if (this.cdc == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.cdc.aqz()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (w != null && this.cdc.aqF() && w[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (w != null && this.cdc.aqG() && w[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (w == null) {
            if (this.cdc.aqG() || this.cdc.aqF()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }
}
