package com.baidu.tieba.browser.webview.scroll;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ij6;
import com.baidu.tieba.pj6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class NestedScrollingWebView extends WebView implements NestedScrollingChild3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] a;
    public final int[] b;
    public int c;
    public final NestedScrollingChildHelper d;
    public boolean e;
    public VelocityTracker f;
    public int g;
    public int h;
    public int i;
    public OverScroller j;
    public int k;
    public int l;
    public int m;
    public long n;
    public ij6 o;
    public pj6 p;
    public boolean q;
    public Class<?> r;

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NestedScrollingWebView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Nullable
    public final ViewParent e(@NonNull View view2) {
        InterceptResult invokeL;
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, view2)) == null) {
            if (this.r == null || (parent = view2.getParent()) == null) {
                return null;
            }
            if (j(parent.getClass(), this.r)) {
                return parent;
            }
            if (parent instanceof View) {
                return e((View) parent);
            }
            return parent;
        }
        return (ViewParent) invokeL.objValue;
    }

    public final void k(MotionEvent motionEvent) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, motionEvent) == null) {
            int action = (motionEvent.getAction() & 65280) >> 8;
            if (motionEvent.getPointerId(action) == this.h) {
                if (action == 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                this.c = (int) motionEvent.getY(i);
                this.h = motionEvent.getPointerId(i);
                VelocityTracker velocityTracker = this.f;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NestedScrollingWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842885);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void m(View view2, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, view2, motionEvent) == null) && motionEvent.getAction() == 0) {
            if (this.n <= 0) {
                this.n = System.currentTimeMillis();
                return;
            }
            int abs = Math.abs(((int) motionEvent.getRawY()) - this.c);
            if (System.currentTimeMillis() - this.n < 250 && abs < 30) {
                this.n = 0L;
                this.o.j(view2, motionEvent);
                return;
            }
            this.n = System.currentTimeMillis();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NestedScrollingWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = new int[2];
        this.b = new int[2];
        this.e = false;
        this.h = -1;
        this.n = 0L;
        this.q = false;
        setOverScrollMode(2);
        h();
        this.d = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }

    private int getScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return computeVerticalScrollRange();
        }
        return invokeV.intValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.j.abortAnimation();
            stopNestedScroll(1);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e = false;
            n();
            stopNestedScroll();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            VelocityTracker velocityTracker = this.f;
            if (velocityTracker == null) {
                this.f = VelocityTracker.obtain();
            } else {
                velocityTracker.clear();
            }
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return hasNestedScrollingParent(0);
        }
        return invokeV.booleanValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.f == null) {
            this.f = VelocityTracker.obtain();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.d.isNestedScrollingEnabled();
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        VelocityTracker velocityTracker;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (velocityTracker = this.f) != null) {
            velocityTracker.recycle();
            this.f = null;
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.p = null;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            stopNestedScroll(0);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.j.isFinished()) {
            return;
        }
        this.j.computeScrollOffset();
        int currY = this.j.getCurrY();
        int i = currY - this.m;
        this.m = currY;
        int[] iArr = this.a;
        iArr[1] = 0;
        dispatchNestedPreScroll(0, i, iArr, null, 1);
        int i2 = i - this.a[1];
        if (i2 != 0) {
            int scrollY = getScrollY();
            l(0, i2, getScrollX(), scrollY, 0, getScrollRange(), 0, 0, false);
            int scrollY2 = i2 - (getScrollY() - scrollY);
            int[] iArr2 = this.a;
            iArr2[1] = 0;
            dispatchNestedScroll(0, 0, 0, scrollY2, this.b, 1, iArr2);
            i2 = scrollY2 - this.a[1];
        }
        if (i2 != 0) {
            c();
        }
        if (!this.j.isFinished()) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)})) == null) {
            return this.d.dispatchNestedFling(f, f2, false);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            return this.d.dispatchNestedPreFling(f, f2);
        }
        return invokeCommon.booleanValue;
    }

    public final boolean j(Class<?> cls, Class<?> cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, cls, cls2)) == null) {
            if (cls != null && cls2 != null) {
                if (cls == cls2) {
                    return true;
                }
                return cls2.isAssignableFrom(cls);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048614, this, i, i2)) == null) {
            return this.d.startNestedScroll(i, i2);
        }
        return invokeII.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), iArr, iArr2})) == null) {
            return dispatchNestedPreScroll(i, i2, iArr, iArr2, 0);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            super.onOverScrolled(i, i2, z, z2);
            ViewParent e = e(this);
            if (e != null) {
                e.requestDisallowInterceptTouchEvent(false);
            }
        }
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), iArr, iArr2, Integer.valueOf(i3)})) == null) {
            return this.d.dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr})) == null) {
            return dispatchNestedScroll(i, i2, i3, i4, iArr, 0);
        }
        return invokeCommon.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public void dispatchNestedScroll(int i, int i2, int i3, int i4, @Nullable int[] iArr, int i5, @NonNull int[] iArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr, Integer.valueOf(i5), iArr2}) == null) {
            this.d.dispatchNestedScroll(i, i2, i3, i4, iArr, i5, iArr2);
        }
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr, Integer.valueOf(i5)})) == null) {
            return this.d.dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
        }
        return invokeCommon.booleanValue;
    }

    public final void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.j.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, getHeight() / 2);
            p(true);
        }
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            return this.d.hasNestedScrollingParent(i);
        }
        return invokeI.booleanValue;
    }

    public final void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            if (z) {
                startNestedScroll(2, 1);
            } else {
                stopNestedScroll(1);
            }
            this.m = getScrollY();
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            if (z) {
                n();
            }
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setInterceptTargetParentClz(Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, cls) == null) {
            this.r = cls;
        }
    }

    public void setNeedDisAllowParentInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.q = z;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.d.setNestedScrollingEnabled(z);
        }
    }

    public void setOnDoubleClickListener(ij6 ij6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, ij6Var) == null) {
            this.o = ij6Var;
        }
    }

    public void setOnScrollChangeListener(pj6 pj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, pj6Var) == null) {
            this.p = pj6Var;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i)) == null) {
            return startNestedScroll(i, 0);
        }
        return invokeI.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            this.d.stopNestedScroll(i);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.j = new OverScroller(getContext());
            ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
            this.g = viewConfiguration.getScaledTouchSlop();
            this.k = viewConfiguration.getScaledMinimumFlingVelocity();
            this.l = viewConfiguration.getScaledMaximumFlingVelocity();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0087 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean l(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        InterceptResult invokeCommon;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i9;
        int i10;
        boolean z6;
        boolean z7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z)})) == null) {
            int overScrollMode = getOverScrollMode();
            if (computeHorizontalScrollRange() > computeHorizontalScrollExtent()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (computeVerticalScrollRange() > computeVerticalScrollExtent()) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (overScrollMode != 0 && (overScrollMode != 1 || !z2)) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (overScrollMode != 0 && (overScrollMode != 1 || !z3)) {
                z5 = false;
            } else {
                z5 = true;
            }
            int i11 = i3 + i;
            if (!z4) {
                i9 = 0;
            } else {
                i9 = i7;
            }
            int i12 = i4 + i2;
            if (!z5) {
                i10 = 0;
            } else {
                i10 = i8;
            }
            int i13 = -i9;
            int i14 = i9 + i5;
            int i15 = -i10;
            int i16 = i10 + i6;
            if (i11 > i14) {
                i11 = i14;
            } else if (i11 < i13) {
                i11 = i13;
            } else {
                z6 = false;
                if (i12 <= i16) {
                    i12 = i16;
                } else if (i12 < i15) {
                    i12 = i15;
                } else {
                    z7 = false;
                    if (z7 && !hasNestedScrollingParent(1)) {
                        this.j.springBack(i11, i12, 0, 0, 0, getScrollRange());
                    }
                    onOverScrolled(i11, i12, z6, z7);
                    if (z6 && !z7) {
                        return false;
                    }
                    return true;
                }
                z7 = true;
                if (z7) {
                    this.j.springBack(i11, i12, 0, 0, 0, getScrollRange());
                }
                onOverScrolled(i11, i12, z6, z7);
                if (z6) {
                }
                return true;
            }
            z6 = true;
            if (i12 <= i16) {
            }
            z7 = true;
            if (z7) {
            }
            onOverScrolled(i11, i12, z6, z7);
            if (z6) {
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 2 && this.e) {
                return true;
            }
            int i = action & 255;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 6) {
                                k(motionEvent);
                            }
                        }
                    } else {
                        int i2 = this.h;
                        if (i2 != -1) {
                            int findPointerIndex = motionEvent.findPointerIndex(i2);
                            if (findPointerIndex == -1) {
                                Log.e("NestedScrollingWebView", "Invalid pointerId=" + i2 + " in onInterceptTouchEvent");
                            } else {
                                int y = (int) motionEvent.getY(findPointerIndex);
                                if (Math.abs(y - this.c) > this.g && (2 & getNestedScrollAxes()) == 0) {
                                    this.e = true;
                                    this.c = y;
                                    i();
                                    this.f.addMovement(motionEvent);
                                    this.i = 0;
                                    ViewParent parent = getParent();
                                    if (parent != null) {
                                        parent.requestDisallowInterceptTouchEvent(true);
                                    }
                                }
                            }
                        }
                    }
                }
                this.e = false;
                this.h = -1;
                n();
                if (this.j.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                stopNestedScroll();
            } else {
                this.c = (int) motionEvent.getY();
                this.h = motionEvent.getPointerId(0);
                g();
                this.f.addMovement(motionEvent);
                this.j.computeScrollOffset();
                this.e = !this.j.isFinished();
                startNestedScroll(2);
            }
            return this.e;
        }
        return invokeL.booleanValue;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048603, this, i, i2, i3, i4) == null) {
            super.onScrollChanged(i, i2, i3, i4);
            if (this.p != null) {
                if (Math.abs((getContentHeight() * getScale()) - (getHeight() + getScrollY())) < 1.0f) {
                    this.p.d(i, i2, i3, i4);
                } else if (getScrollY() == 0) {
                    this.p.b(i, i2, i3, i4);
                } else {
                    this.p.onScrollChanged(i, i2, i3, i4);
                }
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, motionEvent)) == null) {
            if (this.o != null) {
                m(this, motionEvent);
            }
            i();
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            boolean z = false;
            if (actionMasked == 0) {
                this.i = 0;
            }
            obtain.offsetLocation(0.0f, this.i);
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 3) {
                            if (actionMasked != 5) {
                                if (actionMasked == 6) {
                                    k(motionEvent);
                                    this.c = (int) motionEvent.getY(motionEvent.findPointerIndex(this.h));
                                }
                            } else {
                                int actionIndex = motionEvent.getActionIndex();
                                this.c = (int) motionEvent.getY(actionIndex);
                                this.h = motionEvent.getPointerId(actionIndex);
                            }
                        } else {
                            if (this.e) {
                                if (this.j.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                                    ViewCompat.postInvalidateOnAnimation(this);
                                }
                                if (this.j.isFinished()) {
                                    VelocityTracker velocityTracker = this.f;
                                    velocityTracker.computeCurrentVelocity(1000, this.l);
                                    int yVelocity = (int) velocityTracker.getYVelocity(this.h);
                                    if (Math.abs(yVelocity) > this.k) {
                                        f(-yVelocity);
                                    }
                                }
                            }
                            this.h = -1;
                            d();
                        }
                    } else {
                        int findPointerIndex = motionEvent.findPointerIndex(this.h);
                        if (findPointerIndex == -1) {
                            Log.e("NestedScrollingWebView", "Invalid pointerId=" + this.h + " in onTouchEvent");
                        } else {
                            int y = (int) motionEvent.getY(findPointerIndex);
                            int i = this.c - y;
                            if (dispatchNestedPreScroll(0, i, this.a, this.b, 0)) {
                                i -= this.a[1];
                                motionEvent.offsetLocation(0.0f, -this.b[1]);
                                obtain.offsetLocation(0.0f, -this.b[1]);
                                this.i += this.b[1];
                            }
                            if (!this.e) {
                                int abs = Math.abs(i);
                                int i2 = this.g;
                                if (abs > i2) {
                                    this.e = true;
                                    if (i > 0) {
                                        i -= i2;
                                    } else {
                                        i += i2;
                                    }
                                }
                            }
                            int i3 = i;
                            if (this.e) {
                                this.c = y - this.b[1];
                                int scrollY = getScrollY();
                                if (l(0, i3, 0, scrollY, 0, getScrollRange(), 0, 0, true) && !hasNestedScrollingParent(0)) {
                                    this.f.clear();
                                }
                                int scrollY2 = getScrollY() - scrollY;
                                int[] iArr = this.a;
                                iArr[1] = 0;
                                dispatchNestedScroll(0, scrollY2, 0, i3 - scrollY2, this.b, 0, iArr);
                                int i4 = this.c;
                                int[] iArr2 = this.b;
                                this.c = i4 - iArr2[1];
                                this.i += iArr2[1];
                            }
                        }
                    }
                } else {
                    VelocityTracker velocityTracker2 = this.f;
                    velocityTracker2.computeCurrentVelocity(1000, this.l);
                    int yVelocity2 = (int) velocityTracker2.getYVelocity(this.h);
                    if (Math.abs(yVelocity2) > this.k) {
                        int i5 = -yVelocity2;
                        float f = i5;
                        if (!dispatchNestedPreFling(0.0f, f)) {
                            dispatchNestedFling(0.0f, f, true);
                            f(i5);
                        }
                    } else if (this.j.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        ViewCompat.postInvalidateOnAnimation(this);
                    }
                    this.h = -1;
                    d();
                }
            } else {
                ViewParent e = e(this);
                if (e != null) {
                    e.requestDisallowInterceptTouchEvent(true);
                }
                if (!this.j.isFinished()) {
                    c();
                }
                this.c = (int) motionEvent.getY();
                this.h = motionEvent.getPointerId(0);
                startNestedScroll(2, 0);
            }
            VelocityTracker velocityTracker3 = this.f;
            if (velocityTracker3 != null) {
                velocityTracker3.addMovement(obtain);
            }
            obtain.recycle();
            if (this.q) {
                if (obtain.getAction() != 0) {
                    z = true;
                }
                requestDisallowInterceptTouchEvent(z);
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View
    public boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Boolean.valueOf(z)})) == null) {
            if (!this.e) {
                l(i, i2, i3, i4, i5, i6, i7, i8, z);
                return true;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
