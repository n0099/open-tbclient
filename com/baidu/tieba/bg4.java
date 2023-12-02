package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bg4 extends zf4<mg4> implements ig4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile mg4 b;

    public bg4() {
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

    public synchronized mg4 g() {
        InterceptResult invokeV;
        mg4 mg4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                mg4Var = (mg4) super.c();
            }
            return mg4Var;
        }
        return (mg4) invokeV.objValue;
    }

    public synchronized mg4 i() {
        InterceptResult invokeV;
        mg4 mg4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                mg4Var = (mg4) super.d();
            }
            return mg4Var;
        }
        return (mg4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ig4
    public <T> void a(mg4<T> mg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mg4Var) == null) {
            this.b = mg4Var;
        }
    }

    @Override // com.baidu.tieba.ig4
    public <T> void b(mg4<T> mg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mg4Var) == null) {
            if (this.b == mg4Var) {
                this.b = null;
            }
            k(mg4Var);
        }
    }

    public final void k(mg4 mg4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, mg4Var) != null) || !mg4Var.k()) {
            return;
        }
        mg4Var.r(true);
        this.a.add(0, mg4Var);
    }

    public synchronized void h(mg4 mg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mg4Var) == null) {
            synchronized (this) {
                if (mg4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(mg4Var)) {
                    mg4Var.e().f(mg4Var.f());
                    return;
                }
                mg4 e = e(mg4Var);
                if (e != null) {
                    mg4Var.e().f(mg4Var.f());
                    if (mg4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = mg4Var.g();
                if (g != 200) {
                    if (g != 300) {
                        if (e == null) {
                            this.a.add(mg4Var);
                        }
                    } else {
                        j(mg4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, mg4Var);
                        }
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, mg4Var);
                }
                notifyAll();
            }
        }
    }

    public final void j(mg4 mg4Var) {
        mg4 mg4Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, mg4Var) != null) || mg4Var.g() != 300 || (mg4Var2 = this.b) == null || mg4Var2.g() == 300) {
            return;
        }
        mg4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
