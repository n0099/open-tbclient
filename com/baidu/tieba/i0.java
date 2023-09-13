package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.ashley.core.ComponentOperationHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class i0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final q0<i0> a;
    public final q0<i0> b;
    public boolean c;
    public boolean d;
    public ComponentOperationHandler e;
    public r0<f0> f;
    public u6<f0> g;
    public x6 h;
    public x6 i;

    public i0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new r0<>();
        this.g = new u6<>(false, 16);
        this.h = new x6();
        this.i = new x6();
        this.a = new q0<>();
        this.b = new q0<>();
    }

    public i0 a(f0 f0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f0Var)) == null) {
            if (b(f0Var)) {
                ComponentOperationHandler componentOperationHandler = this.e;
                if (componentOperationHandler != null) {
                    componentOperationHandler.a(this);
                } else {
                    g();
                }
            }
            return this;
        }
        return (i0) invokeL.objValue;
    }

    public <T extends f0> T c(g0 g0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, g0Var)) == null) {
            if (g0Var.c() < this.f.b()) {
                return (T) this.f.a(g0Var.c());
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public <T extends f0> T d(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cls)) == null) {
            return (T) c(g0.b(cls));
        }
        return (T) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.tieba.i0 */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(f0 f0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f0Var)) == null) {
            Class<?> cls = f0Var.getClass();
            f0 d = d(cls);
            if (f0Var == d) {
                return false;
            }
            if (d != null) {
                k(cls);
            }
            int d2 = g0.d(cls);
            this.f.d(d2, f0Var);
            this.g.a(f0Var);
            this.h.k(d2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public f0 i(Class<? extends f0> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls)) == null) {
            f0 a = this.f.a(g0.b(cls).c());
            if (a != null && k(cls)) {
                ComponentOperationHandler componentOperationHandler = this.e;
                if (componentOperationHandler != null) {
                    componentOperationHandler.c(this);
                } else {
                    h();
                }
            }
            return a;
        }
        return (f0) invokeL.objValue;
    }

    public boolean k(Class<? extends f0> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, cls)) == null) {
            int c = g0.b(cls).c();
            f0 a = this.f.a(c);
            if (a != null) {
                this.f.d(c, null);
                this.g.i(a, true);
                this.h.c(c);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public x6 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.h;
        }
        return (x6) invokeV.objValue;
    }

    public x6 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return (x6) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.b(this);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.b(this);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.tieba.i0 */
    /* JADX WARN: Multi-variable type inference failed */
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048585, this) != null) {
            return;
        }
        while (true) {
            u6<f0> u6Var = this.g;
            if (u6Var.b > 0) {
                i(u6Var.get(0).getClass());
            } else {
                return;
            }
        }
    }
}
