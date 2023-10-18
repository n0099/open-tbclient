package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gf4 extends ef4<rf4> implements nf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile rf4 b;

    public gf4() {
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

    public synchronized rf4 g() {
        InterceptResult invokeV;
        rf4 rf4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                rf4Var = (rf4) super.c();
            }
            return rf4Var;
        }
        return (rf4) invokeV.objValue;
    }

    public synchronized rf4 i() {
        InterceptResult invokeV;
        rf4 rf4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                rf4Var = (rf4) super.d();
            }
            return rf4Var;
        }
        return (rf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nf4
    public <T> void a(rf4<T> rf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, rf4Var) == null) {
            this.b = rf4Var;
        }
    }

    @Override // com.baidu.tieba.nf4
    public <T> void b(rf4<T> rf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rf4Var) == null) {
            if (this.b == rf4Var) {
                this.b = null;
            }
            k(rf4Var);
        }
    }

    public final void k(rf4 rf4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, rf4Var) != null) || !rf4Var.k()) {
            return;
        }
        rf4Var.r(true);
        this.a.add(0, rf4Var);
    }

    public synchronized void h(rf4 rf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rf4Var) == null) {
            synchronized (this) {
                if (rf4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(rf4Var)) {
                    rf4Var.e().f(rf4Var.f());
                    return;
                }
                rf4 e = e(rf4Var);
                if (e != null) {
                    rf4Var.e().f(rf4Var.f());
                    if (rf4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = rf4Var.g();
                if (g != 200) {
                    if (g != 300) {
                        if (e == null) {
                            this.a.add(rf4Var);
                        }
                    } else {
                        j(rf4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, rf4Var);
                        }
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, rf4Var);
                }
                notifyAll();
            }
        }
    }

    public final void j(rf4 rf4Var) {
        rf4 rf4Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, rf4Var) != null) || rf4Var.g() != 300 || (rf4Var2 = this.b) == null || rf4Var2.g() == 300) {
            return;
        }
        rf4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
