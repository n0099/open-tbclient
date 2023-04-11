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
public final class hf2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hf2 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lock a;
    public ArrayList<lf2> b;

    public hf2() {
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

    public static hf2 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (hf2.class) {
                    if (c == null) {
                        c = new hf2();
                    }
                }
            }
            return c;
        }
        return (hf2) invokeV.objValue;
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

    public void b(cf2 cf2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cf2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((lf2) obj).d(cf2Var);
            }
        }
    }

    public void c(cf2 cf2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cf2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((lf2) obj).b(cf2Var);
            }
        }
    }

    public void d(cf2 cf2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, cf2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((lf2) obj).f(cf2Var);
            }
        }
    }

    public void e(cf2 cf2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, cf2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((lf2) obj).c(cf2Var);
            }
        }
    }

    public void f(cf2 cf2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, cf2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((lf2) obj).g(cf2Var);
            }
        }
    }

    public void g(cf2 cf2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, cf2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((lf2) obj).a(cf2Var);
            }
        }
    }

    public void h(cf2 cf2Var) {
        Object[] a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, cf2Var) == null) && (a = a()) != null) {
            for (Object obj : a) {
                ((lf2) obj).e(cf2Var);
            }
        }
    }
}
