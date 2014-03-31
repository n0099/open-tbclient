package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.baidu.tbadk.core.view.BaseViewPager;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public final class n extends BaseViewPager {
    private PointF a;
    private com.baidu.tbadk.widget.a b;
    private com.baidu.tbadk.widget.a c;

    public n(Context context) {
        super(context);
    }

    public final void setCurrentView(com.baidu.tbadk.widget.a aVar) {
        this.b = aVar;
    }

    public final com.baidu.tbadk.widget.a getCurrentView() {
        return this.b;
    }

    private float[] a(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
            case 1:
            case 2:
                PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
                return new float[]{pointF.x - this.a.x, pointF.y - this.a.y};
            case 0:
                this.a = new PointF(motionEvent.getX(), motionEvent.getY());
                break;
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.view.BaseViewPager, android.support.v4.view.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onTouchEvent(motionEvent);
            if (this.b != null) {
                this.b.a();
            }
        }
        if (this.b == null) {
            return super.onTouchEvent(motionEvent);
        }
        float[] a = a(motionEvent);
        if (this.b.b()) {
            return super.onTouchEvent(motionEvent);
        }
        if (a != null && this.b.g() && a[0] < 0.0f) {
            com.baidu.adp.lib.util.f.a(getClass().getName(), "onTouchEvent", "right");
            return super.onTouchEvent(motionEvent);
        } else if (a != null && this.b.h() && a[0] > 0.0f) {
            com.baidu.adp.lib.util.f.a(getClass().getName(), "onTouchEvent", "left");
            return super.onTouchEvent(motionEvent);
        } else if (a == null) {
            if (this.b.h() || this.b.g()) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        } else {
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & CompatibleUtile.getActionMask()) == 1) {
            super.onInterceptTouchEvent(motionEvent);
        }
        float[] a = a(motionEvent);
        if (this.b == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (this.b.b()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (a != null && this.b.g() && a[0] < 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (a != null && this.b.h() && a[0] > 0.0f) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (a == null) {
            if (this.b.h() || this.b.g()) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    public final void setSelectedView(com.baidu.tbadk.widget.a aVar) {
        this.c = aVar;
    }

    public final com.baidu.tbadk.widget.a getSelectedView() {
        return this.c;
    }
}
