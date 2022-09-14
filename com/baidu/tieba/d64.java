package com.baidu.tieba;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d64 {
    public static /* synthetic */ Interceptable $ic;
    public static final int g;
    public static volatile d64 h;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public boolean d;
    public int e;
    public ViewTreeObserver.OnGlobalLayoutListener f;

    /* loaded from: classes3.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ c64 b;
        public final /* synthetic */ d64 c;

        public a(d64 d64Var, View view2, c64 c64Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d64Var, view2, c64Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = d64Var;
            this.a = view2;
            this.b = c64Var;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Rect rect = new Rect();
                View view2 = this.a;
                if (view2 == null) {
                    return;
                }
                view2.getWindowVisibleDisplayFrame(rect);
                int i = rect.bottom - rect.top;
                int n = pg3.n(AppRuntime.getAppContext());
                int t = pg3.t();
                if (!this.c.d) {
                    this.c.d = true;
                    this.c.c = (n - i) - t;
                    if (this.c.c < 0) {
                        this.c.c = 0;
                    }
                }
                if (i > 0) {
                    if (i >= this.c.e || this.a.getHeight() - i <= 200) {
                        if (i <= this.c.e || this.a.getHeight() - i >= 200) {
                            return;
                        }
                        this.c.e = i;
                        this.c.s(this.b);
                        return;
                    }
                    this.c.e = i;
                    this.c.b = i - d64.g;
                    d64 d64Var = this.c;
                    d64Var.a = ((n - i) - t) - d64Var.c;
                    if (this.c.a > 0) {
                        d64 d64Var2 = this.c;
                        if (d64Var2.t(this.b, d64Var2.a, this.c.b)) {
                            return;
                        }
                        this.c.s(this.b);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947656487, "Lcom/baidu/tieba/d64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947656487, "Lcom/baidu/tieba/d64;");
                return;
            }
        }
        g = o54.a(42.0f);
        h = null;
    }

    public d64() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f = null;
    }

    public static d64 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (h == null) {
                synchronized (d64.class) {
                    if (h == null) {
                        h = new d64();
                    }
                }
            }
            return h;
        }
        return (d64) invokeV.objValue;
    }

    public final void m(View view2, c64 c64Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, view2, c64Var) == null) || view2 == null || c64Var == null) {
            return;
        }
        this.e = view2.getHeight();
        this.f = new a(this, view2, c64Var);
        view2.getViewTreeObserver().addOnGlobalLayoutListener(this.f);
    }

    public boolean n(c64 c64Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c64Var)) == null) {
            pk1 X = lo2.U().X();
            boolean z = (X == null || r(c64Var.f()) || !X.c(c64Var.f(), o())) ? false : true;
            if (z) {
                if (!c64Var.l() || X == null) {
                    return false;
                }
                m(X.getRootView(), c64Var);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final et2 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            et2 et2Var = new et2();
            et2Var.k(true);
            et2Var.n(-1);
            et2Var.j(-2);
            return et2Var;
        }
        return (et2) invokeV.objValue;
    }

    public final et2 q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            et2 et2Var = new et2();
            et2Var.k(true);
            et2Var.m(i);
            et2Var.n(-1);
            et2Var.j(-2);
            return et2Var;
        }
        return (et2) invokeI.objValue;
    }

    public final boolean r(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
            pk1 X = lo2.U().X();
            return X != null && X.d(view2);
        }
        return invokeL.booleanValue;
    }

    public boolean s(c64 c64Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, c64Var)) == null) {
            pk1 X = lo2.U().X();
            if (X == null) {
                return false;
            }
            FrameLayout rootView = X.getRootView();
            if (rootView != null && this.f != null) {
                rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this.f);
            }
            c64Var.h();
            this.f = null;
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.d = false;
            this.e = -1;
            return X.removeView(c64Var.f());
        }
        return invokeL.booleanValue;
    }

    public final boolean t(c64 c64Var, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, c64Var, i, i2)) == null) {
            pk1 X = lo2.U().X();
            boolean z = X != null && X.a(c64Var.f(), q(i2));
            if (z) {
                c64Var.k(i);
            }
            return z;
        }
        return invokeLII.booleanValue;
    }
}
