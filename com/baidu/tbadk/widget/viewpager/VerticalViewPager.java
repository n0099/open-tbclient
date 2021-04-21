package com.baidu.tbadk.widget.viewpager;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.os.ParcelableCompat;
import androidx.core.os.ParcelableCompatCreatorCallbacks;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import d.b.i0.b1.p.a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes3.dex */
public class VerticalViewPager extends ViewGroup {
    public static final int[] j0 = {16842931};
    public static final Comparator<d> k0 = new a();
    public static final Interpolator l0 = new b();
    public static final h m0 = new h();
    public int A;
    public boolean B;
    public boolean C;
    public int D;
    public int E;
    public int F;
    public float G;
    public float H;
    public float I;
    public float J;
    public int K;
    public VelocityTracker L;
    public int M;
    public int N;
    public int O;
    public int P;
    public boolean Q;
    public EdgeEffectCompat R;
    public EdgeEffectCompat S;
    public boolean T;
    public boolean U;
    public int V;
    public ViewPager.OnPageChangeListener W;
    public ViewPager.OnPageChangeListener a0;
    public f b0;
    public ViewPager.PageTransformer c0;
    public Method d0;

    /* renamed from: e  reason: collision with root package name */
    public int f14056e;
    public int e0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14057f;
    public ArrayList<View> f0;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList<d> f14058g;
    public final Runnable g0;

