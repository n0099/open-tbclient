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
/* loaded from: classes4.dex */
public class gb0 {
    public static /* synthetic */ Interceptable $ic;
    public static gb0 b;
    public static WeakHashMap<Object, List<eb0>> c;
    public transient /* synthetic */ FieldHolder $fh;
    public hb0 a;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final gb0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-781472842, "Lcom/baidu/tieba/gb0$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-781472842, "Lcom/baidu/tieba/gb0$b;");
                    return;
                }
            }
            a = new gb0(null);
        }
    }

    public /* synthetic */ gb0(a aVar) {
        this();
    }

    public static gb0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                b = b.a;
            }
            return b;
        }
        return (gb0) invokeV.objValue;
    }

    public void b(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, obj) == null) || obj == null || c.isEmpty()) {
            return;
        }
        this.a.c(c, obj);
    }

    public void c(Object obj, Class<?> cls, int i, db0 db0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, cls, i, db0Var) == null) || obj == null || cls == null || db0Var == null || !ib0.a(i)) {
            return;
        }
        this.a.d(c, obj, cls, i, db0Var);
    }

    public synchronized void d(Object obj, Class<?> cls, db0 db0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, obj, cls, db0Var) == null) {
            synchronized (this) {
                c(obj, cls, 1, db0Var);
            }
        }
    }

    public void e(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, obj) == null) || obj == null || c.isEmpty() || !c.containsKey(obj)) {
            return;
        }
        this.a.e(c, obj);
    }

    public gb0() {
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
        this.a = new hb0();
    }
}
