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
/* loaded from: classes3.dex */
public class NestedScrollWebView extends ScrollBridgeWebview implements NestedScrollingChild2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int[] c;
    public final int[] d;
    public int e;
    public VelocityTracker f;
    public int g;
    public int h;
    public OverScroller i;
    public int j;
    public NestedScrollingChildHelper k;

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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new int[2];
        this.d = new int[2];
        init();
    }

    @RequiresApi(api = 9)
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            startNestedScroll(2, 1);
            this.i.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            this.j = getScrollY();
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f == null) {
            this.f = VelocityTracker.obtain();
        }
    }

    public final void c() {
        VelocityTracker velocityTracker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (velocityTracker = this.f) == null) {
            return;
        }
        velocityTracker.recycle();
        this.f = null;
    }

    @Override // android.webkit.WebView, android.view.View
    @RequiresApi(api = 9)
    public void computeScroll() {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.computeScroll();
            if (this.i.computeScrollOffset()) {
                this.i.getCurrX();
                int currY = this.i.getCurrY();
                int i3 = currY - this.j;
                if (i3 != 0) {
                    int scrollY = getScrollY();
                    if (scrollY == 0) {
                        i2 = i3;
                        i = 0;
                    } else {
                        int i4 = scrollY + i3;
                        if (i4 < 0) {
                            i = -scrollY;
                            i2 = i4;
                        } else {
                            i = i3;
                            i2 = 0;
                        }
                    }
                    dispatchNestedScroll(0, i, 0, i2, null, 1);
                }
                this.j = currY;
                ViewCompat.postInvalidateOnAnimation(this);
                return;
            }
            if (hasNestedScrollingParent(1)) {
                stopNestedScroll(1);
            }
            this.j = 0;
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z)})) == null) ? this.k.dispatchNestedFling(f, f2, z) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) ? this.k.dispatchNestedPreFling(f, f2) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), iArr, iArr2})) == null) ? this.k.dispatchNestedPreScroll(i, i2, iArr, iArr2) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr})) == null) ? this.k.dispatchNestedScroll(i, i2, i3, i4, iArr) : invokeCommon.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k.hasNestedScrollingParent() : invokeV.booleanValue;
    }

    @RequiresApi(api = 9)
    public final void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.k = new NestedScrollingChildHelper(this);
            setNestedScrollingEnabled(true);
            this.i = new OverScroller(getContext());
            ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
            this.g = viewConfiguration.getScaledMinimumFlingVelocity();
            this.h = viewConfiguration.getScaledMaximumFlingVelocity();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k.isNestedScrollingEnabled() : invokeV.booleanValue;
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
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, motionEvent)) == null) {
            b();
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        int rawY = (int) motionEvent.getRawY();
                        int i2 = this.e - rawY;
                        if (dispatchNestedPreScroll(0, i2, this.c, this.d)) {
                            obtain.offsetLocation(0.0f, this.c[1]);
                        }
                        this.e = rawY;
                        int scrollY = getScrollY();
                        if (scrollY == 0) {
                            i = i2;
                        } else {
                            int i3 = scrollY + i2;
                            if (i3 < 0) {
                                obtain.offsetLocation(0.0f, -i3);
                                i = i3;
                            } else {
                                i = 0;
                            }
                        }
                        this.f.addMovement(obtain);
                        boolean onTouchEvent = super.onTouchEvent(obtain);
                        dispatchNestedScroll(0, i2 - i, 0, i, this.d);
                        return onTouchEvent;
                    }
                }
                VelocityTracker velocityTracker = this.f;
                velocityTracker.computeCurrentVelocity(1000, this.h);
                int yVelocity = (int) velocityTracker.getYVelocity();
                if (Math.abs(yVelocity) > this.g) {
                    a(-yVelocity);
                }
                stopNestedScroll();
                c();
            } else {
                this.e = (int) motionEvent.getRawY();
                startNestedScroll(2);
                this.f.addMovement(obtain);
                this.i.computeScrollOffset();
                if (!this.i.isFinished()) {
                    this.i.abortAnimation();
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
            this.k.setNestedScrollingEnabled(z);
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) ? this.k.startNestedScroll(i) : invokeI.booleanValue;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.k.stopNestedScroll();
        }
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), iArr, iArr2, Integer.valueOf(i3)})) == null) ? this.k.dispatchNestedPreScroll(i, i2, iArr, iArr2, i3) : invokeCommon.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iArr, Integer.valueOf(i5)})) == null) ? this.k.dispatchNestedScroll(i, i2, i3, i4, iArr, i5) : invokeCommon.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) ? this.k.hasNestedScrollingParent(i) : invokeI.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048593, this, i, i2)) == null) ? this.k.startNestedScroll(i, i2) : invokeII.booleanValue;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.k.stopNestedScroll(i);
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
        this.c = new int[2];
        this.d = new int[2];
        init();
    }
}