    /* renamed from: h  reason: collision with root package name */
    public final d f14059h;
    public int h0;
    public final Rect i;
    public d.b.i0.b1.p.a i0;
    public PagerAdapter j;
    public int k;
    public int l;
    public Parcelable m;
    public ClassLoader n;
    public Scroller o;
    public g p;
    public int q;
    public Drawable r;
    public int s;
    public int t;
    public float u;
    public float v;
    public int w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new a());

        /* renamed from: e  reason: collision with root package name */
        public int f14066e;

        /* renamed from: f  reason: collision with root package name */
        public Parcelable f14067f;

        /* renamed from: g  reason: collision with root package name */
        public ClassLoader f14068g;

        /* loaded from: classes3.dex */
        public static class a implements ParcelableCompatCreatorCallbacks<SavedState> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            /* renamed from: b */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f14066e + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f14066e);
            parcel.writeParcelable(this.f14067f, i);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? SavedState.class.getClassLoader() : classLoader;
            this.f14066e = parcel.readInt();
            this.f14067f = parcel.readParcelable(classLoader);
            this.f14068g = classLoader;
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements Comparator<d> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            return dVar.f14071b - dVar2.f14071b;
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            VerticalViewPager.this.setScrollState(0);
            VerticalViewPager.this.D();
        }
    }

    /* loaded from: classes3.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public Object f14070a;

        /* renamed from: b  reason: collision with root package name */
        public int f14071b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f14072c;

        /* renamed from: d  reason: collision with root package name */
        public float f14073d;

        /* renamed from: e  reason: collision with root package name */
        public float f14074e;
    }

    /* loaded from: classes3.dex */
    public class e extends AccessibilityDelegateCompat {
        public e() {
        }

        public final boolean canScroll() {
            return VerticalViewPager.this.j != null && VerticalViewPager.this.j.getCount() > 1;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            AccessibilityRecordCompat obtain = AccessibilityRecordCompat.obtain();
            obtain.setScrollable(canScroll());
            if (accessibilityEvent.getEventType() != 4096 || VerticalViewPager.this.j == null) {
                return;
            }
            obtain.setItemCount(VerticalViewPager.this.j.getCount());
            obtain.setFromIndex(VerticalViewPager.this.k);
            obtain.setToIndex(VerticalViewPager.this.k);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            accessibilityNodeInfoCompat.setScrollable(canScroll());
            if (VerticalViewPager.this.v(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (VerticalViewPager.this.v(-1)) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i == 8192 && VerticalViewPager.this.v(-1)) {
                    VerticalViewPager verticalViewPager = VerticalViewPager.this;
                    verticalViewPager.setCurrentItem(verticalViewPager.k - 1);
                    return true;
                }
                return false;
            } else if (VerticalViewPager.this.v(1)) {
                VerticalViewPager verticalViewPager2 = VerticalViewPager.this;
                verticalViewPager2.setCurrentItem(verticalViewPager2.k + 1);
                return true;
            } else {
                return false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* loaded from: classes3.dex */
    public class g extends DataSetObserver {
        public g() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            VerticalViewPager.this.j();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            VerticalViewPager.this.j();
        }

        public /* synthetic */ g(VerticalViewPager verticalViewPager, a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class h implements Comparator<View> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z = layoutParams.f14060a;
            if (z != layoutParams2.f14060a) {
                return z ? 1 : -1;
            }
            return layoutParams.f14064e - layoutParams2.f14064e;
        }
    }

    public VerticalViewPager(Context context) {
        super(context);
        this.f14058g = new ArrayList<>();
        this.f14059h = new d();
        this.i = new Rect();
        this.l = -1;
        this.m = null;
        this.n = null;
        this.u = -3.4028235E38f;
        this.v = Float.MAX_VALUE;
        this.A = 1;
        this.K = -1;
        this.T = true;
        this.g0 = new c();
        this.h0 = 0;
        u();
    }

    private int getClientHeight() {
        return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollState(int i) {
        if (this.h0 == i) {
            return;
        }
        this.h0 = i;
        if (this.c0 != null) {
            m(i != 0);
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.W;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.y != z) {
            this.y = z;
        }
    }

    public boolean A(int i) {
        if (this.f14058g.size() == 0) {
            this.U = false;
            x(0, 0.0f, 0);
            if (this.U) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        d s = s();
        int clientHeight = getClientHeight();
        int i2 = this.q;
        int i3 = clientHeight + i2;
        float f2 = clientHeight;
        int i4 = s.f14071b;
        float f3 = ((i / f2) - s.f14074e) / (s.f14073d + (i2 / f2));
        this.U = false;
        x(i4, f3, (int) (i3 * f3));
        if (this.U) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public boolean B() {
        int i = this.k;
        if (i > 0) {
            setCurrentItem(i - 1, true);
            return true;
        }
        return false;
    }

    public final boolean C(float f2) {
        boolean z;
        float f3 = this.H - f2;
        this.H = f2;
        float scrollY = getScrollY() + f3;
        float clientHeight = getClientHeight();
        float f4 = this.u * clientHeight;
        float f5 = this.v * clientHeight;
        d dVar = this.f14058g.get(0);
        ArrayList<d> arrayList = this.f14058g;
        boolean z2 = true;
        d dVar2 = arrayList.get(arrayList.size() - 1);
        if (dVar.f14071b != 0) {
            f4 = dVar.f14074e * clientHeight;
            z = false;
        } else {
            z = true;
        }
        if (dVar2.f14071b != this.j.getCount() - 1) {
            f5 = dVar2.f14074e * clientHeight;
            z2 = false;
        }
        if (scrollY < f4) {
            r4 = z ? this.R.onPull(Math.abs(f4 - scrollY) / clientHeight) : false;
            scrollY = f4;
        } else if (scrollY > f5) {
            r4 = z2 ? this.S.onPull(Math.abs(scrollY - f5) / clientHeight) : false;
            scrollY = f5;
        }
        int i = (int) scrollY;
        this.G += scrollY - i;
        scrollTo(getScrollX(), i);
        A(i);
        return r4;
    }

    public void D() {
        E(this.k);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
        if (r10 == r11) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void E(int i) {
        int i2;
        d dVar;
        String hexString;
        d dVar2;
        d r;
        d dVar3;
        int i3 = this.k;
        if (i3 != i) {
            i2 = i3 < i ? IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER : 33;
            dVar = t(this.k);
            this.k = i;
        } else {
            i2 = 2;
            dVar = null;
        }
        if (this.j == null) {
            M();
        } else if (this.z) {
            M();
        } else if (getWindowToken() != null) {
            this.j.startUpdate((ViewGroup) this);
            int i4 = this.A;
            int max = Math.max(0, this.k - i4);
            int count = this.j.getCount();
            int min = Math.min(count - 1, this.k + i4);
            if (count == this.f14056e) {
                int i5 = 0;
                while (true) {
                    if (i5 >= this.f14058g.size()) {
                        break;
                    }
                    dVar2 = this.f14058g.get(i5);
                    int i6 = dVar2.f14071b;
                    int i7 = this.k;
                    if (i6 < i7) {
                        i5++;
                    }
                }
                dVar2 = null;
                if (dVar2 == null && count > 0) {
                    dVar2 = e(this.k, i5);
                }
                if (dVar2 != null) {
                    int i8 = i5 - 1;
                    d dVar4 = i8 >= 0 ? this.f14058g.get(i8) : null;
                    int clientHeight = getClientHeight();
                    float paddingLeft = clientHeight <= 0 ? 0.0f : (2.0f - dVar2.f14073d) + (getPaddingLeft() / clientHeight);
                    float f2 = 0.0f;
                    for (int i9 = this.k - 1; i9 >= 0; i9--) {
                        if (f2 < paddingLeft || i9 >= max) {
                            if (dVar4 != null && i9 == dVar4.f14071b) {
                                f2 += dVar4.f14073d;
                                i8--;
                                if (i8 >= 0) {
                                    dVar3 = this.f14058g.get(i8);
                                    dVar4 = dVar3;
                                }
                                dVar3 = null;
                                dVar4 = dVar3;
                            } else {
                                f2 += e(i9, i8 + 1).f14073d;
                                i5++;
                                if (i8 >= 0) {
                                    dVar3 = this.f14058g.get(i8);
                                    dVar4 = dVar3;
                                }
                                dVar3 = null;
                                dVar4 = dVar3;
                            }
                        } else if (dVar4 == null) {
                            break;
                        } else {
                            if (i9 == dVar4.f14071b && !dVar4.f14072c) {
                                this.f14058g.remove(i8);
                                this.j.destroyItem((ViewGroup) this, i9, dVar4.f14070a);
                                i8--;
                                i5--;
                                if (i8 >= 0) {
                                    dVar3 = this.f14058g.get(i8);
                                    dVar4 = dVar3;
                                }
                                dVar3 = null;
                                dVar4 = dVar3;
                            }
                        }
                    }
                    float f3 = dVar2.f14073d;
                    int i10 = i5 + 1;
                    if (f3 < 2.0f) {
                        d dVar5 = i10 < this.f14058g.size() ? this.f14058g.get(i10) : null;
                        float paddingRight = clientHeight <= 0 ? 0.0f : (getPaddingRight() / clientHeight) + 2.0f;
                        int i11 = this.k;
                        while (true) {
                            i11++;
                            if (i11 >= count) {
                                break;
                            } else if (f3 < paddingRight || i11 <= min) {
                                if (dVar5 != null && i11 == dVar5.f14071b) {
                                    f3 += dVar5.f14073d;
                                    i10++;
                                    if (i10 < this.f14058g.size()) {
                                        dVar5 = this.f14058g.get(i10);
                                    }
                                } else {
                                    d e2 = e(i11, i10);
                                    i10++;
                                    f3 += e2.f14073d;
                                    dVar5 = i10 < this.f14058g.size() ? this.f14058g.get(i10) : null;
                                }
                            } else if (dVar5 == null) {
                                break;
                            } else if (i11 == dVar5.f14071b && !dVar5.f14072c) {
                                this.f14058g.remove(i10);
                                this.j.destroyItem((ViewGroup) this, i11, dVar5.f14070a);
                                if (i10 < this.f14058g.size()) {
                                    dVar5 = this.f14058g.get(i10);
                                }
                            }
                        }
                    }
                    g(dVar2, i5, dVar);
                }
                this.j.setPrimaryItem((ViewGroup) this, this.k, dVar2 != null ? dVar2.f14070a : null);
                this.j.finishUpdate((ViewGroup) this);
                int childCount = getChildCount();
                for (int i12 = 0; i12 < childCount; i12++) {
                    View childAt = getChildAt(i12);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    layoutParams.f14065f = i12;
                    if (!layoutParams.f14060a && layoutParams.f14062c == 0.0f && (r = r(childAt)) != null) {
                        layoutParams.f14062c = r.f14073d;
                        layoutParams.f14064e = r.f14071b;
                    }
                }
                M();
                if (hasFocus()) {
                    View findFocus = findFocus();
                    d q = findFocus != null ? q(findFocus) : null;
                    if (q == null || q.f14071b != this.k) {
                        for (int i13 = 0; i13 < getChildCount(); i13++) {
                            View childAt2 = getChildAt(i13);
                            d r2 = r(childAt2);
                            if (r2 != null && r2.f14071b == this.k && childAt2.requestFocus(i2)) {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            try {
                hexString = getResources().getResourceName(getId());
            } catch (Resources.NotFoundException unused) {
                hexString = Integer.toHexString(getId());
            }
            throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f14056e + ", found: " + count + " Pager id: " + hexString + " Pager class: " + VerticalViewPager.class + " Problematic adapter: " + this.j.getClass());
        }
    }

    public final void F(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.f14058g.isEmpty()) {
            int scrollY = (int) ((getScrollY() / (((i2 - getPaddingTop()) - getPaddingBottom()) + i4)) * (((i - getPaddingTop()) - getPaddingBottom()) + i3));
            scrollTo(getScrollX(), scrollY);
            if (this.o.isFinished()) {
                return;
            }
            this.o.startScroll(0, scrollY, 0, (int) (t(this.k).f14074e * i), this.o.getDuration() - this.o.timePassed());
            return;
        }
        d t = t(this.k);
        int min = (int) ((t != null ? Math.min(t.f14074e, this.v) : 0.0f) * ((i - getPaddingTop()) - getPaddingBottom()));
        if (min != getScrollY()) {
            i(false);
            scrollTo(getScrollX(), min);
        }
    }

    public final void G() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((LayoutParams) getChildAt(i).getLayoutParams()).f14060a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public final void H(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public final void I(int i, boolean z, int i2, boolean z2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        ViewPager.OnPageChangeListener onPageChangeListener3;
        ViewPager.OnPageChangeListener onPageChangeListener4;
        d t = t(i);
        int clientHeight = t != null ? (int) (getClientHeight() * Math.max(this.u, Math.min(t.f14074e, this.v))) : 0;
        if (z) {
            L(0, clientHeight, i2);
            if (z2 && (onPageChangeListener4 = this.W) != null) {
                onPageChangeListener4.onPageSelected(i);
            }
            if (!z2 || (onPageChangeListener3 = this.a0) == null) {
                return;
            }
            onPageChangeListener3.onPageSelected(i);
            return;
        }
        if (z2 && (onPageChangeListener2 = this.W) != null) {
            onPageChangeListener2.onPageSelected(i);
        }
        if (z2 && (onPageChangeListener = this.a0) != null) {
            onPageChangeListener.onPageSelected(i);
        }
        i(false);
        scrollTo(0, clientHeight);
        A(clientHeight);
    }

    public void J(int i, boolean z, boolean z2) {
        K(i, z, z2, 0);
    }

    public void K(int i, boolean z, boolean z2, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        PagerAdapter pagerAdapter = this.j;
        if (pagerAdapter != null && pagerAdapter.getCount() > 0) {
            if (!z2 && this.k == i && this.f14058g.size() != 0 && !this.f14057f) {
                setScrollingCacheEnabled(false);
                return;
            }
            if (this.f14057f) {
                this.T = true;
            }
            if (i < 0) {
                i = 0;
            } else if (i >= this.j.getCount()) {
                i = this.j.getCount() - 1;
            }
            int i3 = this.A;
            int i4 = this.k;
            if (i > i4 + i3 || i < i4 - i3) {
                for (int i5 = 0; i5 < this.f14058g.size(); i5++) {
                    this.f14058g.get(i5).f14072c = true;
                }
            }
            boolean z3 = this.k != i;
            if (this.T) {
                this.k = i;
                if (z3 && (onPageChangeListener2 = this.W) != null) {
                    onPageChangeListener2.onPageSelected(i);
                }
                if (z3 && (onPageChangeListener = this.a0) != null) {
                    onPageChangeListener.onPageSelected(i);
                }
                requestLayout();
                return;
            }
            E(i);
            I(i, z, i2, z3);
            return;
        }
        setScrollingCacheEnabled(false);
    }

    public void L(int i, int i2, int i3) {
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            i(false);
            D();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientHeight = getClientHeight();
        int i6 = clientHeight / 2;
        float f2 = clientHeight;
        float f3 = i6;
        float l = f3 + (l(Math.min(1.0f, (Math.abs(i4) * 1.0f) / f2)) * f3);
        int abs2 = Math.abs(i3);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(l / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i4) / ((f2 * this.j.getPageWidth(this.k)) + this.q)) + 1.0f) * 100.0f);
        }
        this.o.startScroll(scrollX, scrollY, i4, i5, Math.min(abs, 600));
        ViewCompat.postInvalidateOnAnimation(this);
    }

    public final void M() {
        if (this.e0 != 0) {
            ArrayList<View> arrayList = this.f0;
            if (arrayList == null) {
                this.f0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.f0.add(getChildAt(i));
            }
            Collections.sort(this.f0, m0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        d r;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (r = r(childAt)) != null && r.f14071b == this.k) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        d r;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (r = r(childAt)) != null && r.f14071b == this.k) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean z = layoutParams2.f14060a | false;
        layoutParams2.f14060a = z;
        if (!this.x) {
            super.addView(view, i, layoutParams);
        } else if (layoutParams2 != null && z) {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        } else {
            layoutParams2.f14063d = true;
            addViewInLayout(view, i, layoutParams);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.o.isFinished() && this.o.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.o.getCurrX();
            int currY = this.o.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!A(currY)) {
                    this.o.abortAnimation();
                    scrollTo(currX, 0);
                }
            }
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        i(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || o(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        d r;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (r = r(childAt)) != null && r.f14071b == this.k && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        super.draw(canvas);
        int overScrollMode = ViewCompat.getOverScrollMode(this);
        boolean z = false;
        if (overScrollMode != 0 && (overScrollMode != 1 || (pagerAdapter = this.j) == null || pagerAdapter.getCount() <= 1)) {
            this.R.finish();
            this.S.finish();
        } else {
            if (!this.R.isFinished()) {
                int save = canvas.save();
                int height = getHeight();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate(getPaddingLeft(), this.u * height);
                this.R.setSize(width, height);
                z = false | this.R.draw(canvas);
                if (save >= 1 && save <= canvas.getSaveCount()) {
                    canvas.restoreToCount(save);
                }
            }
            if (!this.S.isFinished()) {
                int save2 = canvas.save();
                int height2 = getHeight();
                int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.rotate(180.0f);
                canvas.translate((-width2) - getPaddingLeft(), (-(this.v + 1.0f)) * height2);
                this.S.setSize(width2, height2);
                z |= this.S.draw(canvas);
                if (save2 >= 1 && save2 <= canvas.getSaveCount()) {
                    canvas.restoreToCount(save2);
                }
            }
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.r;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public d e(int i, int i2) {
        d dVar = new d();
        dVar.f14071b = i;
        dVar.f14070a = this.j.instantiateItem((ViewGroup) this, i);
        dVar.f14073d = this.j.getPageWidth(i);
        if (i2 >= 0 && i2 < this.f14058g.size()) {
            this.f14058g.add(i2, dVar);
        } else {
            this.f14058g.add(dVar);
        }
        return dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(int i) {
        boolean z;
        View findNextFocus;
        boolean requestFocus;
        View findFocus = findFocus();
        boolean z2 = false;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z = false;
                        break;
                    } else if (parent == this) {
                        z = true;
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
                if (!z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    Log.e(ViewPager.TAG, "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                }
            }
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
            if (findNextFocus == null && findNextFocus != findFocus) {
                if (i == 33) {
                    int i2 = p(this.i, findNextFocus).top;
                    int i3 = p(this.i, findFocus).top;
                    if (findFocus != null && i2 >= i3) {
                        requestFocus = B();
                    } else {
                        requestFocus = findNextFocus.requestFocus();
                    }
                } else if (i == 130) {
                    int i4 = p(this.i, findNextFocus).bottom;
                    int i5 = p(this.i, findFocus).bottom;
                    if (findFocus != null && i4 <= i5) {
                        requestFocus = z();
                    } else {
                        requestFocus = findNextFocus.requestFocus();
                    }
                }
                z2 = requestFocus;
            } else if (i != 33 || i == 1) {
                z2 = B();
            } else if (i == 130 || i == 2) {
                z2 = z();
            }
            if (z2) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            return z2;
        }
        findFocus = null;
        findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        if (findNextFocus == null) {
        }
        if (i != 33) {
        }
        z2 = B();
        if (z2) {
        }
        return z2;
    }

    public final void g(d dVar, int i, d dVar2) {
        int i2;
        int i3;
        d dVar3;
        d dVar4;
        int count = this.j.getCount();
        int clientHeight = getClientHeight();
        float f2 = clientHeight > 0 ? this.q / clientHeight : 0.0f;
        if (dVar2 != null) {
            int i4 = dVar2.f14071b;
            int i5 = dVar.f14071b;
            if (i4 < i5) {
                int i6 = 0;
                float f3 = dVar2.f14074e + dVar2.f14073d + f2;
                while (true) {
                    i4++;
                    if (i4 > dVar.f14071b || i6 >= this.f14058g.size()) {
                        break;
                    }
                    d dVar5 = this.f14058g.get(i6);
                    while (true) {
                        dVar4 = dVar5;
                        if (i4 <= dVar4.f14071b || i6 >= this.f14058g.size() - 1) {
                            break;
                        }
                        i6++;
                        dVar5 = this.f14058g.get(i6);
                    }
                    while (i4 < dVar4.f14071b) {
                        f3 += this.j.getPageWidth(i4) + f2;
                        i4++;
                    }
                    dVar4.f14074e = f3;
                    f3 += dVar4.f14073d + f2;
                }
            } else if (i4 > i5) {
                int size = this.f14058g.size() - 1;
                float f4 = dVar2.f14074e;
                while (true) {
                    i4--;
                    if (i4 < dVar.f14071b || size < 0) {
                        break;
                    }
                    d dVar6 = this.f14058g.get(size);
                    while (true) {
                        dVar3 = dVar6;
                        if (i4 >= dVar3.f14071b || size <= 0) {
                            break;
                        }
                        size--;
                        dVar6 = this.f14058g.get(size);
                    }
                    while (i4 > dVar3.f14071b) {
                        f4 -= this.j.getPageWidth(i4) + f2;
                        i4--;
                    }
                    f4 -= dVar3.f14073d + f2;
                    dVar3.f14074e = f4;
                }
            }
        }
        int size2 = this.f14058g.size();
        float f5 = dVar.f14074e;
        int i7 = dVar.f14071b;
        int i8 = i7 - 1;
        this.u = i7 == 0 ? f5 : -3.4028235E38f;
        int i9 = count - 1;
        this.v = dVar.f14071b == i9 ? (dVar.f14074e + dVar.f14073d) - 1.0f : Float.MAX_VALUE;
        int i10 = i - 1;
        while (i10 >= 0) {
            d dVar7 = this.f14058g.get(i10);
            while (true) {
                i3 = dVar7.f14071b;
                if (i8 <= i3) {
                    break;
                }
                f5 -= this.j.getPageWidth(i8) + f2;
                i8--;
            }
            f5 -= dVar7.f14073d + f2;
            dVar7.f14074e = f5;
            if (i3 == 0) {
                this.u = f5;
            }
            i10--;
            i8--;
        }
        float f6 = dVar.f14074e + dVar.f14073d + f2;
        int i11 = dVar.f14071b + 1;
        int i12 = i + 1;
        while (i12 < size2) {
            d dVar8 = this.f14058g.get(i12);
            while (true) {
                i2 = dVar8.f14071b;
                if (i11 >= i2) {
                    break;
                }
                f6 += this.j.getPageWidth(i11) + f2;
                i11++;
            }
            if (i2 == i9) {
                this.v = (dVar8.f14073d + f6) - 1.0f;
            }
            dVar8.f14074e = f6;
            f6 += dVar8.f14073d + f2;
            i12++;
            i11++;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public PagerAdapter getAdapter() {
        return this.j;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        if (this.e0 == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) this.f0.get(i2).getLayoutParams()).f14065f;
    }

    public int getCurrentItem() {
        return this.k;
    }

    public int getOffscreenPageLimit() {
        return this.A;
    }

    public int getPageMargin() {
        return this.q;
    }

    public boolean h(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i3 + scrollY;
                if (i5 >= childAt.getTop() && i5 < childAt.getBottom() && (i4 = i2 + scrollX) >= childAt.getLeft() && i4 < childAt.getRight() && h(childAt, true, i, i4 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && ViewCompat.canScrollVertically(view, -i);
    }

    public final void i(boolean z) {
        boolean z2 = this.h0 == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            this.o.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.o.getCurrX();
            int currY = this.o.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
        }
        this.z = false;
        for (int i = 0; i < this.f14058g.size(); i++) {
            d dVar = this.f14058g.get(i);
            if (dVar.f14072c) {
                dVar.f14072c = false;
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                ViewCompat.postOnAnimation(this, this.g0);
            } else {
                this.g0.run();
            }
        }
    }

    public void j() {
        int count = this.j.getCount();
        this.f14056e = count;
        boolean z = this.f14058g.size() < (this.A * 2) + 1 && this.f14058g.size() < count;
        int i = this.k;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.f14058g.size()) {
            d dVar = this.f14058g.get(i2);
            int itemPosition = this.j.getItemPosition(dVar.f14070a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.f14058g.remove(i2);
                    i2--;
                    if (!z2) {
                        this.j.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.j.destroyItem((ViewGroup) this, dVar.f14071b, dVar.f14070a);
                    int i3 = this.k;
                    if (i3 == dVar.f14071b) {
                        i = Math.max(0, Math.min(i3, count - 1));
                    }
                } else {
                    int i4 = dVar.f14071b;
                    if (i4 != itemPosition) {
                        if (i4 == this.k) {
                            i = itemPosition;
                        }
                        dVar.f14071b = itemPosition;
                    }
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.j.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f14058g, k0);
        if (z) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i5).getLayoutParams();
                if (!layoutParams.f14060a) {
                    layoutParams.f14062c = 0.0f;
                }
            }
            J(i, false, true);
            requestLayout();
        }
    }

    public final int k(int i, float f2, int i2, int i3) {
        if (Math.abs(i3) <= this.O || Math.abs(i2) <= this.M) {
            i = (int) (i + f2 + (i >= this.k ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f14058g.size() > 0) {
            ArrayList<d> arrayList = this.f14058g;
            return Math.max(this.f14058g.get(0).f14071b, Math.min(i, arrayList.get(arrayList.size() - 1).f14071b));
        }
        return i;
    }

    public float l(float f2) {
        return (float) Math.sin((float) ((f2 - 0.5f) * 0.4712389167638204d));
    }

    public final void m(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewCompat.setLayerType(getChildAt(i), z ? 2 : 0, null);
        }
    }

    public final void n() {
        this.B = false;
        this.C = false;
        VelocityTracker velocityTracker = this.L;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.L = null;
        }
    }

    public boolean o(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                return f(17);
            }
            if (keyCode != 22) {
                if (keyCode == 61 && Build.VERSION.SDK_INT >= 11) {
                    if (keyEvent.hasNoModifiers()) {
                        return f(2);
                    }
                    if (keyEvent.hasModifiers(1)) {
                        return f(1);
                    }
                }
            } else {
                return f(66);
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.T = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.g0);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int height;
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.q <= 0 || this.r == null || this.f14058g.size() <= 0 || this.j == null) {
            return;
        }
        int scrollY = getScrollY();
        float height2 = getHeight();
        float f4 = this.q / height2;
        int i = 0;
        d dVar = this.f14058g.get(0);
        float f5 = dVar.f14074e;
        int size = this.f14058g.size();
        int i2 = dVar.f14071b;
        int i3 = this.f14058g.get(size - 1).f14071b;
        while (i2 < i3) {
            while (i2 > dVar.f14071b && i < size) {
                i++;
                dVar = this.f14058g.get(i);
            }
            if (i2 == dVar.f14071b) {
                float f6 = dVar.f14074e;
                float f7 = dVar.f14073d;
                f2 = (f6 + f7) * height2;
                f5 = f6 + f7 + f4;
            } else {
                float pageWidth = this.j.getPageWidth(i2);
                f2 = (f5 + pageWidth) * height2;
                f5 += pageWidth + f4;
            }
            int i4 = this.q;
            if (i4 + f2 > scrollY) {
                f3 = f4;
                this.r.setBounds(this.s, (int) f2, this.t, (int) (i4 + f2 + 0.5f));
                this.r.draw(canvas);
            } else {
                f3 = f4;
            }
            if (f2 > scrollY + height) {
                return;
            }
            i2++;
            f4 = f3;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action != 3 && action != 1) {
            if (action != 0) {
                if (this.B) {
                    return true;
                }
                if (this.C) {
                    return false;
                }
            }
            if (action == 0) {
                float x = motionEvent.getX();
                this.I = x;
                this.G = x;
                float y = motionEvent.getY();
                this.J = y;
                this.H = y;
                this.K = MotionEventCompat.getPointerId(motionEvent, 0);
                this.C = false;
                this.o.computeScrollOffset();
                if (this.h0 == 2 && Math.abs(this.o.getFinalY() - this.o.getCurrY()) > this.P) {
                    this.o.abortAnimation();
                    this.z = false;
                    D();
                    this.B = true;
                    H(true);
                    setScrollState(1);
                } else {
                    i(false);
                    this.B = false;
                }
            } else if (action == 2) {
                int i = this.K;
                if (i != -1) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
                    float y2 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                    float f2 = y2 - this.H;
                    float abs = Math.abs(f2);
                    float x2 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                    float abs2 = Math.abs(x2 - this.I);
                    int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                    if (i2 != 0 && !w(this.H, f2) && h(this, false, (int) f2, (int) x2, (int) y2)) {
                        this.G = x2;
                        this.H = y2;
                        this.C = true;
                        return false;
                    }
                    if (abs > this.F && abs * 0.5f > abs2) {
                        this.B = true;
                        H(true);
                        setScrollState(1);
                        float f3 = this.J;
                        float f4 = this.F;
                        this.H = i2 > 0 ? f3 + f4 : f3 - f4;
                        this.G = x2;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > this.F) {
                        this.C = true;
                    }
                    if (this.B && C(y2)) {
                        ViewCompat.postInvalidateOnAnimation(this);
                    }
                }
            } else if (action == 6) {
                y(motionEvent);
            }
            if (this.L == null) {
                this.L = VelocityTracker.obtain();
            }
            this.L.addMovement(motionEvent);
            return this.B;
        }
        this.B = false;
        this.C = false;
        this.K = -1;
        VelocityTracker velocityTracker = this.L;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.L = null;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        d r;
        int max;
        int i5;
        int max2;
        int i6;
        int childCount = getChildCount();
        int i7 = i3 - i;
        int i8 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollY = getScrollY();
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f14060a) {
                    int i11 = layoutParams.f14061b;
                    int i12 = i11 & 7;
                    int i13 = i11 & 112;
                    if (i12 == 1) {
                        max = Math.max((i7 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    } else {
                        if (i12 == 3) {
                            i5 = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i12 != 5) {
                            i5 = paddingLeft;
                        } else {
                            max = (i7 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i13 != 16) {
                            max2 = Math.max((i8 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        } else {
                            if (i13 == 48) {
                                i6 = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i13 != 80) {
                                i6 = paddingTop;
                            } else {
                                max2 = (i8 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i14 = paddingTop + scrollY;
                            childAt.layout(paddingLeft, i14, childAt.getMeasuredWidth() + paddingLeft, i14 + childAt.getMeasuredHeight());
                            i9++;
                            paddingTop = i6;
                            paddingLeft = i5;
                        }
                        int i15 = max2;
                        i6 = paddingTop;
                        paddingTop = i15;
                        int i142 = paddingTop + scrollY;
                        childAt.layout(paddingLeft, i142, childAt.getMeasuredWidth() + paddingLeft, i142 + childAt.getMeasuredHeight());
                        i9++;
                        paddingTop = i6;
                        paddingLeft = i5;
                    }
                    int i16 = max;
                    i5 = paddingLeft;
                    paddingLeft = i16;
                    if (i13 != 16) {
                    }
                    int i152 = max2;
                    i6 = paddingTop;
                    paddingTop = i152;
                    int i1422 = paddingTop + scrollY;
                    childAt.layout(paddingLeft, i1422, childAt.getMeasuredWidth() + paddingLeft, i1422 + childAt.getMeasuredHeight());
                    i9++;
                    paddingTop = i6;
                    paddingLeft = i5;
                }
            }
        }
        int i17 = (i8 - paddingTop) - paddingBottom;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.f14060a && (r = r(childAt2)) != null) {
                    float f2 = i17;
                    int i19 = ((int) (r.f14074e * f2)) + paddingTop;
                    if (layoutParams2.f14063d) {
                        layoutParams2.f14063d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((i7 - paddingLeft) - paddingRight, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (f2 * layoutParams2.f14062c), 1073741824));
                    }
                    childAt2.layout(paddingLeft, i19, childAt2.getMeasuredWidth() + paddingLeft, childAt2.getMeasuredHeight() + i19);
                }
            }
        }
        this.s = paddingLeft;
        this.t = i7 - paddingRight;
        this.V = i9;
        if (this.T) {
            z2 = false;
            I(this.k, false, 0, false);
        } else {
            z2 = false;
        }
        this.T = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        int i3;
        int i4;
        int i5;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, i), ViewGroup.getDefaultSize(0, i2));
        int measuredHeight = getMeasuredHeight();
        this.E = Math.min(measuredHeight / 10, this.D);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (measuredHeight - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            boolean z = true;
            int i7 = 1073741824;
            if (i6 >= childCount) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.f14060a) {
                int i8 = layoutParams2.f14061b;
                int i9 = i8 & 7;
                int i10 = i8 & 112;
                boolean z2 = i10 == 48 || i10 == 80;
                if (i9 != 3 && i9 != 5) {
                    z = false;
                }
                int i11 = Integer.MIN_VALUE;
                if (z2) {
                    i11 = 1073741824;
                } else if (z) {
                    i3 = 1073741824;
                    i4 = ((ViewGroup.LayoutParams) layoutParams2).width;
                    if (i4 == -2) {
                        if (i4 == -1) {
                            i4 = measuredWidth;
                        }
                        i11 = 1073741824;
                    } else {
                        i4 = measuredWidth;
                    }
                    i5 = ((ViewGroup.LayoutParams) layoutParams2).height;
                    if (i5 != -2) {
                        i5 = paddingTop;
                        i7 = i3;
                    } else if (i5 == -1) {
                        i5 = paddingTop;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i11), View.MeasureSpec.makeMeasureSpec(i5, i7));
                    if (!z2) {
                        paddingTop -= childAt.getMeasuredHeight();
                    } else if (z) {
                        measuredWidth -= childAt.getMeasuredWidth();
                    }
                }
                i3 = Integer.MIN_VALUE;
                i4 = ((ViewGroup.LayoutParams) layoutParams2).width;
                if (i4 == -2) {
                }
                i5 = ((ViewGroup.LayoutParams) layoutParams2).height;
                if (i5 != -2) {
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i11), View.MeasureSpec.makeMeasureSpec(i5, i7));
                if (!z2) {
                }
            }
            i6++;
        }
        this.w = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
        this.x = true;
        D();
        this.x = false;
        int childCount2 = getChildCount();
        for (int i12 = 0; i12 < childCount2; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.f14060a)) {
                childAt2.measure(this.w, View.MeasureSpec.makeMeasureSpec((int) (paddingTop * layoutParams.f14062c), 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        d r;
        int childCount = getChildCount();
        int i4 = -1;
        if ((i & 2) != 0) {
            i4 = childCount;
            i2 = 0;
            i3 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
        }
        while (i2 != i4) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (r = r(childAt)) != null && r.f14071b == this.k && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i3;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        PagerAdapter pagerAdapter = this.j;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(savedState.f14067f, savedState.f14068g);
            J(savedState.f14066e, false, true);
            return;
        }
        this.l = savedState.f14066e;
        this.m = savedState.f14067f;
        this.n = savedState.f14068g;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f14066e = this.k;
        PagerAdapter pagerAdapter = this.j;
        if (pagerAdapter != null) {
            savedState.f14067f = pagerAdapter.saveState();
        }
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i2 != i4) {
            int i5 = this.q;
            F(i2, i4, i5, i5);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter pagerAdapter;
        boolean onRelease;
        boolean onRelease2;
        if (this.Q) {
            return true;
        }
        this.i0.d(motionEvent);
        boolean z = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.j) == null || pagerAdapter.getCount() == 0) {
            return false;
        }
        if (this.L == null) {
            this.L = VelocityTracker.obtain();
        }
        this.L.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.o.abortAnimation();
            this.z = false;
            D();
            float x = motionEvent.getX();
            this.I = x;
            this.G = x;
            float y = motionEvent.getY();
            this.J = y;
            this.H = y;
            this.K = MotionEventCompat.getPointerId(motionEvent, 0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.B) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.K);
                    float y2 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                    float abs = Math.abs(y2 - this.H);
                    float x2 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                    float abs2 = Math.abs(x2 - this.G);
                    if (abs > this.F && abs > abs2) {
                        this.B = true;
                        H(true);
                        float f2 = this.J;
                        this.H = y2 - f2 > 0.0f ? f2 + this.F : f2 - this.F;
                        this.G = x2;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.B) {
                    z = false | C(MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.K)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    this.H = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.K = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                } else if (action == 6) {
                    y(motionEvent);
                    this.H = MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.K));
                }
            } else if (this.B) {
                I(this.k, true, 0, false);
                this.K = -1;
                n();
                onRelease = this.R.onRelease();
                onRelease2 = this.S.onRelease();
                z = onRelease | onRelease2;
            }
        } else if (this.B) {
            VelocityTracker velocityTracker = this.L;
            velocityTracker.computeCurrentVelocity(1000, this.N);
            int yVelocity = (int) VelocityTrackerCompat.getYVelocity(velocityTracker, this.K);
            this.z = true;
            int clientHeight = getClientHeight();
            int scrollY = getScrollY();
            d s = s();
            K(k(s.f14071b, ((scrollY / clientHeight) - s.f14074e) / s.f14073d, yVelocity, (int) (MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.K)) - this.J)), true, true, yVelocity);
            this.K = -1;
            n();
            onRelease = this.R.onRelease();
            onRelease2 = this.S.onRelease();
            z = onRelease | onRelease2;
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
        return true;
    }

    public final Rect p(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    public d q(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return r(view);
            }
        }
    }

    public d r(View view) {
        for (int i = 0; i < this.f14058g.size(); i++) {
            d dVar = this.f14058g.get(i);
            if (this.j.isViewFromObject(view, dVar.f14070a)) {
                return dVar;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.x) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public final d s() {
        int i;
        int clientHeight = getClientHeight();
        float f2 = 0.0f;
        float scrollY = clientHeight > 0 ? getScrollY() / clientHeight : 0.0f;
        float f3 = clientHeight > 0 ? this.q / clientHeight : 0.0f;
        d dVar = null;
        float f4 = 0.0f;
        int i2 = -1;
        int i3 = 0;
        boolean z = true;
        while (i3 < this.f14058g.size()) {
            d dVar2 = this.f14058g.get(i3);
            if (!z && dVar2.f14071b != (i = i2 + 1)) {
                dVar2 = this.f14059h;
                dVar2.f14074e = f2 + f4 + f3;
                dVar2.f14071b = i;
                dVar2.f14073d = this.j.getPageWidth(i);
                i3--;
            }
            f2 = dVar2.f14074e;
            float f5 = dVar2.f14073d + f2 + f3;
            if (!z && scrollY < f2) {
                return dVar;
            }
            if (scrollY < f5 || i3 == this.f14058g.size() - 1) {
                return dVar2;
            }
            i2 = dVar2.f14071b;
            f4 = dVar2.f14073d;
            i3++;
            dVar = dVar2;
            z = false;
        }
        return dVar;
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        PagerAdapter pagerAdapter2 = this.j;
        if (pagerAdapter2 != null) {
            pagerAdapter2.unregisterDataSetObserver(this.p);
            this.j.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.f14058g.size(); i++) {
                d dVar = this.f14058g.get(i);
                this.j.destroyItem((ViewGroup) this, dVar.f14071b, dVar.f14070a);
            }
            this.j.finishUpdate((ViewGroup) this);
            this.f14058g.clear();
            G();
            this.k = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter3 = this.j;
        this.j = pagerAdapter;
        this.f14056e = 0;
        if (pagerAdapter != null) {
            if (this.p == null) {
                this.p = new g(this, null);
            }
            this.j.registerDataSetObserver(this.p);
            this.z = false;
            boolean z = this.T;
            this.T = true;
            this.f14056e = this.j.getCount();
            if (this.l >= 0) {
                this.j.restoreState(this.m, this.n);
                J(this.l, false, true);
                this.l = -1;
                this.m = null;
                this.n = null;
            } else if (!z) {
                D();
            } else {
                requestLayout();
            }
        }
        f fVar = this.b0;
        if (fVar == null || pagerAdapter3 == pagerAdapter) {
            return;
        }
        fVar.a(pagerAdapter3, pagerAdapter);
    }

    public void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (Build.VERSION.SDK_INT >= 7) {
            if (this.d0 == null) {
                try {
                    this.d0 = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
                } catch (NoSuchMethodException e2) {
                    Log.e(ViewPager.TAG, "Can't find setChildrenDrawingOrderEnabled", e2);
                }
            }
            try {
                this.d0.invoke(this, Boolean.valueOf(z));
            } catch (Exception e3) {
                Log.e(ViewPager.TAG, "Error changing children drawing order", e3);
            }
        }
    }

    public void setCurrentItem(int i) {
        this.z = false;
        J(i, !this.T, false);
    }

    public void setEventListener(a.b bVar) {
        d.b.i0.b1.p.a aVar = this.i0;
        if (aVar != null) {
            aVar.f(bVar);
        }
    }

    public void setNeedHanleTouch(boolean z) {
        this.f14057f = z;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w(ViewPager.TAG, "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.A) {
            this.A = i;
            D();
        }
    }

    public void setOnAdapterChangeListener(f fVar) {
        this.b0 = fVar;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.W = onPageChangeListener;
    }

    public void setPageMargin(int i) {
        int i2 = this.q;
        this.q = i;
        int height = getHeight();
        F(height, height, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.r = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z, ViewPager.PageTransformer pageTransformer) {
        if (Build.VERSION.SDK_INT >= 11) {
            boolean z2 = pageTransformer != null;
            boolean z3 = z2 != (this.c0 != null);
            this.c0 = pageTransformer;
            setChildrenDrawingOrderEnabledCompat(z2);
            if (z2) {
                this.e0 = z ? 2 : 1;
            } else {
                this.e0 = 0;
            }
            if (z3) {
                D();
            }
        }
    }

    public d t(int i) {
        for (int i2 = 0; i2 < this.f14058g.size(); i2++) {
            d dVar = this.f14058g.get(i2);
            if (dVar.f14071b == i) {
                return dVar;
            }
        }
        return null;
    }

    public void u() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.o = new Scroller(context, l0);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.F = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        this.M = (int) (400.0f * f2);
        this.N = viewConfiguration.getScaledMaximumFlingVelocity();
        this.R = new EdgeEffectCompat(context);
        this.S = new EdgeEffectCompat(context);
        this.O = (int) (25.0f * f2);
        this.P = (int) (2.0f * f2);
        this.D = (int) (f2 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new e());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        this.i0 = new d.b.i0.b1.p.a(this);
    }

    public boolean v(int i) {
        if (this.j == null) {
            return false;
        }
        int clientHeight = getClientHeight();
        int scrollY = getScrollY();
        return i < 0 ? scrollY > ((int) (((float) clientHeight) * this.u)) : i > 0 && scrollY < ((int) (((float) clientHeight) * this.v));
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.r;
    }

    public final boolean w(float f2, float f3) {
        return (f2 < ((float) this.E) && f3 > 0.0f) || (f2 > ((float) (getHeight() - this.E)) && f3 < 0.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void x(int i, float f2, int i2) {
        int max;
        int i3;
        int top;
        if (this.V > 0) {
            int scrollY = getScrollY();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f14060a) {
                    int i5 = layoutParams.f14061b & 112;
                    if (i5 == 16) {
                        max = Math.max((height - childAt.getMeasuredHeight()) / 2, paddingTop);
                    } else {
                        if (i5 == 48) {
                            i3 = childAt.getHeight() + paddingTop;
                        } else if (i5 != 80) {
                            i3 = paddingTop;
                        } else {
                            max = (height - paddingBottom) - childAt.getMeasuredHeight();
                            paddingBottom += childAt.getMeasuredHeight();
                        }
                        top = (paddingTop + scrollY) - childAt.getTop();
                        if (top != 0) {
                            childAt.offsetTopAndBottom(top);
                        }
                        paddingTop = i3;
                    }
                    int i6 = max;
                    i3 = paddingTop;
                    paddingTop = i6;
                    top = (paddingTop + scrollY) - childAt.getTop();
                    if (top != 0) {
                    }
                    paddingTop = i3;
                }
            }
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.W;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i, f2, i2);
        }
        ViewPager.OnPageChangeListener onPageChangeListener2 = this.a0;
        if (onPageChangeListener2 != null) {
            onPageChangeListener2.onPageScrolled(i, f2, i2);
        }
        if (this.c0 != null) {
            int scrollY2 = getScrollY();
            int childCount2 = getChildCount();
            for (int i7 = 0; i7 < childCount2; i7++) {
                View childAt2 = getChildAt(i7);
                if (!((LayoutParams) childAt2.getLayoutParams()).f14060a) {
                    this.c0.transformPage(childAt2, (childAt2.getTop() - scrollY2) / getClientHeight());
                }
            }
        }
        this.U = true;
    }

    public final void y(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.K) {
            int i = actionIndex == 0 ? 1 : 0;
            this.H = MotionEventCompat.getY(motionEvent, i);
            this.K = MotionEventCompat.getPointerId(motionEvent, i);
            VelocityTracker velocityTracker = this.L;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public boolean z() {
        PagerAdapter pagerAdapter = this.j;
        if (pagerAdapter == null || this.k >= pagerAdapter.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.k + 1, true);
        return true;
    }

    /* loaded from: classes3.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public boolean f14060a;

        /* renamed from: b  reason: collision with root package name */
        public int f14061b;

        /* renamed from: c  reason: collision with root package name */
        public float f14062c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f14063d;

        /* renamed from: e  reason: collision with root package name */
        public int f14064e;

        /* renamed from: f  reason: collision with root package name */
        public int f14065f;

        public LayoutParams() {
            super(-1, -1);
            this.f14062c = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f14062c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, VerticalViewPager.j0);
            this.f14061b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setCurrentItem(int i, boolean z) {
        this.z = false;
        J(i, z, false);
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public VerticalViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14058g = new ArrayList<>();
        this.f14059h = new d();
        this.i = new Rect();
        this.l = -1;
        this.m = null;
        this.n = null;
        this.u = -3.4028235E38f;
        this.v = Float.MAX_VALUE;
        this.A = 1;
        this.K = -1;
        this.T = true;
        this.g0 = new c();
        this.h0 = 0;
        u();
    }
}
