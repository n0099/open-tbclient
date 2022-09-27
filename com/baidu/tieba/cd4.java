package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class cd4 extends ad4<nd4> implements jd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile nd4 b;

    public cd4() {
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

    @Override // com.baidu.tieba.jd4
    public <T> void a(nd4<T> nd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nd4Var) == null) {
            this.b = nd4Var;
        }
    }

    @Override // com.baidu.tieba.jd4
    public <T> void b(nd4<T> nd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nd4Var) == null) {
            if (this.b == nd4Var) {
                this.b = null;
            }
            k(nd4Var);
        }
    }

    public synchronized nd4 g() {
        InterceptResult invokeV;
        nd4 nd4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                nd4Var = (nd4) super.c();
            }
            return nd4Var;
        }
        return (nd4) invokeV.objValue;
    }

    public synchronized void h(nd4 nd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nd4Var) == null) {
            synchronized (this) {
                if (nd4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(nd4Var)) {
                    nd4Var.e().f(nd4Var.f());
                    return;
                }
                nd4 e = e(nd4Var);
                if (e != null) {
                    nd4Var.e().f(nd4Var.f());
                    if (nd4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = nd4Var.g();
                if (g != 200) {
                    if (g == 300) {
                        j(nd4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, nd4Var);
                        }
                    } else if (e == null) {
                        this.a.add(nd4Var);
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, nd4Var);
                }
                notifyAll();
            }
        }
    }

    public synchronized nd4 i() {
        InterceptResult invokeV;
        nd4 nd4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                nd4Var = (nd4) super.d();
            }
            return nd4Var;
        }
        return (nd4) invokeV.objValue;
    }

    public final void j(nd4 nd4Var) {
        nd4 nd4Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, nd4Var) == null) || nd4Var.g() != 300 || (nd4Var2 = this.b) == null || nd4Var2.g() == 300) {
            return;
        }
        nd4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public final void k(nd4 nd4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, nd4Var) == null) && nd4Var.k()) {
            nd4Var.r(true);
            this.a.add(0, nd4Var);
        }
    }
}
