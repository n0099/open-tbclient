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
    public float f13399e;

    /* renamed from: f  reason: collision with root package name */
    public float f13400f;

    /* renamed from: g  reason: collision with root package name */
    public float f13401g;

    /* renamed from: h  reason: collision with root package name */
    public float f13402h;

    /* renamed from: i  reason: collision with root package name */
    public GestureDetector f13403i;
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
        c();
    }

    public final void c() {
        this.f13403i = new GestureDetector((Context) null, new b());
    }

    public final boolean d(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
    }

    public final void e(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (d(motionEvent)) {
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
        if (getCurrentItem() != 0 && this.f13403i.onTouchEvent(motionEvent)) {
            e(true);
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
                    this.f13401g = motionEvent.getX() - this.f13399e;
                    this.f13402h = motionEvent.getY() - this.f13400f;
                    this.f13399e = motionEvent.getX();
                    this.f13400f = motionEvent.getY();
                    if (getCurrentItem() != 0 && Math.abs(this.f13401g) > Math.abs(this.f13402h)) {
                        e(true);
                    }
                } else if (action != 3) {
                    if (action != 5) {
                    }
                }
                if (d(motionEvent)) {
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
            this.f13399e = 0.0f;
            this.f13400f = 0.0f;
            this.f13401g = 0.0f;
            this.f13402h = 0.0f;
            if (d(motionEvent)) {
            }
        }
        SwipeBackLayout.c cVar3 = this.k;
        if (cVar3 != null) {
            cVar3.enableSwipeBack();
        }
        this.f13399e = motionEvent.getX();
        this.f13400f = motionEvent.getY();
        if (d(motionEvent)) {
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
        c();
    }
}
