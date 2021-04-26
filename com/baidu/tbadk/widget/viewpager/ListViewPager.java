package com.baidu.tbadk.widget.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.widget.SwipeBackLayout;
/* loaded from: classes3.dex */
public class ListViewPager extends ViewPager {

    /* renamed from: e  reason: collision with root package name */
    public float f14090e;

    /* renamed from: f  reason: collision with root package name */
    public float f14091f;

    /* renamed from: g  reason: collision with root package name */
    public float f14092g;

    /* renamed from: h  reason: collision with root package name */
    public float f14093h;

    /* renamed from: i  reason: collision with root package name */
    public GestureDetector f14094i;
    public boolean j;
    public SwipeBackLayout.c k;

    /* loaded from: classes3.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (ListViewPager.this.k != null) {
                ListViewPager.this.k.enableSwipeBack();
            }
            return Math.abs(f2) > Math.abs(f3);
        }
    }

    public ListViewPager(Context context) {
        super(context);
        this.j = false;
        b();
    }

    public final void b() {
        this.f14094i = new GestureDetector((Context) null, new b());
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

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (c(motionEvent)) {
            return true;
        }
        if (this.j) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (Exception unused) {
                return false;
            }
        }
        if (getCurrentItem() != 0 && this.f14094i.onTouchEvent(motionEvent)) {
            d(true);
        }
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception unused2) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002d, code lost:
        if (r0 != 6) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.j) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            try {
                return super.onTouchEvent(motionEvent);
            } catch (Exception unused) {
                return false;
            }
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    SwipeBackLayout.c cVar = this.k;
                    if (cVar != null) {
                        cVar.enableSwipeBack();
                    }
                    this.f14092g = motionEvent.getX() - this.f14090e;
                    this.f14093h = motionEvent.getY() - this.f14091f;
                    this.f14090e = motionEvent.getX();
                    this.f14091f = motionEvent.getY();
                    if (getCurrentItem() != 0 && Math.abs(this.f14092g) > Math.abs(this.f14093h)) {
                        d(true);
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
                } catch (IllegalArgumentException unused2) {
                    return true;
                }
            }
            SwipeBackLayout.c cVar2 = this.k;
            if (cVar2 != null) {
                cVar2.enableSwipeBack();
            }
            this.f14090e = 0.0f;
            this.f14091f = 0.0f;
            this.f14092g = 0.0f;
            this.f14093h = 0.0f;
            if (c(motionEvent)) {
            }
        }
        SwipeBackLayout.c cVar3 = this.k;
        if (cVar3 != null) {
            cVar3.enableSwipeBack();
        }
        this.f14090e = motionEvent.getX();
        this.f14091f = motionEvent.getY();
        if (c(motionEvent)) {
        }
    }

    public void setDisableParentEvent(boolean z) {
        this.j = z;
    }

    public void setSwipeControlInterface(SwipeBackLayout.c cVar) {
        this.k = cVar;
    }

    public ListViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = false;
        b();
    }
}
