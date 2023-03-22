package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes4.dex */
public final class gf2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gf2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<kf2> b;

    public gf2() {
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
        this.a = new ReentrantLock();
        this.b = new ArrayList<>();
    }

    public static gf2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (gf2.class) {
                    if (c == null) {
                        c = new gf2();
                    }
                }
            }
            return c;
        }
        return (gf2) invokeV.objValue;
    }

    public final Object[] a() {
        Object[] objArr;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                this.a.lock();
                if (this.b.size() > 0) {
                    objArr = this.b.toArray();
                } else {
                    objArr = null;
                }
                return objArr;
            } finally {
                this.a.unlock();
            }
        }
        return (Object[]) invokeV.objValue;
    }

    public void b(bf2 bf2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bf2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((kf2) obj).d(bf2Var);
            }
        }
    }

    public void c(bf2 bf2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bf2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((kf2) obj).b(bf2Var);
            }
        }
    }

    public void d(bf2 bf2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, bf2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((kf2) obj).f(bf2Var);
            }
        }
    }

    public void e(bf2 bf2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bf2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((kf2) obj).c(bf2Var);
            }
        }
    }

    public void f(bf2 bf2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, bf2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((kf2) obj).g(bf2Var);
            }
        }
    }

    public void g(bf2 bf2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, bf2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((kf2) obj).a(bf2Var);
            }
        }
    }

    public void h(bf2 bf2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, bf2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((kf2) obj).e(bf2Var);
            }
        }
    }
}
