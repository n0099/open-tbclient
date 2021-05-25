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
import d.a.m0.b1.p.a;
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
    public int f13345e;
    public int e0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13346f;
    public ArrayList<View> f0;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList<d> f13347g;
    public final Runnable g0;

    /* renamed from: h  reason: collision with root package name */
    public final d f13348h;
    public int h0;

    /* renamed from: i  reason: collision with root package name */
    public final Rect f13349i;
    public d.a.m0.b1.p.a i0;
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
        public int f13356e;

        /* renamed from: f  reason: collision with root package name */
        public Parcelable f13357f;

        /* renamed from: g  reason: collision with root package name */
        public ClassLoader f13358g;

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
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f13356e + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f13356e);
            parcel.writeParcelable(this.f13357f, i2);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? SavedState.class.getClassLoader() : classLoader;
            this.f13356e = parcel.readInt();
            this.f13357f = parcel.readParcelable(classLoader);
            this.f13358g = classLoader;
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements Comparator<d> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            return dVar.f13361b - dVar2.f13361b;
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
        public Object f13360a;

        /* renamed from: b  reason: collision with root package name */
        public int f13361b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f13362c;

        /* renamed from: d  reason: collision with root package name */
        public float f13363d;

        /* renamed from: e  reason: collision with root package name */
        public float f13364e;
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
        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            if (super.performAccessibilityAction(view, i2, bundle)) {
                return true;
            }
            if (i2 != 4096) {
                if (i2 == 8192 && VerticalViewPager.this.v(-1)) {
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
            boolean z = layoutParams.f13350a;
            if (z != layoutParams2.f13350a) {
                return z ? 1 : -1;
            }
            return layoutParams.f13354e - layoutParams2.f13354e;
        }
    }

    public VerticalViewPager(Context context) {
        super(context);
        this.f13347g = new ArrayList<>();
        this.f13348h = new d();
        this.f13349i = new Rect();
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
    public void setScrollState(int i2) {
        if (this.h0 == i2) {
            return;
        }
        this.h0 = i2;
        if (this.c0 != null) {
            m(i2 != 0);
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.W;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i2);
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.y != z) {
            this.y = z;
        }
    }

    public boolean A(int i2) {
        if (this.f13347g.size() == 0) {
            this.U = false;
            x(0, 0.0f, 0);
            if (this.U) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        d s = s();
        int clientHeight = getClientHeight();
        int i3 = this.q;
        int i4 = clientHeight + i3;
        float f2 = clientHeight;
        int i5 = s.f13361b;
        float f3 = ((i2 / f2) - s.f13364e) / (s.f13363d + (i3 / f2));
        this.U = false;
        x(i5, f3, (int) (i4 * f3));
        if (this.U) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public boolean B() {
        int i2 = this.k;
        if (i2 > 0) {
            setCurrentItem(i2 - 1, true);
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
        d dVar = this.f13347g.get(0);
        ArrayList<d> arrayList = this.f13347g;
        boolean z2 = true;
        d dVar2 = arrayList.get(arrayList.size() - 1);
        if (dVar.f13361b != 0) {
            f4 = dVar.f13364e * clientHeight;
            z = false;
        } else {
            z = true;
        }
        if (dVar2.f13361b != this.j.getCount() - 1) {
            f5 = dVar2.f13364e * clientHeight;
            z2 = false;
        }
        if (scrollY < f4) {
            r4 = z ? this.R.onPull(Math.abs(f4 - scrollY) / clientHeight) : false;
            scrollY = f4;
        } else if (scrollY > f5) {
            r4 = z2 ? this.S.onPull(Math.abs(scrollY - f5) / clientHeight) : false;
            scrollY = f5;
        }
        int i2 = (int) scrollY;
        this.G += scrollY - i2;
        scrollTo(getScrollX(), i2);
        A(i2);
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
    public void E(int i2) {
        int i3;
        d dVar;
        String hexString;
        d dVar2;
        d r;
        d dVar3;
        int i4 = this.k;
        if (i4 != i2) {
            i3 = i4 < i2 ? IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER : 33;
            dVar = t(this.k);
            this.k = i2;
        } else {
            i3 = 2;
            dVar = null;
        }
        if (this.j == null) {
            M();
        } else if (this.z) {
            M();
        } else if (getWindowToken() != null) {
            this.j.startUpdate((ViewGroup) this);
            int i5 = this.A;
            int max = Math.max(0, this.k - i5);
            int count = this.j.getCount();
            int min = Math.min(count - 1, this.k + i5);
            if (count == this.f13345e) {
                int i6 = 0;
                while (true) {
                    if (i6 >= this.f13347g.size()) {
                        break;
                    }
                    dVar2 = this.f13347g.get(i6);
                    int i7 = dVar2.f13361b;
                    int i8 = this.k;
                    if (i7 < i8) {
                        i6++;
                    }
                }
                dVar2 = null;
                if (dVar2 == null && count > 0) {
                    dVar2 = e(this.k, i6);
                }
                if (dVar2 != null) {
                    int i9 = i6 - 1;
                    d dVar4 = i9 >= 0 ? this.f13347g.get(i9) : null;
                    int clientHeight = getClientHeight();
                    float paddingLeft = clientHeight <= 0 ? 0.0f : (2.0f - dVar2.f13363d) + (getPaddingLeft() / clientHeight);
                    float f2 = 0.0f;
                    for (int i10 = this.k - 1; i10 >= 0; i10--) {
                        if (f2 < paddingLeft || i10 >= max) {
                            if (dVar4 != null && i10 == dVar4.f13361b) {
                                f2 += dVar4.f13363d;
                                i9--;
                                if (i9 >= 0) {
                                    dVar3 = this.f13347g.get(i9);
                                    dVar4 = dVar3;
                                }
                                dVar3 = null;
                                dVar4 = dVar3;
                            } else {
                                f2 += e(i10, i9 + 1).f13363d;
                                i6++;
                                if (i9 >= 0) {
                                    dVar3 = this.f13347g.get(i9);
                                    dVar4 = dVar3;
                                }
                                dVar3 = null;
                                dVar4 = dVar3;
                            }
                        } else if (dVar4 == null) {
                            break;
                        } else {
                            if (i10 == dVar4.f13361b && !dVar4.f13362c) {
                                this.f13347g.remove(i9);
                                this.j.destroyItem((ViewGroup) this, i10, dVar4.f13360a);
                                i9--;
                                i6--;
                                if (i9 >= 0) {
                                    dVar3 = this.f13347g.get(i9);
                                    dVar4 = dVar3;
                                }
                                dVar3 = null;
                                dVar4 = dVar3;
                            }
                        }
                    }
                    float f3 = dVar2.f13363d;
                    int i11 = i6 + 1;
                    if (f3 < 2.0f) {
                        d dVar5 = i11 < this.f13347g.size() ? this.f13347g.get(i11) : null;
                        float paddingRight = clientHeight <= 0 ? 0.0f : (getPaddingRight() / clientHeight) + 2.0f;
                        int i12 = this.k;
                        while (true) {
                            i12++;
                            if (i12 >= count) {
                                break;
                            } else if (f3 < paddingRight || i12 <= min) {
                                if (dVar5 != null && i12 == dVar5.f13361b) {
                                    f3 += dVar5.f13363d;
                                    i11++;
                                    if (i11 < this.f13347g.size()) {
                                        dVar5 = this.f13347g.get(i11);
                                    }
                                } else {
                                    d e2 = e(i12, i11);
                                    i11++;
                                    f3 += e2.f13363d;
                                    dVar5 = i11 < this.f13347g.size() ? this.f13347g.get(i11) : null;
                                }
                            } else if (dVar5 == null) {
                                break;
                            } else if (i12 == dVar5.f13361b && !dVar5.f13362c) {
                                this.f13347g.remove(i11);
                                this.j.destroyItem((ViewGroup) this, i12, dVar5.f13360a);
                                if (i11 < this.f13347g.size()) {
                                    dVar5 = this.f13347g.get(i11);
                                }
                            }
                        }
                    }
                    g(dVar2, i6, dVar);
                }
                this.j.setPrimaryItem((ViewGroup) this, this.k, dVar2 != null ? dVar2.f13360a : null);
                this.j.finishUpdate((ViewGroup) this);
                int childCount = getChildCount();
                for (int i13 = 0; i13 < childCount; i13++) {
                    View childAt = getChildAt(i13);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    layoutParams.f13355f = i13;
                    if (!layoutParams.f13350a && layoutParams.f13352c == 0.0f && (r = r(childAt)) != null) {
                        layoutParams.f13352c = r.f13363d;
                        layoutParams.f13354e = r.f13361b;
                    }
                }
                M();
                if (hasFocus()) {
                    View findFocus = findFocus();
                    d q = findFocus != null ? q(findFocus) : null;
                    if (q == null || q.f13361b != this.k) {
                        for (int i14 = 0; i14 < getChildCount(); i14++) {
                            View childAt2 = getChildAt(i14);
                            d r2 = r(childAt2);
                            if (r2 != null && r2.f13361b == this.k && childAt2.requestFocus(i3)) {
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
            throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f13345e + ", found: " + count + " Pager id: " + hexString + " Pager class: " + VerticalViewPager.class + " Problematic adapter: " + this.j.getClass());
        }
    }

    public final void F(int i2, int i3, int i4, int i5) {
        if (i3 > 0 && !this.f13347g.isEmpty()) {
            int scrollY = (int) ((getScrollY() / (((i3 - getPaddingTop()) - getPaddingBottom()) + i5)) * (((i2 - getPaddingTop()) - getPaddingBottom()) + i4));
            scrollTo(getScrollX(), scrollY);
            if (this.o.isFinished()) {
                return;
            }
            this.o.startScroll(0, scrollY, 0, (int) (t(this.k).f13364e * i2), this.o.getDuration() - this.o.timePassed());
            return;
        }
        d t = t(this.k);
        int min = (int) ((t != null ? Math.min(t.f13364e, this.v) : 0.0f) * ((i2 - getPaddingTop()) - getPaddingBottom()));
        if (min != getScrollY()) {
            i(false);
            scrollTo(getScrollX(), min);
        }
    }

    public final void G() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((LayoutParams) getChildAt(i2).getLayoutParams()).f13350a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    public final void H(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public final void I(int i2, boolean z, int i3, boolean z2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        ViewPager.OnPageChangeListener onPageChangeListener3;
        ViewPager.OnPageChangeListener onPageChangeListener4;
        d t = t(i2);
        int clientHeight = t != null ? (int) (getClientHeight() * Math.max(this.u, Math.min(t.f13364e, this.v))) : 0;
        if (z) {
            L(0, clientHeight, i3);
            if (z2 && (onPageChangeListener4 = this.W) != null) {
                onPageChangeListener4.onPageSelected(i2);
            }
            if (!z2 || (onPageChangeListener3 = this.a0) == null) {
                return;
            }
            onPageChangeListener3.onPageSelected(i2);
            return;
        }
        if (z2 && (onPageChangeListener2 = this.W) != null) {
            onPageChangeListener2.onPageSelected(i2);
        }
        if (z2 && (onPageChangeListener = this.a0) != null) {
            onPageChangeListener.onPageSelected(i2);
        }
        i(false);
        scrollTo(0, clientHeight);
        A(clientHeight);
    }

    public void J(int i2, boolean z, boolean z2) {
        K(i2, z, z2, 0);
    }

    public void K(int i2, boolean z, boolean z2, int i3) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        PagerAdapter pagerAdapter = this.j;
        if (pagerAdapter != null && pagerAdapter.getCount() > 0) {
            if (!z2 && this.k == i2 && this.f13347g.size() != 0 && !this.f13346f) {
                setScrollingCacheEnabled(false);
                return;
            }
            if (this.f13346f) {
                this.T = true;
            }
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 >= this.j.getCount()) {
                i2 = this.j.getCount() - 1;
            }
            int i4 = this.A;
            int i5 = this.k;
            if (i2 > i5 + i4 || i2 < i5 - i4) {
                for (int i6 = 0; i6 < this.f13347g.size(); i6++) {
                    this.f13347g.get(i6).f13362c = true;
                }
            }
            boolean z3 = this.k != i2;
            if (this.T) {
                this.k = i2;
                if (z3 && (onPageChangeListener2 = this.W) != null) {
                    onPageChangeListener2.onPageSelected(i2);
                }
                if (z3 && (onPageChangeListener = this.a0) != null) {
                    onPageChangeListener.onPageSelected(i2);
                }
                requestLayout();
                return;
            }
            E(i2);
            I(i2, z, i3, z3);
            return;
        }
        setScrollingCacheEnabled(false);
    }

    public void L(int i2, int i3, int i4) {
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i5 = i2 - scrollX;
        int i6 = i3 - scrollY;
        if (i5 == 0 && i6 == 0) {
            i(false);
            D();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientHeight = getClientHeight();
        int i7 = clientHeight / 2;
        float f2 = clientHeight;
        float f3 = i7;
        float l = f3 + (l(Math.min(1.0f, (Math.abs(i5) * 1.0f) / f2)) * f3);
        int abs2 = Math.abs(i4);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(l / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i5) / ((f2 * this.j.getPageWidth(this.k)) + this.q)) + 1.0f) * 100.0f);
        }
        this.o.startScroll(scrollX, scrollY, i5, i6, Math.min(abs, 600));
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
            for (int i2 = 0; i2 < childCount; i2++) {
                this.f0.add(getChildAt(i2));
            }
            Collections.sort(this.f0, m0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        d r;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (r = r(childAt)) != null && r.f13361b == this.k) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i3 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        d r;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (r = r(childAt)) != null && r.f13361b == this.k) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean z = layoutParams2.f13350a | false;
        layoutParams2.f13350a = z;
        if (!this.x) {
            super.addView(view, i2, layoutParams);
        } else if (layoutParams2 != null && z) {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        } else {
            layoutParams2.f13353d = true;
            addViewInLayout(view, i2, layoutParams);
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
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (r = r(childAt)) != null && r.f13361b == this.k && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
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

    public d e(int i2, int i3) {
        d dVar = new d();
        dVar.f13361b = i2;
        dVar.f13360a = this.j.instantiateItem((ViewGroup) this, i2);
        dVar.f13363d = this.j.getPageWidth(i2);
        if (i3 >= 0 && i3 < this.f13347g.size()) {
            this.f13347g.add(i3, dVar);
        } else {
            this.f13347g.add(dVar);
        }
        return dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(int i2) {
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
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
            if (findNextFocus == null && findNextFocus != findFocus) {
                if (i2 == 33) {
                    int i3 = p(this.f13349i, findNextFocus).top;
                    int i4 = p(this.f13349i, findFocus).top;
                    if (findFocus != null && i3 >= i4) {
                        requestFocus = B();
                    } else {
                        requestFocus = findNextFocus.requestFocus();
                    }
                } else if (i2 == 130) {
                    int i5 = p(this.f13349i, findNextFocus).bottom;
                    int i6 = p(this.f13349i, findFocus).bottom;
                    if (findFocus != null && i5 <= i6) {
                        requestFocus = z();
                    } else {
                        requestFocus = findNextFocus.requestFocus();
                    }
                }
                z2 = requestFocus;
            } else if (i2 != 33 || i2 == 1) {
                z2 = B();
            } else if (i2 == 130 || i2 == 2) {
                z2 = z();
            }
            if (z2) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i2));
            }
            return z2;
        }
        findFocus = null;
        findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
        if (findNextFocus == null) {
        }
        if (i2 != 33) {
        }
        z2 = B();
        if (z2) {
        }
        return z2;
    }

    public final void g(d dVar, int i2, d dVar2) {
        int i3;
        int i4;
        d dVar3;
        d dVar4;
        int count = this.j.getCount();
        int clientHeight = getClientHeight();
        float f2 = clientHeight > 0 ? this.q / clientHeight : 0.0f;
        if (dVar2 != null) {
            int i5 = dVar2.f13361b;
            int i6 = dVar.f13361b;
            if (i5 < i6) {
                int i7 = 0;
                float f3 = dVar2.f13364e + dVar2.f13363d + f2;
                while (true) {
                    i5++;
                    if (i5 > dVar.f13361b || i7 >= this.f13347g.size()) {
                        break;
                    }
                    d dVar5 = this.f13347g.get(i7);
                    while (true) {
                        dVar4 = dVar5;
                        if (i5 <= dVar4.f13361b || i7 >= this.f13347g.size() - 1) {
                            break;
                        }
                        i7++;
                        dVar5 = this.f13347g.get(i7);
                    }
                    while (i5 < dVar4.f13361b) {
                        f3 += this.j.getPageWidth(i5) + f2;
                        i5++;
                    }
                    dVar4.f13364e = f3;
                    f3 += dVar4.f13363d + f2;
                }
            } else if (i5 > i6) {
                int size = this.f13347g.size() - 1;
                float f4 = dVar2.f13364e;
                while (true) {
                    i5--;
                    if (i5 < dVar.f13361b || size < 0) {
                        break;
                    }
                    d dVar6 = this.f13347g.get(size);
                    while (true) {
                        dVar3 = dVar6;
                        if (i5 >= dVar3.f13361b || size <= 0) {
                            break;
                        }
                        size--;
                        dVar6 = this.f13347g.get(size);
                    }
                    while (i5 > dVar3.f13361b) {
                        f4 -= this.j.getPageWidth(i5) + f2;
                        i5--;
                    }
                    f4 -= dVar3.f13363d + f2;
                    dVar3.f13364e = f4;
                }
            }
        }
        int size2 = this.f13347g.size();
        float f5 = dVar.f13364e;
        int i8 = dVar.f13361b;
        int i9 = i8 - 1;
        this.u = i8 == 0 ? f5 : -3.4028235E38f;
        int i10 = count - 1;
        this.v = dVar.f13361b == i10 ? (dVar.f13364e + dVar.f13363d) - 1.0f : Float.MAX_VALUE;
        int i11 = i2 - 1;
        while (i11 >= 0) {
            d dVar7 = this.f13347g.get(i11);
            while (true) {
                i4 = dVar7.f13361b;
                if (i9 <= i4) {
                    break;
                }
                f5 -= this.j.getPageWidth(i9) + f2;
                i9--;
            }
            f5 -= dVar7.f13363d + f2;
            dVar7.f13364e = f5;
            if (i4 == 0) {
                this.u = f5;
            }
            i11--;
            i9--;
        }
        float f6 = dVar.f13364e + dVar.f13363d + f2;
        int i12 = dVar.f13361b + 1;
        int i13 = i2 + 1;
        while (i13 < size2) {
            d dVar8 = this.f13347g.get(i13);
            while (true) {
                i3 = dVar8.f13361b;
                if (i12 >= i3) {
                    break;
                }
                f6 += this.j.getPageWidth(i12) + f2;
                i12++;
            }
            if (i3 == i10) {
                this.v = (dVar8.f13363d + f6) - 1.0f;
            }
            dVar8.f13364e = f6;
            f6 += dVar8.f13363d + f2;
            i13++;
            i12++;
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
    public int getChildDrawingOrder(int i2, int i3) {
        if (this.e0 == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((LayoutParams) this.f0.get(i3).getLayoutParams()).f13355f;
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

    public boolean h(View view, boolean z, int i2, int i3, int i4) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i4 + scrollY;
                if (i6 >= childAt.getTop() && i6 < childAt.getBottom() && (i5 = i3 + scrollX) >= childAt.getLeft() && i5 < childAt.getRight() && h(childAt, true, i2, i5 - childAt.getLeft(), i6 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && ViewCompat.canScrollVertically(view, -i2);
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
        for (int i2 = 0; i2 < this.f13347g.size(); i2++) {
            d dVar = this.f13347g.get(i2);
            if (dVar.f13362c) {
                dVar.f13362c = false;
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
        this.f13345e = count;
        boolean z = this.f13347g.size() < (this.A * 2) + 1 && this.f13347g.size() < count;
        int i2 = this.k;
        int i3 = 0;
        boolean z2 = false;
        while (i3 < this.f13347g.size()) {
            d dVar = this.f13347g.get(i3);
            int itemPosition = this.j.getItemPosition(dVar.f13360a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.f13347g.remove(i3);
                    i3--;
                    if (!z2) {
                        this.j.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.j.destroyItem((ViewGroup) this, dVar.f13361b, dVar.f13360a);
                    int i4 = this.k;
                    if (i4 == dVar.f13361b) {
                        i2 = Math.max(0, Math.min(i4, count - 1));
                    }
                } else {
                    int i5 = dVar.f13361b;
                    if (i5 != itemPosition) {
                        if (i5 == this.k) {
                            i2 = itemPosition;
                        }
                        dVar.f13361b = itemPosition;
                    }
                }
                z = true;
            }
            i3++;
        }
        if (z2) {
            this.j.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.f13347g, k0);
        if (z) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i6).getLayoutParams();
                if (!layoutParams.f13350a) {
                    layoutParams.f13352c = 0.0f;
                }
            }
            J(i2, false, true);
            requestLayout();
        }
    }

    public final int k(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.O || Math.abs(i3) <= this.M) {
            i2 = (int) (i2 + f2 + (i2 >= this.k ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.f13347g.size() > 0) {
            ArrayList<d> arrayList = this.f13347g;
            return Math.max(this.f13347g.get(0).f13361b, Math.min(i2, arrayList.get(arrayList.size() - 1).f13361b));
        }
        return i2;
    }

    public float l(float f2) {
        return (float) Math.sin((float) ((f2 - 0.5f) * 0.4712389167638204d));
    }

    public final void m(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            ViewCompat.setLayerType(getChildAt(i2), z ? 2 : 0, null);
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
        if (this.q <= 0 || this.r == null || this.f13347g.size() <= 0 || this.j == null) {
            return;
        }
        int scrollY = getScrollY();
        float height2 = getHeight();
        float f4 = this.q / height2;
        int i2 = 0;
        d dVar = this.f13347g.get(0);
        float f5 = dVar.f13364e;
        int size = this.f13347g.size();
        int i3 = dVar.f13361b;
        int i4 = this.f13347g.get(size - 1).f13361b;
        while (i3 < i4) {
            while (i3 > dVar.f13361b && i2 < size) {
                i2++;
                dVar = this.f13347g.get(i2);
            }
            if (i3 == dVar.f13361b) {
                float f6 = dVar.f13364e;
                float f7 = dVar.f13363d;
                f2 = (f6 + f7) * height2;
                f5 = f6 + f7 + f4;
            } else {
                float pageWidth = this.j.getPageWidth(i3);
                f2 = (f5 + pageWidth) * height2;
                f5 += pageWidth + f4;
            }
            int i5 = this.q;
            if (i5 + f2 > scrollY) {
                f3 = f4;
                this.r.setBounds(this.s, (int) f2, this.t, (int) (i5 + f2 + 0.5f));
                this.r.draw(canvas);
            } else {
                f3 = f4;
            }
            if (f2 > scrollY + height) {
                return;
            }
            i3++;
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
                int i2 = this.K;
                if (i2 != -1) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
                    float y2 = MotionEventCompat.getY(motionEvent, findPointerIndex);
                    float f2 = y2 - this.H;
                    float abs = Math.abs(f2);
                    float x2 = MotionEventCompat.getX(motionEvent, findPointerIndex);
                    float abs2 = Math.abs(x2 - this.I);
                    int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                    if (i3 != 0 && !w(this.H, f2) && h(this, false, (int) f2, (int) x2, (int) y2)) {
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
                        this.H = i3 > 0 ? f3 + f4 : f3 - f4;
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
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        d r;
        int max;
        int i6;
        int max2;
        int i7;
        int childCount = getChildCount();
        int i8 = i4 - i2;
        int i9 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollY = getScrollY();
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f13350a) {
                    int i12 = layoutParams.f13351b;
                    int i13 = i12 & 7;
                    int i14 = i12 & 112;
                    if (i13 == 1) {
                        max = Math.max((i8 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    } else {
                        if (i13 == 3) {
                            i6 = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i13 != 5) {
                            i6 = paddingLeft;
                        } else {
                            max = (i8 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i14 != 16) {
                            max2 = Math.max((i9 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        } else {
                            if (i14 == 48) {
                                i7 = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i14 != 80) {
                                i7 = paddingTop;
                            } else {
                                max2 = (i9 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i15 = paddingTop + scrollY;
                            childAt.layout(paddingLeft, i15, childAt.getMeasuredWidth() + paddingLeft, i15 + childAt.getMeasuredHeight());
                            i10++;
                            paddingTop = i7;
                            paddingLeft = i6;
                        }
                        int i16 = max2;
                        i7 = paddingTop;
                        paddingTop = i16;
                        int i152 = paddingTop + scrollY;
                        childAt.layout(paddingLeft, i152, childAt.getMeasuredWidth() + paddingLeft, i152 + childAt.getMeasuredHeight());
                        i10++;
                        paddingTop = i7;
                        paddingLeft = i6;
                    }
                    int i17 = max;
                    i6 = paddingLeft;
                    paddingLeft = i17;
                    if (i14 != 16) {
                    }
                    int i162 = max2;
                    i7 = paddingTop;
                    paddingTop = i162;
                    int i1522 = paddingTop + scrollY;
                    childAt.layout(paddingLeft, i1522, childAt.getMeasuredWidth() + paddingLeft, i1522 + childAt.getMeasuredHeight());
                    i10++;
                    paddingTop = i7;
                    paddingLeft = i6;
                }
            }
        }
        int i18 = (i9 - paddingTop) - paddingBottom;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt2 = getChildAt(i19);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.f13350a && (r = r(childAt2)) != null) {
                    float f2 = i18;
                    int i20 = ((int) (r.f13364e * f2)) + paddingTop;
                    if (layoutParams2.f13353d) {
                        layoutParams2.f13353d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((i8 - paddingLeft) - paddingRight, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (f2 * layoutParams2.f13352c), 1073741824));
                    }
                    childAt2.layout(paddingLeft, i20, childAt2.getMeasuredWidth() + paddingLeft, childAt2.getMeasuredHeight() + i20);
                }
            }
        }
        this.s = paddingLeft;
        this.t = i8 - paddingRight;
        this.V = i10;
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
    public void onMeasure(int i2, int i3) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        int i4;
        int i5;
        int i6;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, i2), ViewGroup.getDefaultSize(0, i3));
        int measuredHeight = getMeasuredHeight();
        this.E = Math.min(measuredHeight / 10, this.D);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (measuredHeight - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i7 = 0;
        while (true) {
            boolean z = true;
            int i8 = 1073741824;
            if (i7 >= childCount) {
                break;
            }
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.f13350a) {
                int i9 = layoutParams2.f13351b;
                int i10 = i9 & 7;
                int i11 = i9 & 112;
                boolean z2 = i11 == 48 || i11 == 80;
                if (i10 != 3 && i10 != 5) {
                    z = false;
                }
                int i12 = Integer.MIN_VALUE;
                if (z2) {
                    i12 = 1073741824;
                } else if (z) {
                    i4 = 1073741824;
                    i5 = ((ViewGroup.LayoutParams) layoutParams2).width;
                    if (i5 == -2) {
                        if (i5 == -1) {
                            i5 = measuredWidth;
                        }
                        i12 = 1073741824;
                    } else {
                        i5 = measuredWidth;
                    }
                    i6 = ((ViewGroup.LayoutParams) layoutParams2).height;
                    if (i6 != -2) {
                        i6 = paddingTop;
                        i8 = i4;
                    } else if (i6 == -1) {
                        i6 = paddingTop;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i5, i12), View.MeasureSpec.makeMeasureSpec(i6, i8));
                    if (!z2) {
                        paddingTop -= childAt.getMeasuredHeight();
                    } else if (z) {
                        measuredWidth -= childAt.getMeasuredWidth();
                    }
                }
                i4 = Integer.MIN_VALUE;
                i5 = ((ViewGroup.LayoutParams) layoutParams2).width;
                if (i5 == -2) {
                }
                i6 = ((ViewGroup.LayoutParams) layoutParams2).height;
                if (i6 != -2) {
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i5, i12), View.MeasureSpec.makeMeasureSpec(i6, i8));
                if (!z2) {
                }
            }
            i7++;
        }
        this.w = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
        this.x = true;
        D();
        this.x = false;
        int childCount2 = getChildCount();
        for (int i13 = 0; i13 < childCount2; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.f13350a)) {
                childAt2.measure(this.w, View.MeasureSpec.makeMeasureSpec((int) (paddingTop * layoutParams.f13352c), 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        d r;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i3 = 0;
            i4 = 1;
        } else {
            i3 = childCount - 1;
            i4 = -1;
        }
        while (i3 != i5) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (r = r(childAt)) != null && r.f13361b == this.k && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i3 += i4;
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
            pagerAdapter.restoreState(savedState.f13357f, savedState.f13358g);
            J(savedState.f13356e, false, true);
            return;
        }
        this.l = savedState.f13356e;
        this.m = savedState.f13357f;
        this.n = savedState.f13358g;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f13356e = this.k;
        PagerAdapter pagerAdapter = this.j;
        if (pagerAdapter != null) {
            savedState.f13357f = pagerAdapter.saveState();
        }
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i3 != i5) {
            int i6 = this.q;
            F(i3, i5, i6, i6);
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
            K(k(s.f13361b, ((scrollY / clientHeight) - s.f13364e) / s.f13363d, yVelocity, (int) (MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.K)) - this.J)), true, true, yVelocity);
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
        for (int i2 = 0; i2 < this.f13347g.size(); i2++) {
            d dVar = this.f13347g.get(i2);
            if (this.j.isViewFromObject(view, dVar.f13360a)) {
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
        int i2;
        int clientHeight = getClientHeight();
        float f2 = 0.0f;
        float scrollY = clientHeight > 0 ? getScrollY() / clientHeight : 0.0f;
        float f3 = clientHeight > 0 ? this.q / clientHeight : 0.0f;
        d dVar = null;
        float f4 = 0.0f;
        int i3 = -1;
        int i4 = 0;
        boolean z = true;
        while (i4 < this.f13347g.size()) {
            d dVar2 = this.f13347g.get(i4);
            if (!z && dVar2.f13361b != (i2 = i3 + 1)) {
                dVar2 = this.f13348h;
                dVar2.f13364e = f2 + f4 + f3;
                dVar2.f13361b = i2;
                dVar2.f13363d = this.j.getPageWidth(i2);
                i4--;
            }
            f2 = dVar2.f13364e;
            float f5 = dVar2.f13363d + f2 + f3;
            if (!z && scrollY < f2) {
                return dVar;
            }
            if (scrollY < f5 || i4 == this.f13347g.size() - 1) {
                return dVar2;
            }
            i3 = dVar2.f13361b;
            f4 = dVar2.f13363d;
            i4++;
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
            for (int i2 = 0; i2 < this.f13347g.size(); i2++) {
                d dVar = this.f13347g.get(i2);
                this.j.destroyItem((ViewGroup) this, dVar.f13361b, dVar.f13360a);
            }
            this.j.finishUpdate((ViewGroup) this);
            this.f13347g.clear();
            G();
            this.k = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter3 = this.j;
        this.j = pagerAdapter;
        this.f13345e = 0;
        if (pagerAdapter != null) {
            if (this.p == null) {
                this.p = new g(this, null);
            }
            this.j.registerDataSetObserver(this.p);
            this.z = false;
            boolean z = this.T;
            this.T = true;
            this.f13345e = this.j.getCount();
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

    public void setCurrentItem(int i2) {
        this.z = false;
        J(i2, !this.T, false);
    }

    public void setEventListener(a.b bVar) {
        d.a.m0.b1.p.a aVar = this.i0;
        if (aVar != null) {
            aVar.f(bVar);
        }
    }

    public void setNeedHanleTouch(boolean z) {
        this.f13346f = z;
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            Log.w(ViewPager.TAG, "Requested offscreen page limit " + i2 + " too small; defaulting to 1");
            i2 = 1;
        }
        if (i2 != this.A) {
            this.A = i2;
            D();
        }
    }

    public void setOnAdapterChangeListener(f fVar) {
        this.b0 = fVar;
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.W = onPageChangeListener;
    }

    public void setPageMargin(int i2) {
        int i3 = this.q;
        this.q = i2;
        int height = getHeight();
        F(height, height, i2, i3);
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

    public d t(int i2) {
        for (int i3 = 0; i3 < this.f13347g.size(); i3++) {
            d dVar = this.f13347g.get(i3);
            if (dVar.f13361b == i2) {
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
        this.i0 = new d.a.m0.b1.p.a(this);
    }

    public boolean v(int i2) {
        if (this.j == null) {
            return false;
        }
        int clientHeight = getClientHeight();
        int scrollY = getScrollY();
        return i2 < 0 ? scrollY > ((int) (((float) clientHeight) * this.u)) : i2 > 0 && scrollY < ((int) (((float) clientHeight) * this.v));
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
    public void x(int i2, float f2, int i3) {
        int max;
        int i4;
        int top;
        if (this.V > 0) {
            int scrollY = getScrollY();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f13350a) {
                    int i6 = layoutParams.f13351b & 112;
                    if (i6 == 16) {
                        max = Math.max((height - childAt.getMeasuredHeight()) / 2, paddingTop);
                    } else {
                        if (i6 == 48) {
                            i4 = childAt.getHeight() + paddingTop;
                        } else if (i6 != 80) {
                            i4 = paddingTop;
                        } else {
                            max = (height - paddingBottom) - childAt.getMeasuredHeight();
                            paddingBottom += childAt.getMeasuredHeight();
                        }
                        top = (paddingTop + scrollY) - childAt.getTop();
                        if (top != 0) {
                            childAt.offsetTopAndBottom(top);
                        }
                        paddingTop = i4;
                    }
                    int i7 = max;
                    i4 = paddingTop;
                    paddingTop = i7;
                    top = (paddingTop + scrollY) - childAt.getTop();
                    if (top != 0) {
                    }
                    paddingTop = i4;
                }
            }
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.W;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i2, f2, i3);
        }
        ViewPager.OnPageChangeListener onPageChangeListener2 = this.a0;
        if (onPageChangeListener2 != null) {
            onPageChangeListener2.onPageScrolled(i2, f2, i3);
        }
        if (this.c0 != null) {
            int scrollY2 = getScrollY();
            int childCount2 = getChildCount();
            for (int i8 = 0; i8 < childCount2; i8++) {
                View childAt2 = getChildAt(i8);
                if (!((LayoutParams) childAt2.getLayoutParams()).f13350a) {
                    this.c0.transformPage(childAt2, (childAt2.getTop() - scrollY2) / getClientHeight());
                }
            }
        }
        this.U = true;
    }

    public final void y(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.K) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.H = MotionEventCompat.getY(motionEvent, i2);
            this.K = MotionEventCompat.getPointerId(motionEvent, i2);
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
        public boolean f13350a;

        /* renamed from: b  reason: collision with root package name */
        public int f13351b;

        /* renamed from: c  reason: collision with root package name */
        public float f13352c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f13353d;

        /* renamed from: e  reason: collision with root package name */
        public int f13354e;

        /* renamed from: f  reason: collision with root package name */
        public int f13355f;

        public LayoutParams() {
            super(-1, -1);
            this.f13352c = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f13352c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, VerticalViewPager.j0);
            this.f13351b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setCurrentItem(int i2, boolean z) {
        this.z = false;
        J(i2, z, false);
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i2));
    }

    public VerticalViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13347g = new ArrayList<>();
        this.f13348h = new d();
        this.f13349i = new Rect();
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
