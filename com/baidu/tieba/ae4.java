package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ae4 extends yd4<le4> implements he4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile le4 b;

    public ae4() {
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

    public synchronized le4 g() {
        InterceptResult invokeV;
        le4 le4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                le4Var = (le4) super.c();
            }
            return le4Var;
        }
        return (le4) invokeV.objValue;
    }

    public synchronized le4 i() {
        InterceptResult invokeV;
        le4 le4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                le4Var = (le4) super.d();
            }
            return le4Var;
        }
        return (le4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.he4
    public <T> void a(le4<T> le4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, le4Var) == null) {
            this.b = le4Var;
        }
    }

    @Override // com.baidu.tieba.he4
    public <T> void b(le4<T> le4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, le4Var) == null) {
            if (this.b == le4Var) {
                this.b = null;
            }
            k(le4Var);
        }
    }

    public final void k(le4 le4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, le4Var) != null) || !le4Var.k()) {
            return;
        }
        le4Var.r(true);
        this.a.add(0, le4Var);
    }

    public synchronized void h(le4 le4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, le4Var) == null) {
            synchronized (this) {
                if (le4Var == null) {
                    return;
                }
                if (this.b != null && this.b.d(le4Var)) {
                    le4Var.e().f(le4Var.f());
                    return;
                }
                le4 e = e(le4Var);
                if (e != null) {
                    le4Var.e().f(le4Var.f());
                    if (le4Var.g() <= e.g()) {
                        return;
                    }
                }
                int g = le4Var.g();
                if (g != 200) {
                    if (g != 300) {
                        if (e == null) {
                            this.a.add(le4Var);
                        }
                    } else {
                        j(le4Var);
                        if (e != null) {
                            this.a.remove(e);
                            this.a.add(0, e);
                        } else {
                            this.a.add(0, le4Var);
                        }
                    }
                } else if (e != null) {
                    this.a.remove(e);
                    this.a.add(0, e);
                } else {
                    this.a.add(0, le4Var);
                }
                notifyAll();
            }
        }
    }

    public final void j(le4 le4Var) {
        le4 le4Var2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, le4Var) != null) || le4Var.g() != 300 || (le4Var2 = this.b) == null || le4Var2.g() == 300) {
            return;
        }
        le4Var2.o();
        for (int i = 0; i < 500 && this.b != null; i++) {
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
