package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.WeakHashMap;
/* loaded from: classes6.dex */
public class hc0 {
    public static /* synthetic */ Interceptable $ic;
    public static hc0 b;
    public static WeakHashMap<Object, List<fc0>> c;
    public transient /* synthetic */ FieldHolder $fh;
    public ic0 a;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final hc0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-751920170, "Lcom/baidu/tieba/hc0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-751920170, "Lcom/baidu/tieba/hc0$b;");
                    return;
                }
            }
            a = new hc0(null);
        }
    }

    public hc0() {
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
        c = new WeakHashMap<>();
        this.a = new ic0();
    }

    public static hc0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                b = b.a;
            }
            return b;
        }
        return (hc0) invokeV.objValue;
    }

    public /* synthetic */ hc0(a aVar) {
        this();
    }

    public void b(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, obj) != null) || obj == null || c.isEmpty()) {
            return;
        }
        this.a.c(c, obj);
    }

    public void e(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, obj) == null) && obj != null && !c.isEmpty() && c.containsKey(obj)) {
            this.a.e(c, obj);
        }
    }

    public void c(Object obj, Class<?> cls, int i, ec0 ec0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, cls, i, ec0Var) == null) && obj != null && cls != null && ec0Var != null && jc0.a(i)) {
            this.a.d(c, obj, cls, i, ec0Var);
        }
    }

    public synchronized void d(Object obj, Class<?> cls, ec0 ec0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, obj, cls, ec0Var) == null) {
            synchronized (this) {
                c(obj, cls, 1, ec0Var);
            }
        }
    }
}
