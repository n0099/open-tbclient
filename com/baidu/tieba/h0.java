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
public class h0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final p0<h0> a;
    public final p0<h0> b;
    public boolean c;
    public boolean d;
    public ComponentOperationHandler e;
    public q0<e0> f;
    public t6<e0> g;
    public w6 h;
    public w6 i;

    public h0() {
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
        this.f = new q0<>();
        this.g = new t6<>(false, 16);
        this.h = new w6();
        this.i = new w6();
        this.a = new p0<>();
        this.b = new p0<>();
    }

    public h0 a(e0 e0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e0Var)) == null) {
            if (b(e0Var)) {
                ComponentOperationHandler componentOperationHandler = this.e;
                if (componentOperationHandler != null) {
                    componentOperationHandler.a(this);
                } else {
                    g();
                }
            }
            return this;
        }
        return (h0) invokeL.objValue;
    }

    public <T extends e0> T c(f0 f0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, f0Var)) == null) {
            if (f0Var.c() < this.f.b()) {
                return (T) this.f.a(f0Var.c());
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public <T extends e0> T d(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cls)) == null) {
            return (T) c(f0.b(cls));
        }
        return (T) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.tieba.h0 */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean b(e0 e0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e0Var)) == null) {
            Class<?> cls = e0Var.getClass();
            e0 d = d(cls);
            if (e0Var == d) {
                return false;
            }
            if (d != null) {
                k(cls);
            }
            int d2 = f0.d(cls);
            this.f.d(d2, e0Var);
            this.g.a(e0Var);
            this.h.k(d2);
            return true;
        }
        return invokeL.booleanValue;
    }

    public e0 i(Class<? extends e0> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls)) == null) {
            e0 a = this.f.a(f0.b(cls).c());
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
        return (e0) invokeL.objValue;
    }

    public boolean k(Class<? extends e0> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, cls)) == null) {
            int c = f0.b(cls).c();
            e0 a = this.f.a(c);
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

    public w6 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.h;
        }
        return (w6) invokeV.objValue;
    }

    public w6 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.i;
        }
        return (w6) invokeV.objValue;
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

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.tieba.h0 */
    /* JADX WARN: Multi-variable type inference failed */
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048585, this) != null) {
            return;
        }
        while (true) {
            t6<e0> t6Var = this.g;
            if (t6Var.b > 0) {
                i(t6Var.get(0).getClass());
            } else {
                return;
            }
        }
    }
}
