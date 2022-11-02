package com.baidu.tieba;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class hk5 extends kk5 implements View.OnTouchListener, GestureDetector.OnGestureListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public ListView B;
    public gk5 C;
    public int D;
    public GestureDetector.OnGestureListener E;
    public int e;
    public boolean f;
    public int g;
    public boolean h;
    public boolean i;
    public GestureDetector j;
    public GestureDetector k;
    public GestureDetector l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int[] q;
    public int r;
    public int s;
    public int t;
    public int u;
    public boolean v;
    public float w;
    public int x;
    public int y;
    public int z;

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, motionEvent) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements GestureDetector.OnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk5 a;

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, motionEvent) == null) {
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        public a(hk5 hk5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hk5Var;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent) == null) {
                this.a.onLongPress(motionEvent);
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (this.a.C.g0() && !this.a.C.h0()) {
                    this.a.onDown(motionEvent);
                    this.a.t = (int) motionEvent.getX();
                    this.a.u = (int) motionEvent.getY();
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hk5 a;

        public b(hk5 hk5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hk5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hk5Var;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                if (this.a.h && this.a.i) {
                    int width = this.a.B.getWidth() / 5;
                    if (f > this.a.w) {
                        if (this.a.D > (-width)) {
                            this.a.C.A0(true, f);
                        }
                    } else if (f < (-this.a.w) && this.a.D < width) {
                        this.a.C.A0(true, f);
                    }
                    this.a.i = false;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public hk5(gk5 gk5Var, ListView listView, int i, int i2, int i3) {
        this(gk5Var, listView, i, i2, i3, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gk5Var, listView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((gk5) objArr2[0], (ListView) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Integer) objArr2[5]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public hk5(gk5 gk5Var, ListView listView, int i, int i2, int i3, int i4) {
        this(gk5Var, listView, i, i2, i3, i4, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gk5Var, listView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((gk5) objArr2[0], (ListView) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), ((Integer) objArr2[5]).intValue(), ((Integer) objArr2[6]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hk5(gk5 gk5Var, ListView listView, int i, int i2, int i3, int i4, int i5) {
        super(listView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gk5Var, listView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                super((ListView) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.e = 0;
        this.f = true;
        this.h = false;
        this.i = false;
        this.n = -1;
        this.o = -1;
        this.p = -1;
        this.q = new int[2];
        this.v = false;
        this.w = 500.0f;
        this.E = new b(this);
        this.C = gk5Var;
        this.B = listView;
        this.j = new GestureDetector(listView.getContext(), this);
        this.k = new GestureDetector(listView.getContext(), new a(this));
        GestureDetector gestureDetector = new GestureDetector(listView.getContext(), this.E);
        this.l = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.m = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.x = i;
        this.y = i4;
        this.z = i5;
        t(i3);
        q(i2);
    }

    public int n(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
            return y(motionEvent, this.x);
        }
        return invokeL.intValue;
    }

    public int o(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            return y(motionEvent, this.z);
        }
        return invokeL.intValue;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, motionEvent) == null) && this.n != -1 && this.e == 2) {
            this.B.performHapticFeedback(0);
            v(this.n, this.t - this.r, this.u - this.s);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            if (this.h && this.g == 0 && (i = this.p) != -1) {
                this.C.l0(i - this.B.getHeaderViewsCount());
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.e = i;
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.h = z;
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.g = i;
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f = z;
        }
    }

    public int w(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) {
            return n(motionEvent);
        }
        return invokeL.intValue;
    }

    public int x(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, motionEvent)) == null) {
            if (this.g == 1) {
                return o(motionEvent);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.gk5.j
    public void c(View view2, Point point, Point point2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048576, this, view2, point, point2) == null) && this.h && this.i) {
            this.D = point.x;
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
            if (this.h && this.g == 0) {
                this.p = y(motionEvent, this.y);
            }
            int w = w(motionEvent);
            this.n = w;
            if (w != -1 && this.e == 0) {
                v(w, ((int) motionEvent.getX()) - this.r, ((int) motionEvent.getY()) - this.s);
            }
            this.i = false;
            this.A = true;
            this.D = 0;
            this.o = x(motionEvent);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (motionEvent != null && motionEvent2 != null) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int x2 = (int) motionEvent2.getX();
                int y2 = (int) motionEvent2.getY();
                int i = x2 - this.r;
                int i2 = y2 - this.s;
                if (this.A && !this.v && (this.n != -1 || this.o != -1)) {
                    if (this.n != -1) {
                        if (this.e == 1 && Math.abs(y2 - y) > this.m && this.f) {
                            v(this.n, i, i2);
                        } else if (this.e != 0 && Math.abs(x2 - x) > this.m && this.h) {
                            this.i = true;
                            v(this.o, i, i2);
                        }
                    } else if (this.o != -1) {
                        if (Math.abs(x2 - x) > this.m && this.h) {
                            this.i = true;
                            v(this.o, i, i2);
                        } else if (Math.abs(y2 - y) > this.m) {
                            this.A = false;
                        }
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, view2, motionEvent)) == null) {
            if (this.C.g0() && !this.C.h0()) {
                this.j.onTouchEvent(motionEvent);
                if (this.h && this.v && this.g == 1) {
                    this.l.onTouchEvent(motionEvent);
                }
                int action = motionEvent.getAction() & 255;
                if (action != 0) {
                    if (action != 1) {
                        if (action == 3) {
                            this.i = false;
                            this.v = false;
                        }
                    } else {
                        if (this.h && this.i) {
                            int i = this.D;
                            if (i < 0) {
                                i = -i;
                            }
                            if (i > this.B.getWidth() / 2) {
                                this.C.A0(true, 0.0f);
                            }
                        }
                        this.i = false;
                        this.v = false;
                    }
                } else {
                    this.t = (int) motionEvent.getX();
                    this.u = (int) motionEvent.getY();
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public int y(MotionEvent motionEvent, int i) {
        InterceptResult invokeLI;
        View findViewById;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048594, this, motionEvent, i)) == null) {
            int pointToPosition = this.B.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            int headerViewsCount = this.B.getHeaderViewsCount();
            int footerViewsCount = this.B.getFooterViewsCount();
            int count = this.B.getCount();
            if (pointToPosition != -1 && pointToPosition >= headerViewsCount && pointToPosition < count - footerViewsCount) {
                ListView listView = this.B;
                View childAt = listView.getChildAt(pointToPosition - listView.getFirstVisiblePosition());
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                if (i == 0) {
                    findViewById = childAt;
                } else {
                    findViewById = childAt.findViewById(i);
                }
                if (findViewById != null) {
                    findViewById.getLocationOnScreen(this.q);
                    int[] iArr = this.q;
                    if (rawX > iArr[0] && rawY > iArr[1] && rawX < iArr[0] + findViewById.getWidth() && rawY < this.q[1] + findViewById.getHeight()) {
                        this.r = childAt.getLeft();
                        this.s = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
            return -1;
        }
        return invokeLI.intValue;
    }

    public GestureDetector p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.k;
        }
        return (GestureDetector) invokeV.objValue;
    }

    public boolean v(int i, int i2, int i3) {
        InterceptResult invokeIII;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048591, this, i, i2, i3)) == null) {
            if (this.f && !this.i) {
                i4 = 12;
            } else {
                i4 = 0;
            }
            if (this.h && this.i) {
                i4 = i4 | 1 | 2;
            }
            boolean w0 = this.C.w0(i - this.B.getHeaderViewsCount(), i4, i2, i3);
            this.v = w0;
            return w0;
        }
        return invokeIII.booleanValue;
    }
}
