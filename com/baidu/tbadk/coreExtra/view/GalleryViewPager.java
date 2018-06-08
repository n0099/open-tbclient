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
    private PointF aGo;
    private DragImageView aGp;

    public GalleryViewPager(Context context) {
        super(context);
    }

    public GalleryViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCurrentView(DragImageView dragImageView) {
        this.aGp = dragImageView;
    }

    public DragImageView getCurrentView() {
        return this.aGp;
    }

    private float[] r(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.aGo.x, pointF.y - this.aGo.y};
            case 0:
                this.aGo = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.aGp != null) {
                this.aGp.Ls();
            }
        }
        if (this.aGp == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] r = r(motionEvent);
        if (this.aGp.Lt()) {
            return super.onTouchEvent(motionEvent);
        }
        if (r != null && this.aGp.Lz() && r[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (r != null && this.aGp.LA() && r[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (r == null) {
            if (this.aGp.LA() || this.aGp.Lz()) {
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
        if (this.aGp == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.aGp.Lt()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (r != null && this.aGp.Lz() && r[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (r != null && this.aGp.LA() && r[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (r == null) {
            if (this.aGp.LA() || this.aGp.Lz()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }
}
