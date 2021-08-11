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
import android.os.SystemClock;
import android.util.AttributeSet;
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
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import c.a.o0.d1.q.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* loaded from: classes6.dex */
public class VerticalViewPager extends ViewGroup {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public static final int[] q0;
    public static final Comparator<d> r0;
    public static final Interpolator s0;
    public static final h t0;
    public transient /* synthetic */ FieldHolder $fh;
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
    public long R;
    public EdgeEffectCompat S;
    public EdgeEffectCompat T;
    public boolean U;
    public boolean V;
    public int W;
    public ViewPager.OnPageChangeListener a0;
    public ViewPager.OnPageChangeListener b0;
    public f c0;

    /* renamed from: e  reason: collision with root package name */
    public int f48750e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48751f;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList<d> f48752g;

    /* renamed from: h  reason: collision with root package name */
    public final d f48753h;

    /* renamed from: i  reason: collision with root package name */
    public final Rect f48754i;
    public ViewPager.PageTransformer i0;

    /* renamed from: j  reason: collision with root package name */
    public PagerAdapter f48755j;
    public Method j0;
    public int k;
    public int k0;
    public int l;
    public ArrayList<View> l0;
    public Parcelable m;
    public boolean m0;
    public ClassLoader n;
    public final Runnable n0;
    public Scroller o;
    public int o0;
    public g p;
    public c.a.o0.d1.q.a p0;
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

