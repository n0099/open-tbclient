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
    private PointF aKt;
    private DragImageView aKu;

    public GalleryViewPager(Context context) {
        super(context);
    }

    public GalleryViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setCurrentView(DragImageView dragImageView) {
        this.aKu = dragImageView;
    }

    public DragImageView getCurrentView() {
        return this.aKu;
    }

    private float[] s(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.aKt.x, pointF.y - this.aKt.y};
            case 0:
                this.aKt = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, com.baidu.tbadk.widget.TbViewPager, android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.aKu != null) {
                this.aKu.Nc();
            }
        }
        if (this.aKu == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] s = s(motionEvent);
        if (this.aKu.Nd()) {
            return super.onTouchEvent(motionEvent);
        }
        if (s != null && this.aKu.Nj() && s[0] < 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (s != null && this.aKu.Nk() && s[0] > 0.0f) {
            return super.onTouchEvent(motionEvent);
        }
        if (s == null) {
            if (this.aKu.Nk() || this.aKu.Nj()) {
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
        if (this.aKu == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.aKu.Nd()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (s != null && this.aKu.Nj() && s[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (s != null && this.aKu.Nk() && s[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (s == null) {
            if (this.aKu.Nk() || this.aKu.Nj()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }
}
