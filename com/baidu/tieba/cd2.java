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
/* loaded from: classes5.dex */
public final class cd2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cd2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<gd2> b;

    public cd2() {
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

    public static cd2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (cd2.class) {
                    if (c == null) {
                        c = new cd2();
                    }
                }
            }
            return c;
        }
        return (cd2) invokeV.objValue;
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

    public void b(xc2 xc2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xc2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((gd2) obj).d(xc2Var);
            }
        }
    }

    public void c(xc2 xc2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xc2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((gd2) obj).b(xc2Var);
            }
        }
    }

    public void d(xc2 xc2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, xc2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((gd2) obj).f(xc2Var);
            }
        }
    }

    public void e(xc2 xc2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, xc2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((gd2) obj).c(xc2Var);
            }
        }
    }

    public void f(xc2 xc2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, xc2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((gd2) obj).g(xc2Var);
            }
        }
    }

    public void g(xc2 xc2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, xc2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((gd2) obj).a(xc2Var);
            }
        }
    }

    public void h(xc2 xc2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, xc2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((gd2) obj).e(xc2Var);
            }
        }
    }
}
