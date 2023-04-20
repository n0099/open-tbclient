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
public final class if2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile if2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<mf2> b;

    public if2() {
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

    public static if2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (if2.class) {
                    if (c == null) {
                        c = new if2();
                    }
                }
            }
            return c;
        }
        return (if2) invokeV.objValue;
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

    public void b(df2 df2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, df2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((mf2) obj).d(df2Var);
            }
        }
    }

    public void c(df2 df2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, df2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((mf2) obj).b(df2Var);
            }
        }
    }

    public void d(df2 df2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, df2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((mf2) obj).f(df2Var);
            }
        }
    }

    public void e(df2 df2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, df2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((mf2) obj).c(df2Var);
            }
        }
    }

    public void f(df2 df2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, df2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((mf2) obj).g(df2Var);
            }
        }
    }

    public void g(df2 df2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, df2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((mf2) obj).a(df2Var);
            }
        }
    }

    public void h(df2 df2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, df2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((mf2) obj).e(df2Var);
            }
        }
    }
}