    /* loaded from: classes6.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public Parcelable adapterState;
        public ClassLoader loader;
        public int position;

        /* loaded from: classes6.dex */
        public static class a implements ParcelableCompatCreatorCallbacks<SavedState> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, parcel, classLoader)) == null) ? new SavedState(parcel, classLoader) : (SavedState) invokeLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1356340740, "Lcom/baidu/tbadk/widget/viewpager/VerticalViewPager$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1356340740, "Lcom/baidu/tbadk/widget/viewpager/VerticalViewPager$SavedState;");
                    return;
                }
            }
            CREATOR = ParcelableCompat.newCreator(new a());
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable parcelable) {
            super(parcelable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelable};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
            }
            return (String) invokeV.objValue;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.position);
                parcel.writeParcelable(this.adapterState, i2);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel, classLoader};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            classLoader = classLoader == null ? SavedState.class.getClassLoader() : classLoader;
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader);
            this.loader = classLoader;
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements Comparator<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d dVar, d dVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, dVar, dVar2)) == null) ? dVar.f48764b - dVar2.f48764b : invokeLL.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Interpolator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
            return invokeF.floatValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VerticalViewPager f48762e;

        public c(VerticalViewPager verticalViewPager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {verticalViewPager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48762e = verticalViewPager;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48762e.setScrollState(0);
                this.f48762e.x();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Object f48763a;

        /* renamed from: b  reason: collision with root package name */
        public int f48764b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f48765c;

        /* renamed from: d  reason: collision with root package name */
        public float f48766d;

        /* renamed from: e  reason: collision with root package name */
        public float f48767e;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends AccessibilityDelegateCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VerticalViewPager f48768a;

        public e(VerticalViewPager verticalViewPager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {verticalViewPager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48768a = verticalViewPager;
        }

        public final boolean canScroll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f48768a.f48755j != null && this.f48768a.f48755j.getCount() > 1 : invokeV.booleanValue;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, accessibilityEvent) == null) {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                accessibilityEvent.setClassName(ViewPager.class.getName());
                AccessibilityRecordCompat obtain = AccessibilityRecordCompat.obtain();
                obtain.setScrollable(canScroll());
                if (accessibilityEvent.getEventType() != 4096 || this.f48768a.f48755j == null) {
                    return;
                }
                obtain.setItemCount(this.f48768a.f48755j.getCount());
                obtain.setFromIndex(this.f48768a.k);
                obtain.setToIndex(this.f48768a.k);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, accessibilityNodeInfoCompat) == null) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
                accessibilityNodeInfoCompat.setScrollable(canScroll());
                if (this.f48768a.internalCanScrollVertically(1)) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
                if (this.f48768a.internalCanScrollVertically(-1)) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, view, i2, bundle)) == null) {
                if (super.performAccessibilityAction(view, i2, bundle)) {
                    return true;
                }
                if (i2 != 4096) {
                    if (i2 == 8192 && this.f48768a.internalCanScrollVertically(-1)) {
                        VerticalViewPager verticalViewPager = this.f48768a;
                        verticalViewPager.setCurrentItem(verticalViewPager.k - 1);
                        return true;
                    }
                    return false;
                } else if (this.f48768a.internalCanScrollVertically(1)) {
                    VerticalViewPager verticalViewPager2 = this.f48768a;
                    verticalViewPager2.setCurrentItem(verticalViewPager2.k + 1);
                    return true;
                } else {
                    return false;
                }
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface f {
        void a(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    /* loaded from: classes6.dex */
    public class g extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VerticalViewPager f48769a;

        public g(VerticalViewPager verticalViewPager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {verticalViewPager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48769a = verticalViewPager;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48769a.h();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f48769a.h();
            }
        }

        public /* synthetic */ g(VerticalViewPager verticalViewPager, a aVar) {
            this(verticalViewPager);
        }
    }

    /* loaded from: classes6.dex */
    public static class h implements Comparator<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view, View view2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, view2)) == null) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                boolean z = layoutParams.f48756a;
                if (z != layoutParams2.f48756a) {
                    return z ? 1 : -1;
                }
                return layoutParams.f48760e - layoutParams2.f48760e;
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1462522380, "Lcom/baidu/tbadk/widget/viewpager/VerticalViewPager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1462522380, "Lcom/baidu/tbadk/widget/viewpager/VerticalViewPager;");
                return;
            }
        }
        q0 = new int[]{16842931};
        r0 = new a();
        s0 = new b();
        t0 = new h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerticalViewPager(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f48752g = new ArrayList<>();
        this.f48753h = new d();
        this.f48754i = new Rect();
        this.l = -1;
        this.m = null;
        this.n = null;
        this.u = -3.4028235E38f;
        this.v = Float.MAX_VALUE;
        this.A = 1;
        this.K = -1;
        this.U = true;
        this.m0 = true;
        this.n0 = new c(this);
        this.o0 = 0;
        r();
    }

    private int getClientHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom() : invokeV.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollState(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65544, this, i2) == null) || this.o0 == i2) {
            return;
        }
        this.o0 = i2;
        if (this.i0 != null) {
            k(i2 != 0);
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.a0;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i2);
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65545, this, z) == null) || this.y == z) {
            return;
        }
        this.y = z;
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = 0;
            while (i2 < getChildCount()) {
                if (!((LayoutParams) getChildAt(i2).getLayoutParams()).f48756a) {
                    removeViewAt(i2);
                    i2--;
                }
                i2++;
            }
        }
    }

    public final void B(boolean z) {
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (parent = getParent()) == null) {
            return;
        }
        parent.requestDisallowInterceptTouchEvent(z);
    }

    public final void C(int i2, boolean z, int i3, boolean z2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        ViewPager.OnPageChangeListener onPageChangeListener3;
        ViewPager.OnPageChangeListener onPageChangeListener4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Boolean.valueOf(z2)}) == null) {
            d q = q(i2);
            int clientHeight = q != null ? (int) (getClientHeight() * Math.max(this.u, Math.min(q.f48767e, this.v))) : 0;
            if (z) {
                F(0, clientHeight, i3);
                if (z2 && (onPageChangeListener4 = this.a0) != null) {
                    onPageChangeListener4.onPageSelected(i2);
                }
                if (!z2 || (onPageChangeListener3 = this.b0) == null) {
                    return;
                }
                onPageChangeListener3.onPageSelected(i2);
                return;
            }
            if (z2 && (onPageChangeListener2 = this.a0) != null) {
                onPageChangeListener2.onPageSelected(i2);
            }
            if (z2 && (onPageChangeListener = this.b0) != null) {
                onPageChangeListener.onPageSelected(i2);
            }
            g(false);
            scrollTo(0, clientHeight);
            pageScrolled(clientHeight);
        }
    }

    public void D(int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            E(i2, z, z2, 0);
        }
    }

    public void E(int i2, boolean z, boolean z2, int i3) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i3)}) == null) {
            PagerAdapter pagerAdapter = this.f48755j;
            if (pagerAdapter != null && pagerAdapter.getCount() > 0) {
                if (!z2 && this.k == i2 && this.f48752g.size() != 0 && !this.f48751f) {
                    setScrollingCacheEnabled(false);
                    return;
                }
                if (this.f48751f) {
                    this.U = true;
                }
                if (i2 < 0) {
                    i2 = 0;
                } else if (i2 >= this.f48755j.getCount()) {
                    i2 = this.f48755j.getCount() - 1;
                }
                int i4 = this.A;
                int i5 = this.k;
                if (i2 > i5 + i4 || i2 < i5 - i4) {
                    for (int i6 = 0; i6 < this.f48752g.size(); i6++) {
                        this.f48752g.get(i6).f48765c = true;
                    }
                }
                boolean z3 = this.k != i2;
                if (this.U) {
                    this.k = i2;
                    if (z3 && (onPageChangeListener2 = this.a0) != null) {
                        onPageChangeListener2.onPageSelected(i2);
                    }
                    if (z3 && (onPageChangeListener = this.b0) != null) {
                        onPageChangeListener.onPageSelected(i2);
                    }
                    requestLayout();
                    return;
                }
                y(i2);
                C(i2, z, i3, z3);
                return;
            }
            setScrollingCacheEnabled(false);
        }
    }

    public void F(int i2, int i3, int i4) {
        int abs;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048581, this, i2, i3, i4) == null) {
            if (getChildCount() == 0) {
                setScrollingCacheEnabled(false);
                return;
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int i5 = i2 - scrollX;
            int i6 = i3 - scrollY;
            if (i5 == 0 && i6 == 0) {
                g(false);
                x();
                setScrollState(0);
                return;
            }
            setScrollingCacheEnabled(true);
            setScrollState(2);
            int clientHeight = getClientHeight();
            int i7 = clientHeight / 2;
            float f2 = clientHeight;
            float f3 = i7;
            float j2 = f3 + (j(Math.min(1.0f, (Math.abs(i5) * 1.0f) / f2)) * f3);
            int abs2 = Math.abs(i4);
            if (abs2 > 0) {
                abs = Math.round(Math.abs(j2 / abs2) * 1000.0f) * 4;
            } else {
                abs = (int) (((Math.abs(i5) / ((f2 * this.f48755j.getPageWidth(this.k)) + this.q)) + 1.0f) * 100.0f);
            }
            this.o.startScroll(scrollX, scrollY, i5, i6, Math.min(abs, 600));
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.k0 == 0) {
            return;
        }
        ArrayList<View> arrayList = this.l0;
        if (arrayList == null) {
            this.l0 = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            this.l0.add(getChildAt(i2));
        }
        Collections.sort(this.l0, t0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        d o;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048583, this, arrayList, i2, i3) == null) {
            int size = arrayList.size();
            int descendantFocusability = getDescendantFocusability();
            if (descendantFocusability != 393216) {
                for (int i4 = 0; i4 < getChildCount(); i4++) {
                    View childAt = getChildAt(i4);
                    if (childAt.getVisibility() == 0 && (o = o(childAt)) != null && o.f48764b == this.k) {
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
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        d o;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, arrayList) == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() == 0 && (o = o(childAt)) != null && o.f48764b == this.k) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048585, this, view, i2, layoutParams) == null) {
            if (!checkLayoutParams(layoutParams)) {
                layoutParams = generateLayoutParams(layoutParams);
            }
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            boolean z = layoutParams2.f48756a | false;
            layoutParams2.f48756a = z;
            if (!this.x) {
                super.addView(view, i2, layoutParams);
            } else if (layoutParams2 != null && z) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            } else {
                layoutParams2.f48759d = true;
                addViewInLayout(view, i2, layoutParams);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean arrowScroll(int i2) {
        InterceptResult invokeI;
        boolean z;
        View findNextFocus;
        boolean requestFocus;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
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
                        String str = "arrowScroll tried to find focus based on non-child current focused view " + sb.toString();
                    }
                }
                findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
                if (findNextFocus == null && findNextFocus != findFocus) {
                    if (i2 == 33) {
                        int i3 = m(this.f48754i, findNextFocus).top;
                        int i4 = m(this.f48754i, findFocus).top;
                        if (findFocus != null && i3 >= i4) {
                            requestFocus = v();
                        } else {
                            requestFocus = findNextFocus.requestFocus();
                        }
                    } else if (i2 == 130) {
                        int i5 = m(this.f48754i, findNextFocus).bottom;
                        int i6 = m(this.f48754i, findFocus).bottom;
                        if (findFocus != null && i5 <= i6) {
                            requestFocus = u();
                        } else {
                            requestFocus = findNextFocus.requestFocus();
                        }
                    }
                    z2 = requestFocus;
                } else if (i2 != 33 || i2 == 1) {
                    z2 = v();
                } else if (i2 == 130 || i2 == 2) {
                    z2 = u();
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
            z2 = v();
            if (z2) {
            }
            return z2;
        }
        return invokeI.booleanValue;
    }

    public boolean beginFakeDrag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.B) {
                return false;
            }
            this.Q = true;
            setScrollState(1);
            this.H = 0.0f;
            this.J = 0.0f;
            VelocityTracker velocityTracker = this.L;
            if (velocityTracker == null) {
                this.L = VelocityTracker.obtain();
            } else {
                velocityTracker.clear();
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
            this.L.addMovement(obtain);
            obtain.recycle();
            this.R = uptimeMillis;
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean canScroll(View view, boolean z, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{view, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int scrollX = view.getScrollX();
                int scrollY = view.getScrollY();
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = viewGroup.getChildAt(childCount);
                    int i6 = i4 + scrollY;
                    if (i6 >= childAt.getTop() && i6 < childAt.getBottom() && (i5 = i3 + scrollX) >= childAt.getLeft() && i5 < childAt.getRight() && canScroll(childAt, true, i2, i5 - childAt.getLeft(), i6 - childAt.getTop())) {
                        return true;
                    }
                }
            }
            return z && ViewCompat.canScrollVertically(view, -i2);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, layoutParams)) == null) ? (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams) : invokeL.booleanValue;
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (!this.o.isFinished() && this.o.computeScrollOffset()) {
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.o.getCurrX();
                int currY = this.o.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (!pageScrolled(currY)) {
                        this.o.abortAnimation();
                        scrollTo(currX, 0);
                    }
                }
                ViewCompat.postInvalidateOnAnimation(this);
                return;
            }
            g(true);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, keyEvent)) == null) ? super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent) : invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        d o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, accessibilityEvent)) == null) {
            if (accessibilityEvent.getEventType() == 4096) {
                return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() == 0 && (o = o(childAt)) != null && o.f48764b == this.k && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, canvas) == null) {
            super.draw(canvas);
            int overScrollMode = ViewCompat.getOverScrollMode(this);
            boolean z = false;
            if (overScrollMode != 0 && (overScrollMode != 1 || (pagerAdapter = this.f48755j) == null || pagerAdapter.getCount() <= 1)) {
                this.S.finish();
                this.T.finish();
            } else {
                if (!this.S.isFinished()) {
                    int save = canvas.save();
                    int height = getHeight();
                    int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                    canvas.translate(getPaddingLeft(), this.u * height);
                    this.S.setSize(width, height);
                    z = false | this.S.draw(canvas);
                    if (save >= 1 && save <= canvas.getSaveCount()) {
                        canvas.restoreToCount(save);
                    }
                }
                if (!this.T.isFinished()) {
                    int save2 = canvas.save();
                    int height2 = getHeight();
                    int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                    canvas.rotate(180.0f);
                    canvas.translate((-width2) - getPaddingLeft(), (-(this.v + 1.0f)) * height2);
                    this.T.setSize(width2, height2);
                    z |= this.T.draw(canvas);
                    if (save2 >= 1 && save2 <= canvas.getSaveCount()) {
                        canvas.restoreToCount(save2);
                    }
                }
            }
            if (z) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.drawableStateChanged();
            Drawable drawable = this.r;
            if (drawable == null || !drawable.isStateful()) {
                return;
            }
            drawable.setState(getDrawableState());
        }
    }

    public d e(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048595, this, i2, i3)) == null) {
            d dVar = new d();
            dVar.f48764b = i2;
            dVar.f48763a = this.f48755j.instantiateItem((ViewGroup) this, i2);
            dVar.f48766d = this.f48755j.getPageWidth(i2);
            if (i3 >= 0 && i3 < this.f48752g.size()) {
                this.f48752g.add(i3, dVar);
            } else {
                this.f48752g.add(dVar);
            }
            return dVar;
        }
        return (d) invokeII.objValue;
    }

    public void endFakeDrag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.Q) {
                VelocityTracker velocityTracker = this.L;
                velocityTracker.computeCurrentVelocity(1000, this.N);
                int yVelocity = (int) VelocityTrackerCompat.getYVelocity(velocityTracker, this.K);
                this.z = true;
                int clientHeight = getClientHeight();
                int scrollY = getScrollY();
                d p = p();
                E(i(p.f48764b, ((scrollY / clientHeight) - p.f48767e) / p.f48766d, yVelocity, (int) (this.H - this.J)), true, true, yVelocity);
                l();
                this.Q = false;
                return;
            }
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, keyEvent)) == null) {
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 21) {
                    return arrowScroll(17);
                }
                if (keyCode != 22) {
                    if (keyCode == 61 && Build.VERSION.SDK_INT >= 11) {
                        if (keyEvent.hasNoModifiers()) {
                            return arrowScroll(2);
                        }
                        if (keyEvent.hasModifiers(1)) {
                            return arrowScroll(1);
                        }
                    }
                } else {
                    return arrowScroll(66);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void f(d dVar, int i2, d dVar2) {
        int i3;
        int i4;
        d dVar3;
        d dVar4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048598, this, dVar, i2, dVar2) == null) {
            int count = this.f48755j.getCount();
            int clientHeight = getClientHeight();
            float f2 = clientHeight > 0 ? this.q / clientHeight : 0.0f;
            if (dVar2 != null) {
                int i5 = dVar2.f48764b;
                int i6 = dVar.f48764b;
                if (i5 < i6) {
                    int i7 = 0;
                    float f3 = dVar2.f48767e + dVar2.f48766d + f2;
                    while (true) {
                        i5++;
                        if (i5 > dVar.f48764b || i7 >= this.f48752g.size()) {
                            break;
                        }
                        d dVar5 = this.f48752g.get(i7);
                        while (true) {
                            dVar4 = dVar5;
                            if (i5 <= dVar4.f48764b || i7 >= this.f48752g.size() - 1) {
                                break;
                            }
                            i7++;
                            dVar5 = this.f48752g.get(i7);
                        }
                        while (i5 < dVar4.f48764b) {
                            f3 += this.f48755j.getPageWidth(i5) + f2;
                            i5++;
                        }
                        dVar4.f48767e = f3;
                        f3 += dVar4.f48766d + f2;
                    }
                } else if (i5 > i6) {
                    int size = this.f48752g.size() - 1;
                    float f4 = dVar2.f48767e;
                    while (true) {
                        i5--;
                        if (i5 < dVar.f48764b || size < 0) {
                            break;
                        }
                        d dVar6 = this.f48752g.get(size);
                        while (true) {
                            dVar3 = dVar6;
                            if (i5 >= dVar3.f48764b || size <= 0) {
                                break;
                            }
                            size--;
                            dVar6 = this.f48752g.get(size);
                        }
                        while (i5 > dVar3.f48764b) {
                            f4 -= this.f48755j.getPageWidth(i5) + f2;
                            i5--;
                        }
                        f4 -= dVar3.f48766d + f2;
                        dVar3.f48767e = f4;
                    }
                }
            }
            int size2 = this.f48752g.size();
            float f5 = dVar.f48767e;
            int i8 = dVar.f48764b;
            int i9 = i8 - 1;
            this.u = i8 == 0 ? f5 : -3.4028235E38f;
            int i10 = count - 1;
            this.v = dVar.f48764b == i10 ? (dVar.f48767e + dVar.f48766d) - 1.0f : Float.MAX_VALUE;
            int i11 = i2 - 1;
            while (i11 >= 0) {
                d dVar7 = this.f48752g.get(i11);
                while (true) {
                    i4 = dVar7.f48764b;
                    if (i9 <= i4) {
                        break;
                    }
                    f5 -= this.f48755j.getPageWidth(i9) + f2;
                    i9--;
                }
                f5 -= dVar7.f48766d + f2;
                dVar7.f48767e = f5;
                if (i4 == 0) {
                    this.u = f5;
                }
                i11--;
                i9--;
            }
            float f6 = dVar.f48767e + dVar.f48766d + f2;
            int i12 = dVar.f48764b + 1;
            int i13 = i2 + 1;
            while (i13 < size2) {
                d dVar8 = this.f48752g.get(i13);
                while (true) {
                    i3 = dVar8.f48764b;
                    if (i12 >= i3) {
                        break;
                    }
                    f6 += this.f48755j.getPageWidth(i12) + f2;
                    i12++;
                }
                if (i3 == i10) {
                    this.v = (dVar8.f48766d + f6) - 1.0f;
                }
                dVar8.f48767e = f6;
                f6 += dVar8.f48766d + f2;
                i13++;
                i12++;
            }
        }
    }

    public void fakeDragBy(float f2) {
        ArrayList<d> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048599, this, f2) == null) {
            if (this.Q) {
                this.H += f2;
                float scrollY = getScrollY() - f2;
                float clientHeight = getClientHeight();
                float f3 = this.u * clientHeight;
                float f4 = this.v * clientHeight;
                d dVar = this.f48752g.get(0);
                d dVar2 = this.f48752g.get(arrayList.size() - 1);
                if (dVar.f48764b != 0) {
                    f3 = dVar.f48767e * clientHeight;
                }
                if (dVar2.f48764b != this.f48755j.getCount() - 1) {
                    f4 = dVar2.f48767e * clientHeight;
                }
                if (scrollY < f3) {
                    scrollY = f3;
                } else if (scrollY > f4) {
                    scrollY = f4;
                }
                int i2 = (int) scrollY;
                this.H += scrollY - i2;
                scrollTo(getScrollX(), i2);
                pageScrolled(i2);
                MotionEvent obtain = MotionEvent.obtain(this.R, SystemClock.uptimeMillis(), 2, 0.0f, this.H, 0);
                this.L.addMovement(obtain);
                obtain.recycle();
                return;
            }
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
    }

    public final void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            boolean z2 = this.o0 == 2;
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
            for (int i2 = 0; i2 < this.f48752g.size(); i2++) {
                d dVar = this.f48752g.get(i2);
                if (dVar.f48765c) {
                    dVar.f48765c = false;
                    z2 = true;
                }
            }
            if (z2) {
                if (z) {
                    ViewCompat.postOnAnimation(this, this.n0);
                } else {
                    this.n0.run();
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? new LayoutParams() : (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, layoutParams)) == null) ? generateDefaultLayoutParams() : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public PagerAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f48755j : (PagerAdapter) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048605, this, i2, i3)) == null) {
            if (this.k0 == 2) {
                i3 = (i2 - 1) - i3;
            }
            return ((LayoutParams) this.l0.get(i3).getLayoutParams()).f48761f;
        }
        return invokeII.intValue;
    }

    public int getCurrentItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.k : invokeV.intValue;
    }

    public int getOffscreenPageLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.A : invokeV.intValue;
    }

    public int getPageMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.q : invokeV.intValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            int count = this.f48755j.getCount();
            this.f48750e = count;
            boolean z = this.f48752g.size() < (this.A * 2) + 1 && this.f48752g.size() < count;
            int i2 = this.k;
            int i3 = 0;
            boolean z2 = false;
            while (i3 < this.f48752g.size()) {
                d dVar = this.f48752g.get(i3);
                int itemPosition = this.f48755j.getItemPosition(dVar.f48763a);
                if (itemPosition != -1) {
                    if (itemPosition == -2) {
                        this.f48752g.remove(i3);
                        i3--;
                        if (!z2) {
                            this.f48755j.startUpdate((ViewGroup) this);
                            z2 = true;
                        }
                        this.f48755j.destroyItem((ViewGroup) this, dVar.f48764b, dVar.f48763a);
                        int i4 = this.k;
                        if (i4 == dVar.f48764b) {
                            i2 = Math.max(0, Math.min(i4, count - 1));
                        }
                    } else {
                        int i5 = dVar.f48764b;
                        if (i5 != itemPosition) {
                            if (i5 == this.k) {
                                i2 = itemPosition;
                            }
                            dVar.f48764b = itemPosition;
                        }
                    }
                    z = true;
                }
                i3++;
            }
            if (z2) {
                this.f48755j.finishUpdate((ViewGroup) this);
            }
            Collections.sort(this.f48752g, r0);
            if (z) {
                int childCount = getChildCount();
                for (int i6 = 0; i6 < childCount; i6++) {
                    LayoutParams layoutParams = (LayoutParams) getChildAt(i6).getLayoutParams();
                    if (!layoutParams.f48756a) {
                        layoutParams.f48758c = 0.0f;
                    }
                }
                D(i2, false, true);
                requestLayout();
            }
        }
    }

    public final int i(int i2, float f2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (Math.abs(i4) <= this.O || Math.abs(i3) <= this.M) {
                i2 = (int) (i2 + f2 + (i2 >= this.k ? 0.4f : 0.6f));
            } else if (i3 <= 0) {
                i2++;
            }
            if (this.f48752g.size() > 0) {
                ArrayList<d> arrayList = this.f48752g;
                return Math.max(this.f48752g.get(0).f48764b, Math.min(i2, arrayList.get(arrayList.size() - 1).f48764b));
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public boolean internalCanScrollVertically(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i2)) == null) {
            if (this.f48755j == null) {
                return false;
            }
            int clientHeight = getClientHeight();
            int scrollY = getScrollY();
            return i2 < 0 ? scrollY > ((int) (((float) clientHeight) * this.u)) : i2 > 0 && scrollY < ((int) (((float) clientHeight) * this.v));
        }
        return invokeI.booleanValue;
    }

    public boolean isFakeDragging() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.Q : invokeV.booleanValue;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public float j(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048614, this, f2)) == null) ? (float) Math.sin((float) ((f2 - 0.5f) * 0.4712389167638204d)) : invokeF.floatValue;
    }

    public final void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                ViewCompat.setLayerType(getChildAt(i2), z ? 2 : 0, null);
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.B = false;
            this.C = false;
            VelocityTracker velocityTracker = this.L;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.L = null;
            }
        }
    }

    public final Rect m(Rect rect, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048617, this, rect, view)) == null) {
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
        return (Rect) invokeLL.objValue;
    }

    public d n(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048618, this, view)) != null) {
            return (d) invokeL.objValue;
        }
        while (true) {
            ViewParent parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return o(view);
            }
        }
    }

    public d o(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, view)) == null) {
            for (int i2 = 0; i2 < this.f48752g.size(); i2++) {
                d dVar = this.f48752g.get(i2);
                if (this.f48755j.isViewFromObject(view, dVar.f48763a)) {
                    return dVar;
                }
            }
            return null;
        }
        return (d) invokeL.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.onAttachedToWindow();
            this.U = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            removeCallbacks(this.n0);
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int height;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.q <= 0 || this.r == null || this.f48752g.size() <= 0 || this.f48755j == null) {
                return;
            }
            int scrollY = getScrollY();
            float height2 = getHeight();
            float f4 = this.q / height2;
            int i2 = 0;
            d dVar = this.f48752g.get(0);
            float f5 = dVar.f48767e;
            int size = this.f48752g.size();
            int i3 = dVar.f48764b;
            int i4 = this.f48752g.get(size - 1).f48764b;
            while (i3 < i4) {
                while (i3 > dVar.f48764b && i2 < size) {
                    i2++;
                    dVar = this.f48752g.get(i2);
                }
                if (i3 == dVar.f48764b) {
                    float f6 = dVar.f48767e;
                    float f7 = dVar.f48766d;
                    f2 = (f6 + f7) * height2;
                    f5 = f6 + f7 + f4;
                } else {
                    float pageWidth = this.f48755j.getPageWidth(i3);
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
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, motionEvent)) == null) {
            if (this.m0) {
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
                        if (this.o0 == 2 && Math.abs(this.o.getFinalY() - this.o.getCurrY()) > this.P) {
                            this.o.abortAnimation();
                            this.z = false;
                            x();
                            this.B = true;
                            B(true);
                            setScrollState(1);
                        } else {
                            g(false);
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
                            if (i3 != 0 && !s(this.H, f2) && canScroll(this, false, (int) f2, (int) x2, (int) y2)) {
                                this.G = x2;
                                this.H = y2;
                                this.C = true;
                                return false;
                            }
                            if (abs > this.F && abs * 0.5f > abs2) {
                                this.B = true;
                                B(true);
                                setScrollState(1);
                                float f3 = this.J;
                                float f4 = this.F;
                                this.H = i3 > 0 ? f3 + f4 : f3 - f4;
                                this.G = x2;
                                setScrollingCacheEnabled(true);
                            } else if (abs2 > this.F) {
                                this.C = true;
                            }
                            if (this.B && w(y2)) {
                                ViewCompat.postInvalidateOnAnimation(this);
                            }
                        }
                    } else if (action == 6) {
                        t(motionEvent);
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
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0092  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        d o;
        int max;
        int i6;
        int max2;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
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
                    if (layoutParams.f48756a) {
                        int i12 = layoutParams.f48757b;
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
                    if (!layoutParams2.f48756a && (o = o(childAt2)) != null) {
                        float f2 = i18;
                        int i20 = ((int) (o.f48767e * f2)) + paddingTop;
                        if (layoutParams2.f48759d) {
                            layoutParams2.f48759d = false;
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec((i8 - paddingLeft) - paddingRight, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (f2 * layoutParams2.f48758c), 1073741824));
                        }
                        childAt2.layout(paddingLeft, i20, childAt2.getMeasuredWidth() + paddingLeft, childAt2.getMeasuredHeight() + i20);
                    }
                }
            }
            this.s = paddingLeft;
            this.t = i8 - paddingRight;
            this.W = i10;
            if (this.U) {
                z2 = false;
                C(this.k, false, 0, false);
            } else {
                z2 = false;
            }
            this.U = z2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ac  */
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048625, this, i2, i3) == null) {
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
                if (childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.f48756a) {
                    int i9 = layoutParams2.f48757b;
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
            x();
            this.x = false;
            int childCount2 = getChildCount();
            for (int i13 = 0; i13 < childCount2; i13++) {
                View childAt2 = getChildAt(i13);
                if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.f48756a)) {
                    childAt2.measure(this.w, View.MeasureSpec.makeMeasureSpec((int) (paddingTop * layoutParams.f48758c), 1073741824));
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPageScrolled(int i2, float f2, int i3) {
        int max;
        int i4;
        int top;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            if (this.W > 0) {
                int scrollY = getScrollY();
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int childCount = getChildCount();
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = getChildAt(i5);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.f48756a) {
                        int i6 = layoutParams.f48757b & 112;
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
            ViewPager.OnPageChangeListener onPageChangeListener = this.a0;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i2, f2, i3);
            }
            ViewPager.OnPageChangeListener onPageChangeListener2 = this.b0;
            if (onPageChangeListener2 != null) {
                onPageChangeListener2.onPageScrolled(i2, f2, i3);
            }
            if (this.i0 != null) {
                int scrollY2 = getScrollY();
                int childCount2 = getChildCount();
                for (int i8 = 0; i8 < childCount2; i8++) {
                    View childAt2 = getChildAt(i8);
                    if (!((LayoutParams) childAt2.getLayoutParams()).f48756a) {
                        this.i0.transformPage(childAt2, (childAt2.getTop() - scrollY2) / getClientHeight());
                    }
                }
            }
            this.V = true;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        InterceptResult invokeIL;
        int i3;
        int i4;
        d o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048627, this, i2, rect)) == null) {
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
                if (childAt.getVisibility() == 0 && (o = o(childAt)) != null && o.f48764b == this.k && childAt.requestFocus(i2, rect)) {
                    return true;
                }
                i3 += i4;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, parcelable) == null) {
            if (!(parcelable instanceof SavedState)) {
                super.onRestoreInstanceState(parcelable);
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            PagerAdapter pagerAdapter = this.f48755j;
            if (pagerAdapter != null) {
                pagerAdapter.restoreState(savedState.adapterState, savedState.loader);
                D(savedState.position, false, true);
                return;
            }
            this.l = savedState.position;
            this.m = savedState.adapterState;
            this.n = savedState.loader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.position = this.k;
            PagerAdapter pagerAdapter = this.f48755j;
            if (pagerAdapter != null) {
                savedState.adapterState = pagerAdapter.saveState();
            }
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048630, this, i2, i3, i4, i5) == null) {
            super.onSizeChanged(i2, i3, i4, i5);
            if (i3 != i5) {
                int i6 = this.q;
                z(i3, i5, i6, i6);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        PagerAdapter pagerAdapter;
        boolean onRelease;
        boolean onRelease2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, motionEvent)) == null) {
            boolean z = false;
            if (this.m0) {
                if (this.Q) {
                    return true;
                }
                this.p0.d(motionEvent);
                if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.f48755j) == null || pagerAdapter.getCount() == 0) {
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
                    x();
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
                                B(true);
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
                            z = false | w(MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.K)));
                        }
                    } else if (action != 3) {
                        if (action == 5) {
                            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                            this.H = MotionEventCompat.getY(motionEvent, actionIndex);
                            this.K = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                        } else if (action == 6) {
                            t(motionEvent);
                            this.H = MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.K));
                        }
                    } else if (this.B) {
                        C(this.k, true, 0, false);
                        this.K = -1;
                        l();
                        onRelease = this.S.onRelease();
                        onRelease2 = this.T.onRelease();
                        z = onRelease | onRelease2;
                    }
                } else if (this.B) {
                    VelocityTracker velocityTracker = this.L;
                    velocityTracker.computeCurrentVelocity(1000, this.N);
                    int yVelocity = (int) VelocityTrackerCompat.getYVelocity(velocityTracker, this.K);
                    this.z = true;
                    int clientHeight = getClientHeight();
                    int scrollY = getScrollY();
                    d p = p();
                    E(i(p.f48764b, ((scrollY / clientHeight) - p.f48767e) / p.f48766d, yVelocity, (int) (MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.K)) - this.J)), true, true, yVelocity);
                    this.K = -1;
                    l();
                    onRelease = this.S.onRelease();
                    onRelease2 = this.T.onRelease();
                    z = onRelease | onRelease2;
                }
                if (z) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final d p() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            int clientHeight = getClientHeight();
            float f2 = 0.0f;
            float scrollY = clientHeight > 0 ? getScrollY() / clientHeight : 0.0f;
            float f3 = clientHeight > 0 ? this.q / clientHeight : 0.0f;
            d dVar = null;
            float f4 = 0.0f;
            int i3 = -1;
            int i4 = 0;
            boolean z = true;
            while (i4 < this.f48752g.size()) {
                d dVar2 = this.f48752g.get(i4);
                if (!z && dVar2.f48764b != (i2 = i3 + 1)) {
                    dVar2 = this.f48753h;
                    dVar2.f48767e = f2 + f4 + f3;
                    dVar2.f48764b = i2;
                    dVar2.f48766d = this.f48755j.getPageWidth(i2);
                    i4--;
                }
                f2 = dVar2.f48767e;
                float f5 = dVar2.f48766d + f2 + f3;
                if (!z && scrollY < f2) {
                    return dVar;
                }
                if (scrollY < f5 || i4 == this.f48752g.size() - 1) {
                    return dVar2;
                }
                i3 = dVar2.f48764b;
                f4 = dVar2.f48766d;
                i4++;
                dVar = dVar2;
                z = false;
            }
            return dVar;
        }
        return (d) invokeV.objValue;
    }

    public boolean pageScrolled(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048633, this, i2)) == null) {
            if (this.f48752g.size() == 0) {
                this.V = false;
                onPageScrolled(0, 0.0f, 0);
                if (this.V) {
                    return false;
                }
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
            d p = p();
            int clientHeight = getClientHeight();
            int i3 = this.q;
            int i4 = clientHeight + i3;
            float f2 = clientHeight;
            int i5 = p.f48764b;
            float f3 = ((i2 / f2) - p.f48767e) / (p.f48766d + (i3 / f2));
            this.V = false;
            onPageScrolled(i5, f3, (int) (i4 * f3));
            if (this.V) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        return invokeI.booleanValue;
    }

    public d q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048634, this, i2)) == null) {
            for (int i3 = 0; i3 < this.f48752g.size(); i3++) {
                d dVar = this.f48752g.get(i3);
                if (dVar.f48764b == i2) {
                    return dVar;
                }
            }
            return null;
        }
        return (d) invokeI.objValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            setWillNotDraw(false);
            setDescendantFocusability(262144);
            setFocusable(true);
            Context context = getContext();
            this.o = new Scroller(context, s0);
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            float f2 = context.getResources().getDisplayMetrics().density;
            this.F = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
            this.M = (int) (400.0f * f2);
            this.N = viewConfiguration.getScaledMaximumFlingVelocity();
            this.S = new EdgeEffectCompat(context);
            this.T = new EdgeEffectCompat(context);
            this.O = (int) (25.0f * f2);
            this.P = (int) (2.0f * f2);
            this.D = (int) (f2 * 16.0f);
            ViewCompat.setAccessibilityDelegate(this, new e(this));
            if (ViewCompat.getImportantForAccessibility(this) == 0) {
                ViewCompat.setImportantForAccessibility(this, 1);
            }
            this.p0 = new c.a.o0.d1.q.a(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, view) == null) {
            if (this.x) {
                removeViewInLayout(view);
            } else {
                super.removeView(view);
            }
        }
    }

    public final boolean s(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048637, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? (f2 < ((float) this.E) && f3 > 0.0f) || (f2 > ((float) (getHeight() - this.E)) && f3 < 0.0f) : invokeCommon.booleanValue;
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, pagerAdapter) == null) {
            PagerAdapter pagerAdapter2 = this.f48755j;
            if (pagerAdapter2 != null) {
                pagerAdapter2.unregisterDataSetObserver(this.p);
                this.f48755j.startUpdate((ViewGroup) this);
                for (int i2 = 0; i2 < this.f48752g.size(); i2++) {
                    d dVar = this.f48752g.get(i2);
                    this.f48755j.destroyItem((ViewGroup) this, dVar.f48764b, dVar.f48763a);
                }
                this.f48755j.finishUpdate((ViewGroup) this);
                this.f48752g.clear();
                A();
                this.k = 0;
                scrollTo(0, 0);
            }
            PagerAdapter pagerAdapter3 = this.f48755j;
            this.f48755j = pagerAdapter;
            this.f48750e = 0;
            if (pagerAdapter != null) {
                if (this.p == null) {
                    this.p = new g(this, null);
                }
                this.f48755j.registerDataSetObserver(this.p);
                this.z = false;
                boolean z = this.U;
                this.U = true;
                this.f48750e = this.f48755j.getCount();
                if (this.l >= 0) {
                    this.f48755j.restoreState(this.m, this.n);
                    D(this.l, false, true);
                    this.l = -1;
                    this.m = null;
                    this.n = null;
                } else if (!z) {
                    x();
                } else {
                    requestLayout();
                }
            }
            f fVar = this.c0;
            if (fVar == null || pagerAdapter3 == pagerAdapter) {
                return;
            }
            fVar.a(pagerAdapter3, pagerAdapter);
        }
    }

    public void setChildrenDrawingOrderEnabledCompat(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048639, this, z) == null) || Build.VERSION.SDK_INT < 7) {
            return;
        }
        if (this.j0 == null) {
            try {
                this.j0 = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
            }
        }
        try {
            this.j0.invoke(this, Boolean.valueOf(z));
        } catch (Exception unused2) {
        }
    }

    public void setCurrentItem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i2) == null) {
            this.z = false;
            D(i2, !this.U, false);
        }
    }

    public void setEventListener(a.b bVar) {
        c.a.o0.d1.q.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048642, this, bVar) == null) || (aVar = this.p0) == null) {
            return;
        }
        aVar.f(bVar);
    }

    public void setNeedHanleTouch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048643, this, z) == null) {
            this.f48751f = z;
        }
    }

    public void setOffscreenPageLimit(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i2) == null) {
            if (i2 < 1) {
                String str = "Requested offscreen page limit " + i2 + " too small; defaulting to 1";
                i2 = 1;
            }
            if (i2 != this.A) {
                this.A = i2;
                x();
            }
        }
    }

    public void setOnAdapterChangeListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, fVar) == null) {
            this.c0 = fVar;
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, onPageChangeListener) == null) {
            this.a0 = onPageChangeListener;
        }
    }

    public void setPageMargin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i2) == null) {
            int i3 = this.q;
            this.q = i2;
            int height = getHeight();
            z(height, height, i2, i3);
            requestLayout();
        }
    }

    public void setPageMarginDrawable(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, drawable) == null) {
            this.r = drawable;
            if (drawable != null) {
                refreshDrawableState();
            }
            setWillNotDraw(drawable == null);
            invalidate();
        }
    }

    public void setPageTransformer(boolean z, ViewPager.PageTransformer pageTransformer) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048650, this, z, pageTransformer) == null) || Build.VERSION.SDK_INT < 11) {
            return;
        }
        boolean z2 = pageTransformer != null;
        boolean z3 = z2 != (this.i0 != null);
        this.i0 = pageTransformer;
        setChildrenDrawingOrderEnabledCompat(z2);
        if (z2) {
            this.k0 = z ? 2 : 1;
        } else {
            this.k0 = 0;
        }
        if (z3) {
            x();
        }
    }

    public void setScrollable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048651, this, z) == null) {
            this.m0 = z;
        }
    }

    public final void t(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, motionEvent) == null) {
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
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            PagerAdapter pagerAdapter = this.f48755j;
            if (pagerAdapter == null || this.k >= pagerAdapter.getCount() - 1) {
                return false;
            }
            setCurrentItem(this.k + 1, true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            int i2 = this.k;
            if (i2 > 0) {
                setCurrentItem(i2 - 1, true);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048655, this, drawable)) == null) ? super.verifyDrawable(drawable) || drawable == this.r : invokeL.booleanValue;
    }

    public final boolean w(float f2) {
        InterceptResult invokeF;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048656, this, f2)) == null) {
            float f3 = this.H - f2;
            this.H = f2;
            float scrollY = getScrollY() + f3;
            float clientHeight = getClientHeight();
            float f4 = this.u * clientHeight;
            float f5 = this.v * clientHeight;
            d dVar = this.f48752g.get(0);
            ArrayList<d> arrayList = this.f48752g;
            boolean z2 = true;
            d dVar2 = arrayList.get(arrayList.size() - 1);
            if (dVar.f48764b != 0) {
                f4 = dVar.f48767e * clientHeight;
                z = false;
            } else {
                z = true;
            }
            if (dVar2.f48764b != this.f48755j.getCount() - 1) {
                f5 = dVar2.f48767e * clientHeight;
                z2 = false;
            }
            if (scrollY < f4) {
                r4 = z ? this.S.onPull(Math.abs(f4 - scrollY) / clientHeight) : false;
                scrollY = f4;
            } else if (scrollY > f5) {
                r4 = z2 ? this.T.onPull(Math.abs(scrollY - f5) / clientHeight) : false;
                scrollY = f5;
            }
            int i2 = (int) scrollY;
            this.G += scrollY - i2;
            scrollTo(getScrollX(), i2);
            pageScrolled(i2);
            return r4;
        }
        return invokeF.booleanValue;
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            y(this.k);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x006e, code lost:
        if (r10 == r11) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void y(int i2) {
        int i3;
        d dVar;
        String hexString;
        d dVar2;
        d o;
        d dVar3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048658, this, i2) == null) {
            int i4 = this.k;
            if (i4 != i2) {
                i3 = i4 < i2 ? IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER : 33;
                dVar = q(this.k);
                this.k = i2;
            } else {
                i3 = 2;
                dVar = null;
            }
            if (this.f48755j == null) {
                G();
            } else if (this.z) {
                G();
            } else if (getWindowToken() != null) {
                this.f48755j.startUpdate((ViewGroup) this);
                int i5 = this.A;
                int max = Math.max(0, this.k - i5);
                int count = this.f48755j.getCount();
                int min = Math.min(count - 1, this.k + i5);
                if (count == this.f48750e) {
                    int i6 = 0;
                    while (true) {
                        if (i6 >= this.f48752g.size()) {
                            break;
                        }
                        dVar2 = this.f48752g.get(i6);
                        int i7 = dVar2.f48764b;
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
                        d dVar4 = i9 >= 0 ? this.f48752g.get(i9) : null;
                        int clientHeight = getClientHeight();
                        float paddingLeft = clientHeight <= 0 ? 0.0f : (2.0f - dVar2.f48766d) + (getPaddingLeft() / clientHeight);
                        float f2 = 0.0f;
                        for (int i10 = this.k - 1; i10 >= 0; i10--) {
                            if (f2 < paddingLeft || i10 >= max) {
                                if (dVar4 != null && i10 == dVar4.f48764b) {
                                    f2 += dVar4.f48766d;
                                    i9--;
                                    if (i9 >= 0) {
                                        dVar3 = this.f48752g.get(i9);
                                        dVar4 = dVar3;
                                    }
                                    dVar3 = null;
                                    dVar4 = dVar3;
                                } else {
                                    f2 += e(i10, i9 + 1).f48766d;
                                    i6++;
                                    if (i9 >= 0) {
                                        dVar3 = this.f48752g.get(i9);
                                        dVar4 = dVar3;
                                    }
                                    dVar3 = null;
                                    dVar4 = dVar3;
                                }
                            } else if (dVar4 == null) {
                                break;
                            } else {
                                if (i10 == dVar4.f48764b && !dVar4.f48765c) {
                                    this.f48752g.remove(i9);
                                    this.f48755j.destroyItem((ViewGroup) this, i10, dVar4.f48763a);
                                    i9--;
                                    i6--;
                                    if (i9 >= 0) {
                                        dVar3 = this.f48752g.get(i9);
                                        dVar4 = dVar3;
                                    }
                                    dVar3 = null;
                                    dVar4 = dVar3;
                                }
                            }
                        }
                        float f3 = dVar2.f48766d;
                        int i11 = i6 + 1;
                        if (f3 < 2.0f) {
                            d dVar5 = i11 < this.f48752g.size() ? this.f48752g.get(i11) : null;
                            float paddingRight = clientHeight <= 0 ? 0.0f : (getPaddingRight() / clientHeight) + 2.0f;
                            int i12 = this.k;
                            while (true) {
                                i12++;
                                if (i12 >= count) {
                                    break;
                                } else if (f3 < paddingRight || i12 <= min) {
                                    if (dVar5 != null && i12 == dVar5.f48764b) {
                                        f3 += dVar5.f48766d;
                                        i11++;
                                        if (i11 < this.f48752g.size()) {
                                            dVar5 = this.f48752g.get(i11);
                                        }
                                    } else {
                                        d e2 = e(i12, i11);
                                        i11++;
                                        f3 += e2.f48766d;
                                        dVar5 = i11 < this.f48752g.size() ? this.f48752g.get(i11) : null;
                                    }
                                } else if (dVar5 == null) {
                                    break;
                                } else if (i12 == dVar5.f48764b && !dVar5.f48765c) {
                                    this.f48752g.remove(i11);
                                    this.f48755j.destroyItem((ViewGroup) this, i12, dVar5.f48763a);
                                    if (i11 < this.f48752g.size()) {
                                        dVar5 = this.f48752g.get(i11);
                                    }
                                }
                            }
                        }
                        f(dVar2, i6, dVar);
                    }
                    this.f48755j.setPrimaryItem((ViewGroup) this, this.k, dVar2 != null ? dVar2.f48763a : null);
                    this.f48755j.finishUpdate((ViewGroup) this);
                    int childCount = getChildCount();
                    for (int i13 = 0; i13 < childCount; i13++) {
                        View childAt = getChildAt(i13);
                        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                        layoutParams.f48761f = i13;
                        if (!layoutParams.f48756a && layoutParams.f48758c == 0.0f && (o = o(childAt)) != null) {
                            layoutParams.f48758c = o.f48766d;
                            layoutParams.f48760e = o.f48764b;
                        }
                    }
                    G();
                    if (hasFocus()) {
                        View findFocus = findFocus();
                        d n = findFocus != null ? n(findFocus) : null;
                        if (n == null || n.f48764b != this.k) {
                            for (int i14 = 0; i14 < getChildCount(); i14++) {
                                View childAt2 = getChildAt(i14);
                                d o2 = o(childAt2);
                                if (o2 != null && o2.f48764b == this.k && childAt2.requestFocus(i3)) {
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
                throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f48750e + ", found: " + count + " Pager id: " + hexString + " Pager class: " + VerticalViewPager.class + " Problematic adapter: " + this.f48755j.getClass());
            }
        }
    }

    public final void z(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048659, this, i2, i3, i4, i5) == null) {
            if (i3 > 0 && !this.f48752g.isEmpty()) {
                int scrollY = (int) ((getScrollY() / (((i3 - getPaddingTop()) - getPaddingBottom()) + i5)) * (((i2 - getPaddingTop()) - getPaddingBottom()) + i4));
                scrollTo(getScrollX(), scrollY);
                if (this.o.isFinished()) {
                    return;
                }
                this.o.startScroll(0, scrollY, 0, (int) (q(this.k).f48767e * i2), this.o.getDuration() - this.o.timePassed());
                return;
            }
            d q = q(this.k);
            int min = (int) ((q != null ? Math.min(q.f48767e, this.v) : 0.0f) * ((i2 - getPaddingTop()) - getPaddingBottom()));
            if (min != getScrollY()) {
                g(false);
                scrollTo(getScrollX(), min);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f48756a;

        /* renamed from: b  reason: collision with root package name */
        public int f48757b;

        /* renamed from: c  reason: collision with root package name */
        public float f48758c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f48759d;

        /* renamed from: e  reason: collision with root package name */
        public int f48760e;

        /* renamed from: f  reason: collision with root package name */
        public int f48761f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams() {
            super(-1, -1);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr = newInitContext.callArgs;
                    super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48758c = 0.0f;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f48758c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, VerticalViewPager.q0);
            this.f48757b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public void setCurrentItem(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048641, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.z = false;
            D(i2, z, false);
        }
    }

    public void setPageMarginDrawable(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048648, this, i2) == null) {
            setPageMarginDrawable(getContext().getResources().getDrawable(i2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerticalViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f48752g = new ArrayList<>();
        this.f48753h = new d();
        this.f48754i = new Rect();
        this.l = -1;
        this.m = null;
        this.n = null;
        this.u = -3.4028235E38f;
        this.v = Float.MAX_VALUE;
        this.A = 1;
        this.K = -1;
        this.U = true;
        this.m0 = true;
        this.n0 = new c(this);
        this.o0 = 0;
        r();
    }
}
