package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import androidx.core.view.ViewConfigurationCompat;
import androidx.viewpager.widget.ViewPager;
import java.lang.reflect.Field;
/* loaded from: classes3.dex */
public class TbViewPager extends ViewPager {

    /* renamed from: e  reason: collision with root package name */
    public boolean f13148e;

    /* renamed from: f  reason: collision with root package name */
    public float f13149f;

    /* renamed from: g  reason: collision with root package name */
    public int f13150g;

    /* renamed from: h  reason: collision with root package name */
    public int f13151h;

    /* loaded from: classes3.dex */
    public class a extends Scroller {
        public a(Context context) {
            super(context);
        }

        public void a(ViewPager viewPager) {
            try {
                Field declaredField = ViewPager.class.getDeclaredField("mScroller");
                declaredField.setAccessible(true);
                declaredField.set(viewPager, this);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // android.widget.Scroller
        public void startScroll(int i2, int i3, int i4, int i5, int i6) {
            super.startScroll(i2, i3, i4, i5, TbViewPager.this.f13151h);
        }

        @Override // android.widget.Scroller
        public void startScroll(int i2, int i3, int i4, int i5) {
            super.startScroll(i2, i3, i4, i5, TbViewPager.this.f13151h);
        }
    }

    public TbViewPager(Context context) {
        super(context);
        this.f13148e = false;
        this.f13151h = 600;
        b();
    }

    public final void b() {
        this.f13150g = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
    }

    public final boolean c(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
    }

    public final void d(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (c(motionEvent)) {
            return true;
        }
        if (motionEvent.getPointerCount() > 1 && this.f13148e) {
            requestDisallowInterceptTouchEvent(false);
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            requestDisallowInterceptTouchEvent(true);
            return dispatchTouchEvent;
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception unused) {
            return false;
        }
    }

    public int getScrollingDuration() {
        return this.f13151h;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (c(motionEvent)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0016, code lost:
        if (r0 != 6) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x = motionEvent.getX() - this.f13149f;
                    if (getCurrentItem() == 0) {
                        if (x >= this.f13150g) {
                            d(false);
                        } else {
                            d(true);
                        }
                    } else if (getCurrentItem() == getAdapter().getCount() - 1) {
                        if (x <= (-this.f13150g)) {
                            d(false);
                        } else {
                            d(true);
                        }
                    }
                } else if (action != 3) {
                    if (action != 5) {
                    }
                }
                if (c(motionEvent)) {
                    return true;
                }
                try {
                    return super.onTouchEvent(motionEvent);
                } catch (IllegalArgumentException unused) {
                    return true;
                }
            }
            d(false);
            this.f13149f = 0.0f;
            if (c(motionEvent)) {
            }
        }
        d(true);
        this.f13149f = motionEvent.getX();
        if (c(motionEvent)) {
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        this.f13148e = z;
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void setViewPagerScroll(int i2) {
        this.f13151h = i2;
        new a(getContext()).a(this);
    }

    public void setViewPagerScroll() {
        setViewPagerScroll(600);
    }

    public TbViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13148e = false;
        this.f13151h = 600;
        b();
    }
}
