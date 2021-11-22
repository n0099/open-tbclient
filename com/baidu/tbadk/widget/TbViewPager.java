package com.baidu.tbadk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes8.dex */
public class TbViewPager extends ViewPager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47038e;

    /* renamed from: f  reason: collision with root package name */
    public float f47039f;

    /* renamed from: g  reason: collision with root package name */
    public int f47040g;

    /* renamed from: h  reason: collision with root package name */
    public int f47041h;

    /* loaded from: classes8.dex */
    public class a extends Scroller {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbViewPager f47042a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TbViewPager tbViewPager, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbViewPager, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47042a = tbViewPager;
        }

        public void a(ViewPager viewPager) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewPager) == null) {
                try {
                    Field declaredField = ViewPager.class.getDeclaredField("mScroller");
                    declaredField.setAccessible(true);
                    declaredField.set(viewPager, this);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // android.widget.Scroller
        public void startScroll(int i2, int i3, int i4, int i5, int i6) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)}) == null) {
                super.startScroll(i2, i3, i4, i5, this.f47042a.f47041h);
            }
        }

        @Override // android.widget.Scroller
        public void startScroll(int i2, int i3, int i4, int i5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, i4, i5) == null) {
                super.startScroll(i2, i3, i4, i5, this.f47042a.f47041h);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbViewPager(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47038e = false;
        this.f47041h = 600;
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f47040g = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
        }
    }

    public final boolean c(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            int action = (motionEvent.getAction() & 65280) >> 8;
            return motionEvent.getPointerId(action) == -1 || action == -1 || action >= motionEvent.getPointerCount();
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (c(motionEvent)) {
                return true;
            }
            if (motionEvent.getPointerCount() > 1 && this.f47038e) {
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
        return invokeL.booleanValue;
    }

    public int getScrollingDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f47041h : invokeV.intValue;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            if (c(motionEvent)) {
                return true;
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001a, code lost:
        if (r0 != 6) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048581, this, motionEvent)) != null) {
            return invokeL.booleanValue;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x = motionEvent.getX() - this.f47039f;
                    if (getCurrentItem() == 0) {
                        if (x >= this.f47040g) {
                            requestParentInterceptTouchEvent(false);
                        } else {
                            requestParentInterceptTouchEvent(true);
                        }
                    } else if (getCurrentItem() == getAdapter().getCount() - 1) {
                        if (x <= (-this.f47040g)) {
                            requestParentInterceptTouchEvent(false);
                        } else {
                            requestParentInterceptTouchEvent(true);
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
            requestParentInterceptTouchEvent(false);
            this.f47039f = 0.0f;
            if (c(motionEvent)) {
            }
        }
        requestParentInterceptTouchEvent(true);
        this.f47039f = motionEvent.getX();
        if (c(motionEvent)) {
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f47038e = z;
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public final void requestParentInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || getParent() == null) {
            return;
        }
        getParent().requestDisallowInterceptTouchEvent(z);
    }

    public void setViewPagerScroll(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f47041h = i2;
            new a(this, getContext()).a(this);
        }
    }

    public void setViewPagerScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            setViewPagerScroll(600);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbViewPager(Context context, AttributeSet attributeSet) {
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
        this.f47038e = false;
        this.f47041h = 600;
        b();
    }
}
