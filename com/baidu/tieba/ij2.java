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
/* loaded from: classes6.dex */
public final class ij2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ij2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<mj2> b;

    public ij2() {
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

    public static ij2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (ij2.class) {
                    if (c == null) {
                        c = new ij2();
                    }
                }
            }
            return c;
        }
        return (ij2) invokeV.objValue;
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

    public void b(dj2 dj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((mj2) obj).d(dj2Var);
            }
        }
    }

    public void c(dj2 dj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((mj2) obj).b(dj2Var);
            }
        }
    }

    public void d(dj2 dj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, dj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((mj2) obj).f(dj2Var);
            }
        }
    }

    public void e(dj2 dj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, dj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((mj2) obj).c(dj2Var);
            }
        }
    }

    public void f(dj2 dj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, dj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((mj2) obj).g(dj2Var);
            }
        }
    }

    public void g(dj2 dj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, dj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((mj2) obj).a(dj2Var);
            }
        }
    }

    public void h(dj2 dj2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, dj2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((mj2) obj).e(dj2Var);
            }
        }
    }
}
