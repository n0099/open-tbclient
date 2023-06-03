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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.x26;
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
/* loaded from: classes4.dex */
public class VerticalViewPager extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] h0;
    public static final Comparator<d> i0;
    public static final Interpolator j0;
    public static final h r0;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public float C;
    public float D;
    public float E;
    public float F;
    public int G;
    public VelocityTracker H;
    public int I;
    public int J;
    public int K;
    public int L;
    public boolean M;
    public EdgeEffectCompat N;
    public EdgeEffectCompat O;
    public boolean P;
    public boolean Q;
    public int R;
    public ViewPager.OnPageChangeListener S;

    /* renamed from: T  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f1086T;
    public f U;
    public ViewPager.PageTransformer V;
    public Method W;
    public int a;
    public int a0;
    public boolean b;
    public ArrayList<View> b0;
    public final ArrayList<d> c;
    public boolean c0;
    public final d d;
    public boolean d0;
    public final Rect e;
    public final Runnable e0;
    public PagerAdapter f;
    public int f0;
    public int g;
    public x26 g0;
    public int h;
    public Parcelable i;
    public ClassLoader j;
    public Scroller k;
    public g l;
    public int m;
    public Drawable n;
    public int o;
    public int p;
    public float q;
    public float r;
    public int s;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public boolean x;
    public boolean y;
    public int z;

    /* loaded from: classes4.dex */
    public interface f {
        void onAdapterChanged(PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes4.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public Parcelable adapterState;
        public ClassLoader loader;
        public int position;

        /* loaded from: classes4.dex */
        public static class a implements ParcelableCompatCreatorCallbacks<SavedState> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, parcel, classLoader)) == null) {
                    return new SavedState(parcel, classLoader);
                }
                return (SavedState) invokeLL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            /* renamed from: b */
            public SavedState[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                    return new SavedState[i];
                }
                return (SavedState[]) invokeI.objValue;
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
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel, classLoader};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable parcelable) {
            super(parcelable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelable};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i) == null) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.position);
                parcel.writeParcelable(this.adapterState, i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public int b;
        public float c;
        public boolean d;
        public int e;
        public int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams() {
            super(-1, -1);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr = newInitContext.callArgs;
                    super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = 0.0f;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.c = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, VerticalViewPager.h0);
            this.b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes4.dex */
    public static class a implements Comparator<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, dVar, dVar2)) == null) {
                return dVar.b - dVar2.b;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements Interpolator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
            return invokeF.floatValue;
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VerticalViewPager a;

        public c(VerticalViewPager verticalViewPager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {verticalViewPager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = verticalViewPager;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.setScrollState(0);
            this.a.D();
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Object a;
        public int b;
        public boolean c;
        public float d;
        public float e;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends AccessibilityDelegateCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VerticalViewPager a;

        public e(VerticalViewPager verticalViewPager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {verticalViewPager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = verticalViewPager;
        }

        public final boolean canScroll() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.f != null && this.a.f.getCount() > 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view2, AccessibilityEvent accessibilityEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, accessibilityEvent) == null) {
                super.onInitializeAccessibilityEvent(view2, accessibilityEvent);
                accessibilityEvent.setClassName(ViewPager.class.getName());
                AccessibilityRecordCompat obtain = AccessibilityRecordCompat.obtain();
                obtain.setScrollable(canScroll());
                if (accessibilityEvent.getEventType() == 4096 && this.a.f != null) {
                    obtain.setItemCount(this.a.f.getCount());
                    obtain.setFromIndex(this.a.g);
                    obtain.setToIndex(this.a.g);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, accessibilityNodeInfoCompat) == null) {
                super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
                accessibilityNodeInfoCompat.setScrollable(canScroll());
                if (this.a.v(1)) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
                if (this.a.v(-1)) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view2, int i, Bundle bundle) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048579, this, view2, i, bundle)) == null) {
                if (super.performAccessibilityAction(view2, i, bundle)) {
                    return true;
                }
                if (i != 4096) {
                    if (i != 8192 || !this.a.v(-1)) {
                        return false;
                    }
                    VerticalViewPager verticalViewPager = this.a;
                    verticalViewPager.setCurrentItem(verticalViewPager.g - 1);
                    return true;
                } else if (!this.a.v(1)) {
                    return false;
                } else {
                    VerticalViewPager verticalViewPager2 = this.a;
                    verticalViewPager2.setCurrentItem(verticalViewPager2.g + 1);
                    return true;
                }
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class g extends DataSetObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VerticalViewPager a;

        public g(VerticalViewPager verticalViewPager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {verticalViewPager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = verticalViewPager;
        }

        public /* synthetic */ g(VerticalViewPager verticalViewPager, a aVar) {
            this(verticalViewPager);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.j();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class h implements Comparator<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(View view2, View view3) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, view3)) == null) {
                LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                LayoutParams layoutParams2 = (LayoutParams) view3.getLayoutParams();
                boolean z = layoutParams.a;
                if (z != layoutParams2.a) {
                    if (z) {
                        return 1;
                    }
                    return -1;
                }
                return layoutParams.e - layoutParams2.e;
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
        h0 = new int[]{16842931};
        i0 = new a();
        j0 = new b();
        r0 = new h();
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.a0 != 0) {
            ArrayList<View> arrayList = this.b0;
            if (arrayList == null) {
                this.b0 = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.b0.add(getChildAt(i));
            }
            Collections.sort(this.b0, r0);
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new ArrayList<>();
        this.d = new d();
        this.e = new Rect();
        this.h = -1;
        this.i = null;
        this.j = null;
        this.q = -3.4028235E38f;
        this.r = Float.MAX_VALUE;
        this.w = 1;
        this.G = -1;
        this.P = true;
        this.c0 = true;
        this.d0 = true;
        this.e0 = new c(this);
        this.f0 = 0;
        u();
    }

    public final void i(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            if (this.f0 == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                setScrollingCacheEnabled(false);
                this.k.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.k.getCurrX();
                int currY = this.k.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                }
            }
            this.v = false;
            for (int i = 0; i < this.c.size(); i++) {
                d dVar = this.c.get(i);
                if (dVar.c) {
                    dVar.c = false;
                    z2 = true;
                }
            }
            if (z2) {
                if (z) {
                    ViewCompat.postOnAnimation(this, this.e0);
                } else {
                    this.e0.run();
                }
            }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.c = new ArrayList<>();
        this.d = new d();
        this.e = new Rect();
        this.h = -1;
        this.i = null;
        this.j = null;
        this.q = -3.4028235E38f;
        this.r = Float.MAX_VALUE;
        this.w = 1;
        this.G = -1;
        this.P = true;
        this.c0 = true;
        this.d0 = true;
        this.e0 = new c(this);
        this.f0 = 0;
        u();
    }

    public final Rect p(Rect rect, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048629, this, rect, view2)) == null) {
            if (rect == null) {
                rect = new Rect();
            }
            if (view2 == null) {
                rect.set(0, 0, 0, 0);
                return rect;
            }
            rect.left = view2.getLeft();
            rect.right = view2.getRight();
            rect.top = view2.getTop();
            rect.bottom = view2.getBottom();
            ViewParent parent = view2.getParent();
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

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048605, this, i, i2)) == null) {
            if (this.a0 == 2) {
                i2 = (i - 1) - i2;
            }
            return ((LayoutParams) this.b0.get(i2).getLayoutParams()).f;
        }
        return invokeII.intValue;
    }

    public void setCurrentItem(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048637, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.v = false;
            J(i, z, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollState(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(65544, this, i) != null) || this.f0 == i) {
            return;
        }
        this.f0 = i;
        if (this.V != null) {
            if (i != 0) {
                z = true;
            } else {
                z = false;
            }
            m(z);
        }
        ViewPager.OnPageChangeListener onPageChangeListener = this.S;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65545, this, z) == null) && this.u != z) {
            this.u = z;
        }
    }

    public final void H(boolean z) {
        ViewParent parent;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && (parent = getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, layoutParams)) == null) {
            if ((layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, keyEvent)) == null) {
            if (!super.dispatchKeyEvent(keyEvent) && !o(keyEvent)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, attributeSet)) == null) {
            return new LayoutParams(getContext(), attributeSet);
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public float l(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048614, this, f2)) == null) {
            return (float) Math.sin((float) ((f2 - 0.5f) * 0.4712389167638204d));
        }
        return invokeF.floatValue;
    }

    public final void m(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (z) {
                    i = 2;
                } else {
                    i = 0;
                }
                ViewCompat.setLayerType(getChildAt(i2), i, null);
            }
        }
    }

    public d q(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048630, this, view2)) != null) {
            return (d) invokeL.objValue;
        }
        while (true) {
            ViewParent parent = view2.getParent();
            if (parent != this) {
                if (parent != null && (parent instanceof View)) {
                    view2 = (View) parent;
                } else {
                    return null;
                }
            } else {
                return r(view2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, view2) == null) {
            if (this.t) {
                removeViewInLayout(view2);
            } else {
                super.removeView(view2);
            }
        }
    }

    public void setCurrentItem(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i) == null) {
            this.v = false;
            J(i, !this.P, false);
        }
    }

    public void setEventListener(x26.b bVar) {
        x26 x26Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048638, this, bVar) == null) && (x26Var = this.g0) != null) {
            x26Var.f(bVar);
        }
    }

    public void setNeedHanleTouch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048639, this, z) == null) {
            this.b = z;
        }
    }

    public void setOnAdapterChangeListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, fVar) == null) {
            this.U = fVar;
        }
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, onPageChangeListener) == null) {
            this.S = onPageChangeListener;
        }
    }

    public void setPageMargin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048643, this, i) == null) {
            int i2 = this.m;
            this.m = i;
            int height = getHeight();
            F(height, height, i, i2);
            requestLayout();
        }
    }

    public void setPageMarginDrawable(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i) == null) {
            setPageMarginDrawable(getContext().getResources().getDrawable(i));
        }
    }

    public void setScrollable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
            this.c0 = z;
        }
    }

    public void setStrictSlide(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z) == null) {
            this.d0 = z;
        }
    }

    public d t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048649, this, i)) == null) {
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                d dVar = this.c.get(i2);
                if (dVar.b == i) {
                    return dVar;
                }
            }
            return null;
        }
        return (d) invokeI.objValue;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, drawable)) == null) {
            if (!super.verifyDrawable(drawable) && drawable != this.n) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private int getClientHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        }
        return invokeV.intValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = this.g;
            if (i > 0) {
                setCurrentItem(i - 1, true);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            E(this.g);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int i = 0;
            while (i < getChildCount()) {
                if (!((LayoutParams) getChildAt(i).getLayoutParams()).a) {
                    removeViewAt(i);
                    i--;
                }
                i++;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.drawableStateChanged();
            Drawable drawable = this.n;
            if (drawable != null && drawable.isStateful()) {
                drawable.setState(getDrawableState());
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return new LayoutParams();
        }
        return (ViewGroup.LayoutParams) invokeV.objValue;
    }

    public PagerAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.f;
        }
        return (PagerAdapter) invokeV.objValue;
    }

    public int getCurrentItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public int getOffscreenPageLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.w;
        }
        return invokeV.intValue;
    }

    public int getPageMargin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.x = false;
            this.y = false;
            VelocityTracker velocityTracker = this.H;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.H = null;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onAttachedToWindow();
            this.P = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            removeCallbacks(this.e0);
            super.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            savedState.position = this.g;
            PagerAdapter pagerAdapter = this.f;
            if (pagerAdapter != null) {
                savedState.adapterState = pagerAdapter.saveState();
            }
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            PagerAdapter pagerAdapter = this.f;
            if (pagerAdapter != null && this.g < pagerAdapter.getCount() - 1) {
                setCurrentItem(this.g + 1, true);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean A(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (this.c.size() == 0) {
                this.Q = false;
                x(0, 0.0f, 0);
                if (this.Q) {
                    return false;
                }
                throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
            d s = s();
            int clientHeight = getClientHeight();
            int i2 = this.m;
            int i3 = clientHeight + i2;
            float f2 = clientHeight;
            int i4 = s.b;
            float f3 = ((i / f2) - s.e) / (s.d + (i2 / f2));
            this.Q = false;
            x(i4, f3, (int) (i3 * f3));
            if (this.Q) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        return invokeI.booleanValue;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        d r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, accessibilityEvent)) == null) {
            if (accessibilityEvent.getEventType() == 4096) {
                return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() == 0 && (r = r(childAt)) != null && r.b == this.g && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean o(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, keyEvent)) == null) {
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 21) {
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
                } else {
                    return f(17);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean C(float f2) {
        InterceptResult invokeF;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2)) == null) {
            float f3 = this.D - f2;
            this.D = f2;
            float scrollY = getScrollY() + f3;
            float clientHeight = getClientHeight();
            float f4 = this.q * clientHeight;
            float f5 = this.r * clientHeight;
            boolean z3 = true;
            boolean z4 = false;
            if (this.c.size() > 0) {
                d dVar = this.c.get(0);
                ArrayList<d> arrayList = this.c;
                d dVar2 = arrayList.get(arrayList.size() - 1);
                if (dVar.b != 0) {
                    f4 = dVar.e * clientHeight;
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (dVar2.b != this.f.getCount() - 1) {
                    f5 = dVar2.e * clientHeight;
                    z3 = z2;
                    z = false;
                    if (scrollY >= f4) {
                        if (z3) {
                            z4 = this.N.onPull(Math.abs(f4 - scrollY) / clientHeight);
                        }
                        scrollY = f4;
                    } else if (scrollY > f5) {
                        if (z) {
                            z4 = this.O.onPull(Math.abs(scrollY - f5) / clientHeight);
                        }
                        scrollY = f5;
                    }
                    int i = (int) scrollY;
                    this.C += scrollY - i;
                    scrollTo(getScrollX(), i);
                    A(i);
                    return z4;
                }
                z3 = z2;
            }
            z = true;
            if (scrollY >= f4) {
            }
            int i2 = (int) scrollY;
            this.C += scrollY - i2;
            scrollTo(getScrollX(), i2);
            A(i2);
            return z4;
        }
        return invokeF.booleanValue;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, canvas) == null) {
            super.draw(canvas);
            int overScrollMode = ViewCompat.getOverScrollMode(this);
            boolean z = false;
            if (overScrollMode != 0 && (overScrollMode != 1 || (pagerAdapter = this.f) == null || pagerAdapter.getCount() <= 1)) {
                this.N.finish();
                this.O.finish();
            } else {
                if (!this.N.isFinished()) {
                    int save = canvas.save();
                    int height = getHeight();
                    int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                    canvas.translate(getPaddingLeft(), this.q * height);
                    this.N.setSize(width, height);
                    z = false | this.N.draw(canvas);
                    if (save >= 1 && save <= canvas.getSaveCount()) {
                        canvas.restoreToCount(save);
                    }
                }
                if (!this.O.isFinished()) {
                    int save2 = canvas.save();
                    int height2 = getHeight();
                    int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                    canvas.rotate(180.0f);
                    canvas.translate((-width2) - getPaddingLeft(), (-(this.r + 1.0f)) * height2);
                    this.O.setSize(width2, height2);
                    z |= this.O.draw(canvas);
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

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int height;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, canvas) == null) {
            super.onDraw(canvas);
            if (this.m > 0 && this.n != null && this.c.size() > 0 && this.f != null) {
                int scrollY = getScrollY();
                float height2 = getHeight();
                float f4 = this.m / height2;
                int i = 0;
                d dVar = this.c.get(0);
                float f5 = dVar.e;
                int size = this.c.size();
                int i2 = dVar.b;
                int i3 = this.c.get(size - 1).b;
                while (i2 < i3) {
                    while (i2 > dVar.b && i < size) {
                        i++;
                        dVar = this.c.get(i);
                    }
                    if (i2 == dVar.b) {
                        float f6 = dVar.e;
                        float f7 = dVar.d;
                        f2 = (f6 + f7) * height2;
                        f5 = f6 + f7 + f4;
                    } else {
                        float pageWidth = this.f.getPageWidth(i2);
                        f2 = (f5 + pageWidth) * height2;
                        f5 += pageWidth + f4;
                    }
                    int i4 = this.m;
                    if (i4 + f2 > scrollY) {
                        f3 = f4;
                        this.n.setBounds(this.o, (int) f2, this.p, (int) (i4 + f2 + 0.5f));
                        this.n.draw(canvas);
                    } else {
                        f3 = f4;
                    }
                    if (f2 <= scrollY + height) {
                        i2++;
                        f4 = f3;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, pagerAdapter) == null) {
            PagerAdapter pagerAdapter2 = this.f;
            if (pagerAdapter2 != null) {
                pagerAdapter2.unregisterDataSetObserver(this.l);
                this.f.startUpdate((ViewGroup) this);
                for (int i = 0; i < this.c.size(); i++) {
                    d dVar = this.c.get(i);
                    this.f.destroyItem((ViewGroup) this, dVar.b, dVar.a);
                }
                this.f.finishUpdate((ViewGroup) this);
                this.c.clear();
                G();
                this.g = 0;
                scrollTo(0, 0);
            }
            PagerAdapter pagerAdapter3 = this.f;
            this.f = pagerAdapter;
            this.a = 0;
            if (pagerAdapter != null) {
                if (this.l == null) {
                    this.l = new g(this, null);
                }
                this.f.registerDataSetObserver(this.l);
                this.v = false;
                boolean z = this.P;
                this.P = true;
                this.a = this.f.getCount();
                if (this.h >= 0) {
                    this.f.restoreState(this.i, this.j);
                    J(this.h, false, true);
                    this.h = -1;
                    this.i = null;
                    this.j = null;
                } else if (!z) {
                    D();
                } else {
                    requestLayout();
                }
            }
            f fVar = this.U;
            if (fVar != null && pagerAdapter3 != pagerAdapter) {
                fVar.onAdapterChanged(pagerAdapter3, pagerAdapter);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x006e, code lost:
        if (r10 == r11) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void E(int i) {
        int i2;
        d dVar;
        String hexString;
        d dVar2;
        Object obj;
        d dVar3;
        d r;
        d dVar4;
        float paddingLeft;
        d dVar5;
        float paddingRight;
        d dVar6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            int i3 = this.g;
            if (i3 != i) {
                if (i3 < i) {
                    i2 = 130;
                } else {
                    i2 = 33;
                }
                dVar = t(this.g);
                this.g = i;
            } else {
                i2 = 2;
                dVar = null;
            }
            if (this.f == null) {
                M();
            } else if (this.v) {
                M();
            } else if (getWindowToken() != null) {
                this.f.startUpdate((ViewGroup) this);
                int i4 = this.w;
                int max = Math.max(0, this.g - i4);
                int count = this.f.getCount();
                int min = Math.min(count - 1, this.g + i4);
                if (count == this.a) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= this.c.size()) {
                            break;
                        }
                        dVar2 = this.c.get(i5);
                        int i6 = dVar2.b;
                        int i7 = this.g;
                        if (i6 < i7) {
                            i5++;
                        }
                    }
                    dVar2 = null;
                    if (dVar2 == null && count > 0) {
                        dVar2 = e(this.g, i5);
                    }
                    if (dVar2 != null) {
                        int i8 = i5 - 1;
                        if (i8 >= 0) {
                            dVar4 = this.c.get(i8);
                        } else {
                            dVar4 = null;
                        }
                        int clientHeight = getClientHeight();
                        if (clientHeight <= 0) {
                            paddingLeft = 0.0f;
                        } else {
                            paddingLeft = (2.0f - dVar2.d) + (getPaddingLeft() / clientHeight);
                        }
                        float f2 = 0.0f;
                        for (int i9 = this.g - 1; i9 >= 0; i9--) {
                            if (f2 >= paddingLeft && i9 < max) {
                                if (dVar4 == null) {
                                    break;
                                }
                                if (i9 == dVar4.b && !dVar4.c) {
                                    this.c.remove(i8);
                                    this.f.destroyItem((ViewGroup) this, i9, dVar4.a);
                                    i8--;
                                    i5--;
                                    if (i8 >= 0) {
                                        dVar6 = this.c.get(i8);
                                        dVar4 = dVar6;
                                    }
                                    dVar6 = null;
                                    dVar4 = dVar6;
                                }
                            } else if (dVar4 != null && i9 == dVar4.b) {
                                f2 += dVar4.d;
                                i8--;
                                if (i8 >= 0) {
                                    dVar6 = this.c.get(i8);
                                    dVar4 = dVar6;
                                }
                                dVar6 = null;
                                dVar4 = dVar6;
                            } else {
                                f2 += e(i9, i8 + 1).d;
                                i5++;
                                if (i8 >= 0) {
                                    dVar6 = this.c.get(i8);
                                    dVar4 = dVar6;
                                }
                                dVar6 = null;
                                dVar4 = dVar6;
                            }
                        }
                        float f3 = dVar2.d;
                        int i10 = i5 + 1;
                        if (f3 < 2.0f) {
                            if (i10 < this.c.size()) {
                                dVar5 = this.c.get(i10);
                            } else {
                                dVar5 = null;
                            }
                            if (clientHeight <= 0) {
                                paddingRight = 0.0f;
                            } else {
                                paddingRight = (getPaddingRight() / clientHeight) + 2.0f;
                            }
                            int i11 = this.g;
                            while (true) {
                                i11++;
                                if (i11 >= count) {
                                    break;
                                } else if (f3 >= paddingRight && i11 > min) {
                                    if (dVar5 == null) {
                                        break;
                                    } else if (i11 == dVar5.b && !dVar5.c) {
                                        this.c.remove(i10);
                                        this.f.destroyItem((ViewGroup) this, i11, dVar5.a);
                                        if (i10 < this.c.size()) {
                                            dVar5 = this.c.get(i10);
                                        } else {
                                            dVar5 = null;
                                        }
                                    }
                                } else if (dVar5 != null && i11 == dVar5.b) {
                                    f3 += dVar5.d;
                                    i10++;
                                    if (i10 >= this.c.size()) {
                                        dVar5 = null;
                                    } else {
                                        dVar5 = this.c.get(i10);
                                    }
                                } else {
                                    d e2 = e(i11, i10);
                                    i10++;
                                    f3 += e2.d;
                                    if (i10 >= this.c.size()) {
                                        dVar5 = null;
                                    } else {
                                        dVar5 = this.c.get(i10);
                                    }
                                }
                            }
                        }
                        g(dVar2, i5, dVar);
                    }
                    PagerAdapter pagerAdapter = this.f;
                    int i12 = this.g;
                    if (dVar2 != null) {
                        obj = dVar2.a;
                    } else {
                        obj = null;
                    }
                    pagerAdapter.setPrimaryItem((ViewGroup) this, i12, obj);
                    this.f.finishUpdate((ViewGroup) this);
                    int childCount = getChildCount();
                    for (int i13 = 0; i13 < childCount; i13++) {
                        View childAt = getChildAt(i13);
                        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                        layoutParams.f = i13;
                        if (!layoutParams.a && layoutParams.c == 0.0f && (r = r(childAt)) != null) {
                            layoutParams.c = r.d;
                            layoutParams.e = r.b;
                        }
                    }
                    M();
                    if (hasFocus()) {
                        View findFocus = findFocus();
                        if (findFocus != null) {
                            dVar3 = q(findFocus);
                        } else {
                            dVar3 = null;
                        }
                        if (dVar3 == null || dVar3.b != this.g) {
                            for (int i14 = 0; i14 < getChildCount(); i14++) {
                                View childAt2 = getChildAt(i14);
                                d r2 = r(childAt2);
                                if (r2 != null && r2.b == this.g && childAt2.requestFocus(i2)) {
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
                throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.a + ", found: " + count + " Pager id: " + hexString + " Pager class: " + VerticalViewPager.class + " Problematic adapter: " + this.f.getClass());
            }
        }
    }

    public final void F(int i, int i2, int i3, int i4) {
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i, i2, i3, i4) == null) {
            if (i2 > 0 && !this.c.isEmpty()) {
                int scrollY = (int) ((getScrollY() / (((i2 - getPaddingTop()) - getPaddingBottom()) + i4)) * (((i - getPaddingTop()) - getPaddingBottom()) + i3));
                scrollTo(getScrollX(), scrollY);
                if (!this.k.isFinished()) {
                    this.k.startScroll(0, scrollY, 0, (int) (t(this.g).e * i), this.k.getDuration() - this.k.timePassed());
                    return;
                }
                return;
            }
            d t = t(this.g);
            if (t != null) {
                f2 = Math.min(t.e, this.r);
            } else {
                f2 = 0.0f;
            }
            int paddingTop = (int) (f2 * ((i - getPaddingTop()) - getPaddingBottom()));
            if (paddingTop != getScrollY()) {
                i(false);
                scrollTo(getScrollX(), paddingTop);
            }
        }
    }

    public void K(int i, boolean z, boolean z2, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            PagerAdapter pagerAdapter = this.f;
            boolean z3 = false;
            if (pagerAdapter != null && pagerAdapter.getCount() > 0) {
                if (!z2 && this.g == i && this.c.size() != 0 && !this.b) {
                    setScrollingCacheEnabled(false);
                    return;
                }
                if (this.b) {
                    this.P = true;
                }
                if (i < 0) {
                    i = 0;
                } else if (i >= this.f.getCount()) {
                    i = this.f.getCount() - 1;
                }
                int i3 = this.w;
                int i4 = this.g;
                if (i > i4 + i3 || i < i4 - i3) {
                    for (int i5 = 0; i5 < this.c.size(); i5++) {
                        this.c.get(i5).c = true;
                    }
                }
                if (this.g != i) {
                    z3 = true;
                }
                if (this.P) {
                    this.g = i;
                    if (z3 && (onPageChangeListener2 = this.S) != null) {
                        onPageChangeListener2.onPageSelected(i);
                    }
                    if (z3 && (onPageChangeListener = this.f1086T) != null) {
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
    }

    public final void I(int i, boolean z, int i2, boolean z2) {
        int i3;
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        ViewPager.OnPageChangeListener onPageChangeListener3;
        ViewPager.OnPageChangeListener onPageChangeListener4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            d t = t(i);
            if (t != null) {
                i3 = (int) (getClientHeight() * Math.max(this.q, Math.min(t.e, this.r)));
            } else {
                i3 = 0;
            }
            if (z) {
                L(0, i3, i2);
                if (z2 && (onPageChangeListener4 = this.S) != null) {
                    onPageChangeListener4.onPageSelected(i);
                }
                if (z2 && (onPageChangeListener3 = this.f1086T) != null) {
                    onPageChangeListener3.onPageSelected(i);
                    return;
                }
                return;
            }
            if (z2 && (onPageChangeListener2 = this.S) != null) {
                onPageChangeListener2.onPageSelected(i);
            }
            if (z2 && (onPageChangeListener = this.f1086T) != null) {
                onPageChangeListener.onPageSelected(i);
            }
            i(false);
            scrollTo(0, i3);
            A(i3);
        }
    }

    public final int k(int i, float f2, int i2, int i3) {
        InterceptResult invokeCommon;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048613, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (Math.abs(i3) > this.K && Math.abs(i2) > this.I) {
                if (i2 <= 0) {
                    i++;
                }
            } else {
                if (i >= this.g) {
                    f3 = 0.4f;
                } else {
                    f3 = 0.6f;
                }
                i = (int) (i + f2 + f3);
            }
            if (this.c.size() > 0) {
                ArrayList<d> arrayList = this.c;
                return Math.max(this.c.get(0).b, Math.min(i, arrayList.get(arrayList.size() - 1).b));
            }
            return i;
        }
        return invokeCommon.intValue;
    }

    public void J(int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            K(i, z, z2, 0);
        }
    }

    public void L(int i, int i2, int i3) {
        int abs;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048587, this, i, i2, i3) == null) {
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
                abs = (int) (((Math.abs(i4) / ((f2 * this.f.getPageWidth(this.g)) + this.m)) + 1.0f) * 100.0f);
            }
            this.k.startScroll(scrollX, scrollY, i4, i5, Math.min(abs, 600));
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        d r;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048589, this, arrayList, i, i2) == null) {
            int size = arrayList.size();
            int descendantFocusability = getDescendantFocusability();
            if (descendantFocusability != 393216) {
                for (int i3 = 0; i3 < getChildCount(); i3++) {
                    View childAt = getChildAt(i3);
                    if (childAt.getVisibility() == 0 && (r = r(childAt)) != null && r.b == this.g) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
            if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
                return;
            }
            if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
                arrayList.add(this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        d r;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, arrayList) == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() == 0 && (r = r(childAt)) != null && r.b == this.g) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, parcelable) == null) {
            if (!(parcelable instanceof SavedState)) {
                super.onRestoreInstanceState(parcelable);
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            PagerAdapter pagerAdapter = this.f;
            if (pagerAdapter != null) {
                pagerAdapter.restoreState(savedState.adapterState, savedState.loader);
                J(savedState.position, false, true);
                return;
            }
            this.h = savedState.position;
            this.i = savedState.adapterState;
            this.j = savedState.loader;
        }
    }

    public d r(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, view2)) == null) {
            for (int i = 0; i < this.c.size(); i++) {
                d dVar = this.c.get(i);
                if (this.f.isViewFromObject(view2, dVar.a)) {
                    return dVar;
                }
            }
            return null;
        }
        return (d) invokeL.objValue;
    }

    public void setChildrenDrawingOrderEnabledCompat(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            if (this.W == null) {
                try {
                    this.W = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
                } catch (NoSuchMethodException e2) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e2);
                }
            }
            Method method = this.W;
            if (method != null) {
                try {
                    method.invoke(this, Boolean.valueOf(z));
                } catch (Exception e3) {
                    Log.e("ViewPager", "Error changing children drawing order", e3);
                }
            }
        }
    }

    public void setOffscreenPageLimit(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i) == null) {
            if (i < 1) {
                Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
                i = 1;
            }
            if (i != this.w) {
                this.w = i;
                D();
            }
        }
    }

    public boolean v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048651, this, i)) == null) {
            if (this.f == null) {
                return false;
            }
            int clientHeight = getClientHeight();
            int scrollY = getScrollY();
            if (i < 0) {
                if (scrollY <= ((int) (clientHeight * this.q))) {
                    return false;
                }
                return true;
            } else if (i <= 0 || scrollY >= ((int) (clientHeight * this.r))) {
                return false;
            } else {
                return true;
            }
        }
        return invokeI.booleanValue;
    }

    public final void y(MotionEvent motionEvent) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, motionEvent) == null) {
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.G) {
                if (actionIndex == 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                this.D = MotionEventCompat.getY(motionEvent, i);
                this.G = MotionEventCompat.getPointerId(motionEvent, i);
                VelocityTracker velocityTracker = this.H;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048591, this, view2, i, layoutParams) == null) {
            if (!checkLayoutParams(layoutParams)) {
                layoutParams = generateLayoutParams(layoutParams);
            }
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            boolean z = layoutParams2.a | false;
            layoutParams2.a = z;
            if (this.t) {
                if (layoutParams2 != null && z) {
                    throw new IllegalStateException("Cannot add pager decor view during layout");
                }
                if (layoutParams2 != null) {
                    layoutParams2.d = true;
                }
                addViewInLayout(view2, i, layoutParams);
                return;
            }
            super.addView(view2, i, layoutParams);
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (!this.k.isFinished() && this.k.computeScrollOffset()) {
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.k.getCurrX();
                int currY = this.k.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (!A(currY)) {
                        this.k.abortAnimation();
                        scrollTo(currX, 0);
                    }
                }
                ViewCompat.postInvalidateOnAnimation(this);
                return;
            }
            i(true);
        }
    }

    public d e(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048598, this, i, i2)) == null) {
            d dVar = new d();
            dVar.b = i;
            dVar.a = this.f.instantiateItem((ViewGroup) this, i);
            dVar.d = this.f.getPageWidth(i);
            if (i2 >= 0 && i2 < this.c.size()) {
                this.c.add(i2, dVar);
            } else {
                this.c.add(dVar);
            }
            return dVar;
        }
        return (d) invokeII.objValue;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        InterceptResult invokeIL;
        int i2;
        int i3;
        d r;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048624, this, i, rect)) == null) {
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
                if (childAt.getVisibility() == 0 && (r = r(childAt)) != null && r.b == this.g && childAt.requestFocus(i, rect)) {
                    return true;
                }
                i2 += i3;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public void setPageTransformer(boolean z, ViewPager.PageTransformer pageTransformer) {
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048646, this, z, pageTransformer) == null) && Build.VERSION.SDK_INT >= 11) {
            int i = 1;
            if (pageTransformer != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.V != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z2 != z3) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.V = pageTransformer;
            setChildrenDrawingOrderEnabledCompat(z2);
            if (z2) {
                if (z) {
                    i = 2;
                }
                this.a0 = i;
            } else {
                this.a0 = 0;
            }
            if (z4) {
                D();
            }
        }
    }

    public final boolean w(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048653, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if ((f2 < this.A && f3 > 0.0f) || (f2 > getHeight() - this.A && f3 < 0.0f)) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(int i) {
        InterceptResult invokeI;
        boolean z;
        View findNextFocus;
        boolean requestFocus;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            View findFocus = findFocus();
            boolean z2 = false;
            if (findFocus != this) {
                if (findFocus != null) {
                    ViewParent parent = findFocus.getParent();
                    while (true) {
                        if (parent instanceof ViewGroup) {
                            if (parent == this) {
                                z = true;
                                break;
                            }
                            parent = parent.getParent();
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(findFocus.getClass().getSimpleName());
                        for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                            sb.append(" => ");
                            sb.append(parent2.getClass().getSimpleName());
                        }
                        Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                    }
                }
                findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
                if (findNextFocus == null && findNextFocus != findFocus) {
                    if (i == 33) {
                        int i2 = p(this.e, findNextFocus).top;
                        int i3 = p(this.e, findFocus).top;
                        if (findFocus != null && i2 >= i3) {
                            requestFocus = B();
                        } else {
                            requestFocus = findNextFocus.requestFocus();
                        }
                    } else if (i == 130) {
                        int i4 = p(this.e, findNextFocus).bottom;
                        int i5 = p(this.e, findFocus).bottom;
                        if (findFocus != null && i4 <= i5) {
                            requestFocus = z();
                        } else {
                            requestFocus = findNextFocus.requestFocus();
                        }
                    }
                    z2 = requestFocus;
                } else if (i == 33 && i != 1) {
                    if (i == 130 || i == 2) {
                        z2 = z();
                    }
                } else {
                    z2 = B();
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
            if (i == 33) {
            }
            z2 = B();
            if (z2) {
            }
            return z2;
        }
        return invokeI.booleanValue;
    }

    public final void g(d dVar, int i, d dVar2) {
        float f2;
        float f3;
        float f4;
        int i2;
        int i3;
        d dVar3;
        d dVar4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048600, this, dVar, i, dVar2) == null) {
            int count = this.f.getCount();
            int clientHeight = getClientHeight();
            if (clientHeight > 0) {
                f2 = this.m / clientHeight;
            } else {
                f2 = 0.0f;
            }
            if (dVar2 != null) {
                int i4 = dVar2.b;
                int i5 = dVar.b;
                if (i4 < i5) {
                    int i6 = 0;
                    float f5 = dVar2.e + dVar2.d + f2;
                    while (true) {
                        i4++;
                        if (i4 > dVar.b || i6 >= this.c.size()) {
                            break;
                        }
                        d dVar5 = this.c.get(i6);
                        while (true) {
                            dVar4 = dVar5;
                            if (i4 <= dVar4.b || i6 >= this.c.size() - 1) {
                                break;
                            }
                            i6++;
                            dVar5 = this.c.get(i6);
                        }
                        while (i4 < dVar4.b) {
                            f5 += this.f.getPageWidth(i4) + f2;
                            i4++;
                        }
                        dVar4.e = f5;
                        f5 += dVar4.d + f2;
                    }
                } else if (i4 > i5) {
                    int size = this.c.size() - 1;
                    float f6 = dVar2.e;
                    while (true) {
                        i4--;
                        if (i4 < dVar.b || size < 0) {
                            break;
                        }
                        d dVar6 = this.c.get(size);
                        while (true) {
                            dVar3 = dVar6;
                            if (i4 >= dVar3.b || size <= 0) {
                                break;
                            }
                            size--;
                            dVar6 = this.c.get(size);
                        }
                        while (i4 > dVar3.b) {
                            f6 -= this.f.getPageWidth(i4) + f2;
                            i4--;
                        }
                        f6 -= dVar3.d + f2;
                        dVar3.e = f6;
                    }
                }
            }
            int size2 = this.c.size();
            float f7 = dVar.e;
            int i7 = dVar.b;
            int i8 = i7 - 1;
            if (i7 == 0) {
                f3 = f7;
            } else {
                f3 = -3.4028235E38f;
            }
            this.q = f3;
            int i9 = count - 1;
            if (dVar.b == i9) {
                f4 = (dVar.e + dVar.d) - 1.0f;
            } else {
                f4 = Float.MAX_VALUE;
            }
            this.r = f4;
            int i10 = i - 1;
            while (i10 >= 0) {
                d dVar7 = this.c.get(i10);
                while (true) {
                    i3 = dVar7.b;
                    if (i8 <= i3) {
                        break;
                    }
                    f7 -= this.f.getPageWidth(i8) + f2;
                    i8--;
                }
                f7 -= dVar7.d + f2;
                dVar7.e = f7;
                if (i3 == 0) {
                    this.q = f7;
                }
                i10--;
                i8--;
            }
            float f8 = dVar.e + dVar.d + f2;
            int i11 = dVar.b + 1;
            int i12 = i + 1;
            while (i12 < size2) {
                d dVar8 = this.c.get(i12);
                while (true) {
                    i2 = dVar8.b;
                    if (i11 >= i2) {
                        break;
                    }
                    f8 += this.f.getPageWidth(i11) + f2;
                    i11++;
                }
                if (i2 == i9) {
                    this.r = (dVar8.d + f8) - 1.0f;
                }
                dVar8.e = f8;
                f8 += dVar8.d + f2;
                i12++;
                i11++;
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, layoutParams)) == null) {
            return generateDefaultLayoutParams();
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, drawable) == null) {
            this.n = drawable;
            if (drawable != null) {
                refreshDrawableState();
            }
            if (drawable == null) {
                z = true;
            } else {
                z = false;
            }
            setWillNotDraw(z);
            invalidate();
        }
    }

    public boolean h(View view2, boolean z, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048609, this, new Object[]{view2, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int scrollX = view2.getScrollX();
                int scrollY = view2.getScrollY();
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = viewGroup.getChildAt(childCount);
                    int i5 = i3 + scrollY;
                    if (i5 >= childAt.getTop() && i5 < childAt.getBottom() && (i4 = i2 + scrollX) >= childAt.getLeft() && i4 < childAt.getRight() && h(childAt, true, i, i4 - childAt.getLeft(), i5 - childAt.getTop())) {
                        return true;
                    }
                }
            }
            if (z && ViewCompat.canScrollVertically(view2, -i)) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void j() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            int count = this.f.getCount();
            this.a = count;
            if (this.c.size() < (this.w * 2) + 1 && this.c.size() < count) {
                z = true;
            } else {
                z = false;
            }
            int i = this.g;
            int i2 = 0;
            boolean z2 = false;
            while (i2 < this.c.size()) {
                d dVar = this.c.get(i2);
                int itemPosition = this.f.getItemPosition(dVar.a);
                if (itemPosition != -1) {
                    if (itemPosition == -2) {
                        this.c.remove(i2);
                        i2--;
                        if (!z2) {
                            this.f.startUpdate((ViewGroup) this);
                            z2 = true;
                        }
                        this.f.destroyItem((ViewGroup) this, dVar.b, dVar.a);
                        int i3 = this.g;
                        if (i3 == dVar.b) {
                            i = Math.max(0, Math.min(i3, count - 1));
                        }
                    } else {
                        int i4 = dVar.b;
                        if (i4 != itemPosition) {
                            if (i4 == this.g) {
                                i = itemPosition;
                            }
                            dVar.b = itemPosition;
                        }
                    }
                    z = true;
                }
                i2++;
            }
            if (z2) {
                this.f.finishUpdate((ViewGroup) this);
            }
            Collections.sort(this.c, i0);
            if (z) {
                int childCount = getChildCount();
                for (int i5 = 0; i5 < childCount; i5++) {
                    LayoutParams layoutParams = (LayoutParams) getChildAt(i5).getLayoutParams();
                    if (!layoutParams.a) {
                        layoutParams.c = 0.0f;
                    }
                }
                J(i, false, true);
                requestLayout();
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, motionEvent)) == null) {
            if (!this.c0) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            if (action != 3 && action != 1) {
                if (action != 0) {
                    if (this.x) {
                        return true;
                    }
                    if (this.y) {
                        return false;
                    }
                }
                if (action != 0) {
                    if (action != 2) {
                        if (action == 6) {
                            y(motionEvent);
                        }
                    } else {
                        int i = this.G;
                        if (i != -1) {
                            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
                            float y = MotionEventCompat.getY(motionEvent, findPointerIndex);
                            float f4 = y - this.D;
                            float abs = Math.abs(f4);
                            float x = MotionEventCompat.getX(motionEvent, findPointerIndex);
                            float abs2 = Math.abs(x - this.E);
                            int i2 = (f4 > 0.0f ? 1 : (f4 == 0.0f ? 0 : -1));
                            if (i2 != 0 && !w(this.D, f4) && h(this, false, (int) f4, (int) x, (int) y)) {
                                this.C = x;
                                this.D = y;
                                this.y = true;
                                return false;
                            }
                            if (this.d0) {
                                f2 = 0.5f;
                            } else {
                                f2 = 3.0f;
                            }
                            if (abs > this.B && abs * f2 > abs2) {
                                this.x = true;
                                H(true);
                                setScrollState(1);
                                float f5 = this.F;
                                float f6 = this.B;
                                if (i2 > 0) {
                                    f3 = f5 + f6;
                                } else {
                                    f3 = f5 - f6;
                                }
                                this.D = f3;
                                this.C = x;
                                setScrollingCacheEnabled(true);
                            } else if (abs2 > this.B) {
                                this.y = true;
                            }
                            if (this.x && C(y)) {
                                ViewCompat.postInvalidateOnAnimation(this);
                            }
                        }
                    }
                } else {
                    float x2 = motionEvent.getX();
                    this.E = x2;
                    this.C = x2;
                    float y2 = motionEvent.getY();
                    this.F = y2;
                    this.D = y2;
                    this.G = MotionEventCompat.getPointerId(motionEvent, 0);
                    this.y = false;
                    this.k.computeScrollOffset();
                    if (this.f0 == 2 && Math.abs(this.k.getFinalY() - this.k.getCurrY()) > this.L) {
                        this.k.abortAnimation();
                        this.v = false;
                        D();
                        this.x = true;
                        H(true);
                        setScrollState(1);
                    } else {
                        i(false);
                        this.x = false;
                    }
                }
                if (this.H == null) {
                    this.H = VelocityTracker.obtain();
                }
                this.H.addMovement(motionEvent);
                return this.x;
            }
            this.x = false;
            this.y = false;
            this.G = -1;
            VelocityTracker velocityTracker = this.H;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.H = null;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        PagerAdapter pagerAdapter;
        boolean onRelease;
        boolean onRelease2;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, motionEvent)) == null) {
            boolean z = false;
            if (!this.c0) {
                return false;
            }
            if (this.M) {
                return true;
            }
            this.g0.d(motionEvent);
            if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.f) == null || pagerAdapter.getCount() == 0) {
                return false;
            }
            if (this.H == null) {
                this.H = VelocityTracker.obtain();
            }
            this.H.addMovement(motionEvent);
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            if (action != 5) {
                                if (action == 6) {
                                    y(motionEvent);
                                    this.D = MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.G));
                                }
                            } else {
                                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                                this.D = MotionEventCompat.getY(motionEvent, actionIndex);
                                this.G = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                            }
                        } else if (this.x) {
                            I(this.g, true, 0, false);
                            this.G = -1;
                            n();
                            onRelease = this.N.onRelease();
                            onRelease2 = this.O.onRelease();
                            z = onRelease | onRelease2;
                        }
                    } else {
                        if (!this.x) {
                            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.G);
                            float y = MotionEventCompat.getY(motionEvent, findPointerIndex);
                            float abs = Math.abs(y - this.D);
                            float x = MotionEventCompat.getX(motionEvent, findPointerIndex);
                            float abs2 = Math.abs(x - this.C);
                            if (abs > this.B && abs > abs2) {
                                this.x = true;
                                H(true);
                                float f3 = this.F;
                                if (y - f3 > 0.0f) {
                                    f2 = f3 + this.B;
                                } else {
                                    f2 = f3 - this.B;
                                }
                                this.D = f2;
                                this.C = x;
                                setScrollState(1);
                                setScrollingCacheEnabled(true);
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                        if (this.x) {
                            z = false | C(MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.G)));
                        }
                    }
                } else if (this.x) {
                    VelocityTracker velocityTracker = this.H;
                    velocityTracker.computeCurrentVelocity(1000, this.J);
                    int yVelocity = (int) VelocityTrackerCompat.getYVelocity(velocityTracker, this.G);
                    this.v = true;
                    int clientHeight = getClientHeight();
                    int scrollY = getScrollY();
                    d s = s();
                    K(k(s.b, ((scrollY / clientHeight) - s.e) / s.d, yVelocity, (int) (MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, this.G)) - this.F)), true, true, yVelocity);
                    this.G = -1;
                    n();
                    onRelease = this.N.onRelease();
                    onRelease2 = this.O.onRelease();
                    z = onRelease | onRelease2;
                }
            } else {
                this.k.abortAnimation();
                this.v = false;
                D();
                float x2 = motionEvent.getX();
                this.E = x2;
                this.C = x2;
                float y2 = motionEvent.getY();
                this.F = y2;
                this.D = y2;
                this.G = MotionEventCompat.getPointerId(motionEvent, 0);
            }
            if (z) {
                ViewCompat.postInvalidateOnAnimation(this);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0092  */
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
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
                    if (layoutParams.a) {
                        int i11 = layoutParams.b;
                        int i12 = i11 & 7;
                        int i13 = i11 & 112;
                        if (i12 != 1) {
                            if (i12 != 3) {
                                if (i12 != 5) {
                                    i5 = paddingLeft;
                                } else {
                                    max = (i7 - paddingRight) - childAt.getMeasuredWidth();
                                    paddingRight += childAt.getMeasuredWidth();
                                }
                            } else {
                                i5 = childAt.getMeasuredWidth() + paddingLeft;
                            }
                            if (i13 == 16) {
                                if (i13 != 48) {
                                    if (i13 != 80) {
                                        i6 = paddingTop;
                                    } else {
                                        max2 = (i8 - paddingBottom) - childAt.getMeasuredHeight();
                                        paddingBottom += childAt.getMeasuredHeight();
                                    }
                                } else {
                                    i6 = childAt.getMeasuredHeight() + paddingTop;
                                }
                                int i14 = paddingTop + scrollY;
                                childAt.layout(paddingLeft, i14, childAt.getMeasuredWidth() + paddingLeft, i14 + childAt.getMeasuredHeight());
                                i9++;
                                paddingTop = i6;
                                paddingLeft = i5;
                            } else {
                                max2 = Math.max((i8 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            }
                            int i15 = max2;
                            i6 = paddingTop;
                            paddingTop = i15;
                            int i142 = paddingTop + scrollY;
                            childAt.layout(paddingLeft, i142, childAt.getMeasuredWidth() + paddingLeft, i142 + childAt.getMeasuredHeight());
                            i9++;
                            paddingTop = i6;
                            paddingLeft = i5;
                        } else {
                            max = Math.max((i7 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                        }
                        int i16 = max;
                        i5 = paddingLeft;
                        paddingLeft = i16;
                        if (i13 == 16) {
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
                    if (!layoutParams2.a && (r = r(childAt2)) != null) {
                        float f2 = i17;
                        int i19 = ((int) (r.e * f2)) + paddingTop;
                        if (layoutParams2.d) {
                            layoutParams2.d = false;
                            childAt2.measure(View.MeasureSpec.makeMeasureSpec((i7 - paddingLeft) - paddingRight, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (f2 * layoutParams2.c), 1073741824));
                        }
                        childAt2.layout(paddingLeft, i19, childAt2.getMeasuredWidth() + paddingLeft, childAt2.getMeasuredHeight() + i19);
                    }
                }
            }
            this.o = paddingLeft;
            this.p = i7 - paddingRight;
            this.R = i9;
            if (this.P) {
                z2 = false;
                I(this.g, false, 0, false);
            } else {
                z2 = false;
            }
            this.P = z2;
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
    public void onMeasure(int i, int i2) {
        LayoutParams layoutParams;
        float f2;
        LayoutParams layoutParams2;
        boolean z;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048623, this, i, i2) == null) {
            setMeasuredDimension(ViewGroup.getDefaultSize(0, i), ViewGroup.getDefaultSize(0, i2));
            int measuredHeight = getMeasuredHeight();
            this.A = Math.min(measuredHeight / 10, this.z);
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int paddingTop = (measuredHeight - getPaddingTop()) - getPaddingBottom();
            int childCount = getChildCount();
            int i6 = 0;
            while (true) {
                boolean z2 = true;
                int i7 = 1073741824;
                if (i6 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.a) {
                    int i8 = layoutParams2.b;
                    int i9 = i8 & 7;
                    int i10 = i8 & 112;
                    if (i10 != 48 && i10 != 80) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (i9 != 3 && i9 != 5) {
                        z2 = false;
                    }
                    int i11 = Integer.MIN_VALUE;
                    if (z) {
                        i11 = 1073741824;
                    } else if (z2) {
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
                        if (i5 == -2) {
                            if (i5 == -1) {
                                i5 = paddingTop;
                            }
                        } else {
                            i5 = paddingTop;
                            i7 = i3;
                        }
                        childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i11), View.MeasureSpec.makeMeasureSpec(i5, i7));
                        if (!z) {
                            paddingTop -= childAt.getMeasuredHeight();
                        } else if (z2) {
                            measuredWidth -= childAt.getMeasuredWidth();
                        }
                    }
                    i3 = Integer.MIN_VALUE;
                    i4 = ((ViewGroup.LayoutParams) layoutParams2).width;
                    if (i4 == -2) {
                    }
                    i5 = ((ViewGroup.LayoutParams) layoutParams2).height;
                    if (i5 == -2) {
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i11), View.MeasureSpec.makeMeasureSpec(i5, i7));
                    if (!z) {
                    }
                }
                i6++;
            }
            this.s = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
            View.MeasureSpec.makeMeasureSpec(paddingTop, 1073741824);
            this.t = true;
            D();
            this.t = false;
            int childCount2 = getChildCount();
            for (int i12 = 0; i12 < childCount2; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.a)) {
                    float f3 = paddingTop;
                    if (layoutParams != null) {
                        f2 = layoutParams.c;
                    } else {
                        f2 = 0.0f;
                    }
                    childAt2.measure(this.s, View.MeasureSpec.makeMeasureSpec((int) (f3 * f2), 1073741824));
                }
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048627, this, i, i2, i3, i4) == null) {
            super.onSizeChanged(i, i2, i3, i4);
            if (i2 != i4) {
                int i5 = this.m;
                F(i2, i4, i5, i5);
            }
        }
    }

    public final d s() {
        InterceptResult invokeV;
        float f2;
        float f3;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            int clientHeight = getClientHeight();
            float f4 = 0.0f;
            if (clientHeight > 0) {
                f2 = getScrollY() / clientHeight;
            } else {
                f2 = 0.0f;
            }
            if (clientHeight > 0) {
                f3 = this.m / clientHeight;
            } else {
                f3 = 0.0f;
            }
            d dVar = null;
            float f5 = 0.0f;
            int i2 = -1;
            int i3 = 0;
            boolean z = true;
            while (i3 < this.c.size()) {
                d dVar2 = this.c.get(i3);
                if (!z && dVar2.b != (i = i2 + 1)) {
                    dVar2 = this.d;
                    dVar2.e = f4 + f5 + f3;
                    dVar2.b = i;
                    dVar2.d = this.f.getPageWidth(i);
                    i3--;
                }
                f4 = dVar2.e;
                float f6 = dVar2.d + f4 + f3;
                if (!z && f2 < f4) {
                    return dVar;
                }
                if (f2 >= f6 && i3 != this.c.size() - 1) {
                    i2 = dVar2.b;
                    f5 = dVar2.d;
                    i3++;
                    dVar = dVar2;
                    z = false;
                } else {
                    return dVar2;
                }
            }
            return dVar;
        }
        return (d) invokeV.objValue;
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            setWillNotDraw(false);
            setDescendantFocusability(262144);
            setFocusable(true);
            Context context = getContext();
            this.k = new Scroller(context, j0);
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            float f2 = context.getResources().getDisplayMetrics().density;
            this.B = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
            this.I = (int) (400.0f * f2);
            this.J = viewConfiguration.getScaledMaximumFlingVelocity();
            this.N = new EdgeEffectCompat(context);
            this.O = new EdgeEffectCompat(context);
            this.K = (int) (25.0f * f2);
            this.L = (int) (2.0f * f2);
            this.z = (int) (f2 * 16.0f);
            ViewCompat.setAccessibilityDelegate(this, new e(this));
            if (ViewCompat.getImportantForAccessibility(this) == 0) {
                ViewCompat.setImportantForAccessibility(this, 1);
            }
            this.g0 = new x26(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void x(int i, float f2, int i2) {
        int max;
        int i3;
        int top;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048654, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            if (this.R > 0) {
                int scrollY = getScrollY();
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int childCount = getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = getChildAt(i4);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams.a) {
                        int i5 = layoutParams.b & 112;
                        if (i5 != 16) {
                            if (i5 != 48) {
                                if (i5 != 80) {
                                    i3 = paddingTop;
                                } else {
                                    max = (height - paddingBottom) - childAt.getMeasuredHeight();
                                    paddingBottom += childAt.getMeasuredHeight();
                                }
                            } else {
                                i3 = childAt.getHeight() + paddingTop;
                            }
                            top = (paddingTop + scrollY) - childAt.getTop();
                            if (top != 0) {
                                childAt.offsetTopAndBottom(top);
                            }
                            paddingTop = i3;
                        } else {
                            max = Math.max((height - childAt.getMeasuredHeight()) / 2, paddingTop);
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
            ViewPager.OnPageChangeListener onPageChangeListener = this.S;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i, f2, i2);
            }
            ViewPager.OnPageChangeListener onPageChangeListener2 = this.f1086T;
            if (onPageChangeListener2 != null) {
                onPageChangeListener2.onPageScrolled(i, f2, i2);
            }
            if (this.V != null) {
                int scrollY2 = getScrollY();
                int childCount2 = getChildCount();
                for (int i7 = 0; i7 < childCount2; i7++) {
                    View childAt2 = getChildAt(i7);
                    if (!((LayoutParams) childAt2.getLayoutParams()).a) {
                        this.V.transformPage(childAt2, (childAt2.getTop() - scrollY2) / getClientHeight());
                    }
                }
            }
            this.Q = true;
        }
    }
}
