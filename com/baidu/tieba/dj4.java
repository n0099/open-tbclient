package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class dj4 extends bj4<oj4> implements kj4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile oj4 b;

    public dj4() {
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

    public synchronized oj4 g() {
        InterceptResult invokeV;
        oj4 oj4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                oj4Var = (oj4) super.c();
            }
            return oj4Var;
        }
        return (oj4) invokeV.objValue;
    }

    public synchronized oj4 i() {
        InterceptResult invokeV;
        oj4 oj4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                oj4Var = (oj4) super.d();
            }
            return oj4Var;
        }
        return (oj4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kj4
    public <T> void a(oj4<T> oj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, oj4Var) == null) {
            this.b = oj4Var;
        }
    }

    @Override // com.baidu.tieba.kj4
    public <T> void b(oj4<T> oj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, oj4Var) == null) {
            if (this.b == oj4Var) {
                this.b = null;
            }
            k(oj4Var);
        }
    }

    public final void k(oj4 oj4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, oj4Var) != null) || !oj4Var.k()) {
            return;
        }
        oj4Var.r(true);
        this.a.add(0, oj4Var);
    }

    public synchronized void h(oj4 oj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, oj4Var) == null) {
            synchronized (this) {
                if (oj4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(oj4Var)) {
                    oj4Var.e().f(oj4Var.f());
                    return;
                }
                oj4 e = e(oj4Var);
                if (e != null) {
                    oj4Var.e().f(oj4Var.f());
                    if (oj4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = oj4Var.g();
                if (g != 200) {
                    if (g != 300) {
                        if (e == null) {
                            this.a.add(oj4Var);
                        }
                    } else {
                        j(oj4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, oj4Var);
                        }
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, oj4Var);
                }
                notifyAll();
            }
        }
    }

    public final void j(oj4 oj4Var) {
        oj4 oj4Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, oj4Var) != null) || oj4Var.g() != 300 || (oj4Var2 = this.b) == null || oj4Var2.g() == 300) {
            return;
        }
        oj4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
