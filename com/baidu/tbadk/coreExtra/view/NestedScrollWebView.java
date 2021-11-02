package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.hybrid.ScrollBridgeWebview;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class NestedScrollWebView extends ScrollBridgeWebview implements NestedScrollingChild2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public final int[] f45764g;

    /* renamed from: h  reason: collision with root package name */
    public final int[] f45765h;

    /* renamed from: i  reason: collision with root package name */
    public int f45766i;
    public VelocityTracker j;
    public int k;
    public int l;
    public OverScroller m;
    public int n;
    public NestedScrollingChildHelper o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1405660401, "Lcom/baidu/tbadk/coreExtra/view/NestedScrollWebView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1405660401, "Lcom/baidu/tbadk/coreExtra/view/NestedScrollWebView;");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @RequiresApi(api = 9)
    public NestedScrollWebView(Context context) {
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
        this.f45764g = new int[2];
        this.f45765h = new int[2];
        init();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.j == null) {
            this.j = VelocityTracker.obtain();
        }
    }

    public final void b() {
        VelocityTracker velocityTracker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (velocityTracker = this.j) == null) {
            return;
        }
        velocityTracker.recycle();
        this.j = null;
    }

    @Override // android.webkit.WebView, android.view.View
    @RequiresApi(api = 9)
    public void computeScroll() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.computeScroll();
            if (this.m.computeScrollOffset()) {
                this.m.getCurrX();
                int currY = this.m.getCurrY();
                int i4 = currY - this.n;
                if (i4 != 0) {
                    int scrollY = getScrollY();
                    if (scrollY == 0) {
                        i3 = i4;
                        i2 = 0;
                    } else {
                        int i5 = scrollY + i4;
                        if (i5 < 0) {
                            i2 = -scrollY;
                            i3 = i5;
                        } else {
                            i2 = i4;
                            i3 = 0;
                        }
                    }
                    dispatchNestedScroll(0, i2, 0, i3, null, 1);
                }
                this.n = currY;
                ViewCompat.postInvalidateOnAnimation(this);
                return;
            }
            if (hasNestedScrollingParent(1)) {
                stopNestedScroll(1);
            }
            this.n = 0;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)})) == null) ? this.o.dispatchNestedFling(f2, f3, z) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? this.o.dispatchNestedPreFling(f2, f3) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2})) == null) ? this.o.dispatchNestedPreScroll(i2, i3, iArr, iArr2) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr})) == null) ? this.o.dispatchNestedScroll(i2, i3, i4, i5, iArr) : invokeCommon.booleanValue;
    }

    @RequiresApi(api = 9)
    public void fling(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            startNestedScroll(2, 1);
            this.m.fling(getScrollX(), getScrollY(), 0, i2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            this.n = getScrollY();
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.o.hasNestedScrollingParent() : invokeV.booleanValue;
    }

    @RequiresApi(api = 9)
    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.o = new NestedScrollingChildHelper(this);
            setNestedScrollingEnabled(true);
            this.m = new OverScroller(getContext());
            ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
            this.k = viewConfiguration.getScaledMinimumFlingVelocity();
            this.l = viewConfiguration.getScaledMaximumFlingVelocity();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.o.isNestedScrollingEnabled() : invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0018, code lost:
        if (r1 != 3) goto L10;
     */
    @Override // com.baidu.tbadk.core.hybrid.ScrollBridgeWebview, android.webkit.WebView, android.view.View
    @RequiresApi(api = 9)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) {
            a();
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        int rawY = (int) motionEvent.getRawY();
                        int i3 = this.f45766i - rawY;
                        if (dispatchNestedPreScroll(0, i3, this.f45764g, this.f45765h)) {
                            obtain.offsetLocation(0.0f, this.f45764g[1]);
                        }
                        this.f45766i = rawY;
                        int scrollY = getScrollY();
                        if (scrollY == 0) {
                            i2 = i3;
                        } else {
                            int i4 = scrollY + i3;
                            if (i4 < 0) {
                                obtain.offsetLocation(0.0f, -i4);
                                i2 = i4;
                            } else {
                                i2 = 0;
                            }
                        }
                        this.j.addMovement(obtain);
                        boolean onTouchEvent = super.onTouchEvent(obtain);
                        dispatchNestedScroll(0, i3 - i2, 0, i2, this.f45765h);
                        return onTouchEvent;
                    }
                }
                VelocityTracker velocityTracker = this.j;
                velocityTracker.computeCurrentVelocity(1000, this.l);
                int yVelocity = (int) velocityTracker.getYVelocity();
                if (Math.abs(yVelocity) > this.k) {
                    fling(-yVelocity);
                }
                stopNestedScroll();
                b();
            } else {
                this.f45766i = (int) motionEvent.getRawY();
                startNestedScroll(2);
                this.j.addMovement(obtain);
                this.m.computeScrollOffset();
                if (!this.m.isFinished()) {
                    this.m.abortAnimation();
                }
            }
            return super.onTouchEvent(obtain);
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.o.setNestedScrollingEnabled(z);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) ? this.o.startNestedScroll(i2) : invokeI.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.o.stopNestedScroll();
        }
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iArr, iArr2, Integer.valueOf(i4)})) == null) ? this.o.dispatchNestedPreScroll(i2, i3, iArr, iArr2, i4) : invokeCommon.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), iArr, Integer.valueOf(i6)})) == null) ? this.o.dispatchNestedScroll(i2, i3, i4, i5, iArr, i6) : invokeCommon.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? this.o.hasNestedScrollingParent(i2) : invokeI.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048593, this, i2, i3)) == null) ? this.o.startNestedScroll(i2, i3) : invokeII.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.o.stopNestedScroll(i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @RequiresApi(api = 9)
    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
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
        this.f45764g = new int[2];
        this.f45765h = new int[2];
        init();
    }
}
