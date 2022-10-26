package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class dd4 extends bd4 implements kd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile od4 b;

    public dd4() {
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

    public synchronized od4 g() {
        InterceptResult invokeV;
        od4 od4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                od4Var = (od4) super.c();
            }
            return od4Var;
        }
        return (od4) invokeV.objValue;
    }

    public synchronized od4 i() {
        InterceptResult invokeV;
        od4 od4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                od4Var = (od4) super.d();
            }
            return od4Var;
        }
        return (od4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kd4
    public void a(od4 od4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, od4Var) == null) {
            this.b = od4Var;
        }
    }

    @Override // com.baidu.tieba.kd4
    public void b(od4 od4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, od4Var) == null) {
            if (this.b == od4Var) {
                this.b = null;
            }
            k(od4Var);
        }
    }

    public final void k(od4 od4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, od4Var) != null) || !od4Var.k()) {
            return;
        }
        od4Var.r(true);
        this.a.add(0, od4Var);
    }

    public synchronized void h(od4 od4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, od4Var) == null) {
            synchronized (this) {
                if (od4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(od4Var)) {
                    od4Var.e().f(od4Var.f());
                    return;
                }
                od4 od4Var2 = (od4) e(od4Var);
                if (od4Var2 != null) {
                    od4Var.e().f(od4Var.f());
                    if (od4Var.g() <= od4Var2.g()) {
                        return;
                    }
                }
                int g = od4Var.g();
                if (g != 200) {
                    if (g != 300) {
                        if (od4Var2 == null) {
                            this.a.add(od4Var);
                        }
                    } else {
                        j(od4Var);
                        if (od4Var2 != null) {
                            this.a.remove(od4Var2);
                            this.a.add(0, od4Var2);
                        } else {
                            this.a.add(0, od4Var);
                        }
                    }
                } else if (od4Var2 != null) {
                    this.a.remove(od4Var2);
                    this.a.add(0, od4Var2);
                } else {
                    this.a.add(0, od4Var);
                }
                notifyAll();
            }
        }
    }

    public final void j(od4 od4Var) {
        od4 od4Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, od4Var) != null) || od4Var.g() != 300 || (od4Var2 = this.b) == null || od4Var2.g() == 300) {
            return;
        }
        od4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
